package com.dc.evans.util;
import java.io.File;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse;
import java.nio.file.Path;
import java.time.Duration;
import java.util.Map;
import java.util.Optional;

public class HttpClientUtil {

	// Enum to restrict supported HTTP methods
    public enum HttpProtocol {
        GET, POST, PUT, DELETE
    }
    
    public static HttpResponse<String> sendHttpRequest(HttpProtocol protocol, String endpoint) throws Exception {
    	return sendHttpRequest(protocol, endpoint, null, null);
    }
    
    public static HttpResponse<String> sendHttpRequest(HttpProtocol protocol, String endpoint, Map<String, String> headers) throws Exception {
    	return sendHttpRequest(protocol, endpoint, headers, null);
    }
    
    public static HttpResponse<String> sendHttpRequest(HttpProtocol protocol, String endpoint, Map<String, String> headers, Object payload) throws Exception {
        HttpClient client = HttpClient.newHttpClient();

        HttpRequest.Builder requestBuilder = HttpRequest.newBuilder()
                .uri(URI.create(endpoint))
                .timeout(Duration.ofMinutes(5));

        // Set headers
        if (headers != null) {
            headers.forEach(requestBuilder::header);
        }

        // Set method and payload based on HttpProtocol
        switch (protocol) {
            case GET:
                requestBuilder.GET();
                break;
            case POST:
                requestBuilder.POST(createBodyPublisher(payload));
                break;
            case PUT:
                requestBuilder.PUT(createBodyPublisher(payload));
                break;
            case DELETE:
                if (payload == null) {
                    requestBuilder.DELETE();
                } else {
                    requestBuilder.method("DELETE", createBodyPublisher(payload));
                }
                break;
            default:
                throw new IllegalArgumentException("Unsupported HTTP method: " + protocol);
        }

        HttpRequest request = requestBuilder.build();
        return client.send(request, HttpResponse.BodyHandlers.ofString());
    }
    
    private static HttpRequest.BodyPublisher createBodyPublisher(Object payload) throws Exception {
        if (payload == null) {
            return HttpRequest.BodyPublishers.noBody();
        } else if (payload instanceof String) {
            return HttpRequest.BodyPublishers.ofString((String) payload);
        } else if (payload instanceof Path) {
            return HttpRequest.BodyPublishers.ofFile((Path) payload);
        } else if (payload instanceof byte[]) {
            return HttpRequest.BodyPublishers.ofByteArray((byte[]) payload);
        } else {
            throw new IllegalArgumentException("Unsupported payload type: " + payload.getClass());
        }
    }

    private static HttpRequest.BodyPublisher getBodyPublisher(Optional<Object> payload) throws Exception {
        if (payload.isEmpty()) {
            return BodyPublishers.noBody();
        } else if (payload.get() instanceof String) {
            return BodyPublishers.ofString((String) payload.get());
        } else if (payload.get() instanceof byte[]) {
            return BodyPublishers.ofByteArray((byte[]) payload.get());
        } else if (payload.get() instanceof File) {
            return BodyPublishers.ofFile(((File) payload.get()).toPath());
        } else {
            throw new IllegalArgumentException("Unsupported payload type: " + payload.get().getClass().getName());
        }
    }
}
