package com.dc.evans.service;

import java.io.File;
import java.nio.charset.StandardCharsets;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

@Service
public class MailServiceImpl {
	
	@Autowired
	private JavaMailSender javaMailSender;

	private final Logger logger = LoggerFactory.getLogger(getClass());

	@Value("${spring.mail.username}")
	private String fromEmail;

	@Async
	public void sendErrorEmail(String subject, String body, Throwable error) {
		logger.debug("Sending error email");
		// Prepare message using a Spring helper
		MimeMessage mimeMessage = javaMailSender.createMimeMessage();

		String content = body + "<br><br>" + error.getMessage() + "<br><br>Stack Trace:<br> "
				+ ExceptionUtils.getStackTrace(error);

		try {
			MimeMessageHelper message = new MimeMessageHelper(mimeMessage, StandardCharsets.UTF_8.name());
			message.setTo("jain.jayesh@outlook.com");
			message.setFrom(new InternetAddress("jayeshjain1681@gmail.com", "Green Mobile GSP"));
			message.setSubject(subject);
			message.setText(content, Boolean.TRUE);

			javaMailSender.send(mimeMessage);

			logger.info("Sent email to Developer");
		} catch (Exception e) {
			e.printStackTrace();
			if (logger.isDebugEnabled()) {
				logger.warn("Email could not be sent to Developer");
			} else {
				logger.warn("Email could not be sent to Developer");
			}
		}
	}

	@Async
	public void sendErrorEmail(String[] to,String subject, String body, Throwable error, File attachment) {
		logger.debug("Sending error email");
		// Prepare message using a Spring helper
		MimeMessage mimeMessage = javaMailSender.createMimeMessage();

		String content = body + "<br><br>" + error.getMessage() + "<br><br>Stack Trace:<br> "
				+ ExceptionUtils.getStackTrace(error);

		try {
			// Enable multipart mode
            MimeMessageHelper message = new MimeMessageHelper(mimeMessage, true, StandardCharsets.UTF_8.name());

			message.setTo(to);
			message.setFrom(new InternetAddress(fromEmail, "PK Enterprises Automation"));
			message.setSubject(subject);
			message.setText(content, Boolean.TRUE);
			
			if (attachment != null) {
                message.addAttachment(attachment.getName(), attachment);
            }

			javaMailSender.send(mimeMessage);

			logger.info("Sent email to Developer");
		} catch (Exception e) {
			e.printStackTrace();
			if (logger.isDebugEnabled()) {
				logger.warn("Email could not be sent to Developer");
			} else {
				logger.warn("Email could not be sent to Developer");
			}
		}
	}
	
	@Async
	public void sendErrorEmail(String[] to,String subject, String content) {
		logger.debug("Sending error email");
		// Prepare message using a Spring helper
		MimeMessage mimeMessage = javaMailSender.createMimeMessage();

		try {
			// Enable multipart mode
            MimeMessageHelper message = new MimeMessageHelper(mimeMessage, true, StandardCharsets.UTF_8.name());

			message.setTo(to);
			message.setFrom(new InternetAddress(fromEmail, "DataCeva Automation"));
			message.setSubject(subject);
			message.setText(content, Boolean.FALSE);
			
			javaMailSender.send(mimeMessage);

			logger.info("Sent email to Developer");
		} catch (Exception e) {
			e.printStackTrace();
			if (logger.isDebugEnabled()) {
				logger.warn("Email could not be sent to Developer");
			} else {
				logger.warn("Email could not be sent to Developer");
			}
		}
	}

	@Async
	public void sendErrorEmail(String subject, String body) {
		logger.debug("Sending error email");
		// Prepare message using a Spring helper
		MimeMessage mimeMessage = javaMailSender.createMimeMessage();

		try {
			MimeMessageHelper message = new MimeMessageHelper(mimeMessage, StandardCharsets.UTF_8.name());
			message.setTo("jain.jayesh@outlook.com");
			message.setFrom(new InternetAddress("jayeshjain1681@gmail.com", "Green Mobile GSP"));
			message.setSubject(subject);
			message.setText(body, Boolean.TRUE);

			javaMailSender.send(mimeMessage);

			logger.info("Sent email to Developer");
		} catch (Exception e) {
			e.printStackTrace();
			if (logger.isDebugEnabled()) {
				logger.warn("Email could not be sent to Developer");
			} else {
				logger.warn("Email could not be sent to Developer");
			}
		}
	}

	@Async
	public void sendEmail(String[] to, String subject, String content, boolean isHtml) {
		logger.info("Sending email to: {}", to);
		// Prepare message using a Spring helper
		MimeMessage mimeMessage = javaMailSender.createMimeMessage();

		try {
			MimeMessageHelper message = new MimeMessageHelper(mimeMessage, StandardCharsets.UTF_8.name());
			message.setTo(to);
			message.setFrom(new InternetAddress("jayeshjain1681@gmail.com", "Green Mobile GSP"));
			message.setSubject(subject);
			message.setText(content, isHtml);

			javaMailSender.send(mimeMessage);

			logger.info("Sent email to {}", to);
		} catch (Exception e) {
			e.printStackTrace();
			if (logger.isDebugEnabled()) {
				logger.warn("Email could not be sent to Developer");
			} else {
				logger.warn("Email could not be sent to Developer");
			}
		}
	}

	@Async
	public void sendEmail(String[] to, String subject, String content, boolean isHtml,File attachment) {
		logger.info("Sending email to: {}", to);
		// Prepare message using a Spring helper
		MimeMessage mimeMessage = javaMailSender.createMimeMessage();

		try {
			// Enable multipart mode
            MimeMessageHelper message = new MimeMessageHelper(mimeMessage, true, StandardCharsets.UTF_8.name());

			message.setTo(to);
			message.setFrom(new InternetAddress(fromEmail, "PK Enterprises Automation"));
			message.setSubject(subject);
			message.setText(content, isHtml);
			
			if (attachment != null) {
                message.addAttachment(attachment.getName(), attachment);
            }

			javaMailSender.send(mimeMessage);

			logger.info("Sent email to {}", to);
		} catch (Exception e) {
			e.printStackTrace();
			if (logger.isDebugEnabled()) {
				logger.warn("Email could not be sent to Developer");
			} else {
				logger.warn("Email could not be sent to Developer");
			}
		}
	}

	@Async
	public void sendEmail(String subject, String content) {
		logger.debug("Sending error email");
		// Prepare message using a Spring helper
		MimeMessage mimeMessage = javaMailSender.createMimeMessage();

		try {
			MimeMessageHelper message = new MimeMessageHelper(mimeMessage, StandardCharsets.UTF_8.name());
			message.setTo("jain.jayesh@outlook.com");
			message.setFrom(new InternetAddress(fromEmail, "Green Mobile GSP"));
			message.setSubject(subject);
			message.setText(content, Boolean.TRUE);

			javaMailSender.send(mimeMessage);

			logger.info("Sent email to Developer");
		} catch (Exception e) {
			e.printStackTrace();
			if (logger.isDebugEnabled()) {
				logger.warn("Email could not be sent to Developer");
			} else {
				logger.warn("Email could not be sent to Developer");
			}
		}
	}
}
