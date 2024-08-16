package com.dc.evans.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Reader;
import java.nio.charset.Charset;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Vector;

import javax.edi.bind.annotations.EDIMessage;
import javax.edi.bind.util.BufferedSegmentIterator;
import javax.edi.bind.util.SegmentIterator;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.vfs2.FileObject;
import org.apache.commons.vfs2.FileSystemOptions;
import org.apache.commons.vfs2.Selectors;
import org.apache.commons.vfs2.impl.StandardFileSystemManager;
import org.apache.commons.vfs2.provider.sftp.IdentityInfo;
import org.apache.commons.vfs2.provider.sftp.SftpFileSystemConfigBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import com.dc.evans.edi.model.x12.edi.IEDIMessage;
import com.dc.evans.edi.model.x12.segment.GroupEnvelopeHeader;
import com.dc.evans.edi.model.x12.segment.GroupEnvelopeTrailer;
import com.dc.evans.edi.model.x12.segment.InterchangeEnvelopeHeader;
import com.dc.evans.edi.model.x12.segment.InterchangeEnvelopeTrailer;
import com.dc.evans.edi.model.x12.segment.TransactionSetHeader;
import com.dc.evans.edi.model.x12.segment.TransactionSetTrailer;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import com.jcraft.jsch.SftpException;
import com.xxl.job.core.log.XxlJobLogger;

import jakarta.annotation.PostConstruct;

/**
 * General utils class
 * 
 * @author Jayesh Jain, Tirnav Solutions, Mumbai
 *
 */
@Component
@Configuration
public class Utils {

	private static final Logger LOG = LoggerFactory.getLogger(Utils.class);

	private static String ftp;
    private static String ftpUserName;
    private static String remoteDir;
    private static String archiveDir;
    private static String sshKey;
    private static String localDir;

    @Value("${sftp.host}")
    private String ftpInstance;

    @Value("${sftp.userName}")
    private String ftpUserNameInstance;

    @Value("${sftp.dir}")
    private String remoteDirInstance;
    
    @Value("${sftp.archiveDir}")
    private String archiveDirInstance;

    @Value("${sftp.sshKey}")
    private String sshKeyInstance;

    @Value("${ediDownloadPath}")
    private String localDirInstance;

    @PostConstruct
    public void init() {
        ftp = ftpInstance;
        ftpUserName = ftpUserNameInstance;
        remoteDir = remoteDirInstance;
        archiveDir = archiveDirInstance;
        sshKey = sshKeyInstance;
        localDir = localDirInstance;
    }
	
	public static List<String> downloadFiles() throws Exception {
		List<String> fileNames = new ArrayList<>();
		JSch jsch = new JSch();
        Session session = null;
        ChannelSftp channelSftp = null;
        
		try {
		    // Ensure local directory exists
		    String localDirPath = Optional.ofNullable(localDir).orElse("");
		    File localDir = new File(localDirPath + File.separator + "received");
		    if (!localDir.exists()) {
		    	LOG.info("localDir: {} does not exist. Creating the directory", localDir.getPath());
		        localDir.mkdirs();
		    }
		    
		    LOG.info("Loading SSH Key File: {}", sshKey);
		 // Load the private key
            jsch.addIdentity(sshKey);
            
            // Create the session
            session = jsch.getSession(ftpUserName, ftp, 22);
            
            // Set properties for the session
            java.util.Properties config = new java.util.Properties();
            config.put("StrictHostKeyChecking", "no"); // Disable host key checking for simplicity
            session.setConfig(config);
            
            // Set the timeout to 30 seconds (30000 milliseconds)
            session.connect(60000);
            
            // Connect to the session
            session.connect();
            LOG.info("Connected to the SFTP server.");

            // Open the SFTP channel
            channelSftp = (ChannelSftp) session.openChannel("sftp");
            channelSftp.connect();

            LOG.info("SFTP channel opened.");
            
            // Download a file from the remote server
         // List files in the remote directory
            Vector<ChannelSftp.LsEntry> files = channelSftp.ls(remoteDir);
		    
		    if (files.size() == 0) {
		        return new ArrayList<>();  // No files to download
		    }
		    
            for (ChannelSftp.LsEntry entry : files) {
                if (!entry.getAttrs().isDir()) { // Skip directories
                    String remoteFilePath = remoteDir + entry.getFilename();
                    String localFilePath = localDir + File.separator + entry.getFilename();
                    String archiveFilePath = archiveDir + entry.getFilename();

                    // Download the file
                    channelSftp.get(remoteFilePath, localFilePath);
                    fileNames.add(localFilePath);
                    LOG.info("Downloaded: " + entry.getFilename());

                    // Move the file to the archive directory
                    channelSftp.rename(remoteFilePath, archiveFilePath);
                    LOG.info("Moved to archive: " + entry.getFilename());
                }
            }

		} catch (Exception ex) {
			ex.printStackTrace();
		    LOG.error("Error downloading files: " + ex.getMessage(), ex);
		    LOG.info("Error downloading files: " + ex.getMessage(), ex);
		} finally {
			if (channelSftp != null && channelSftp.isConnected()) {
                channelSftp.disconnect();
                LOG.info("SFTP channel disconnected.");
            }
            if (session != null && session.isConnected()) {
                session.disconnect();
                LOG.info("Session disconnected.");
            }
		}
		return fileNames;
	}
	
	/**
	 * Method to upload the file to Wayfair FTP. It upload the file to Wayfair
	 * incoming folder.
	 * 
	 * @param ackFiles
	 * @param userName
	 * @param password
	 */
	public static void uploadFile(File ackFiles) {

		StandardFileSystemManager manager = new StandardFileSystemManager();
		try {
			manager.init();

			FileObject local = manager.resolveFile(ackFiles.getPath());
			FileSystemOptions opts = new FileSystemOptions();

			//ClassPathResource clr = new ClassPathResource(amazonSSHKeyDownload);
			
			IdentityInfo myIdentityInfo = new IdentityInfo(new File(sshKey));
			
			SftpFileSystemConfigBuilder.getInstance(). setIdentityProvider(opts, myIdentityInfo);
			SftpFileSystemConfigBuilder.getInstance().setStrictHostKeyChecking(opts, "no");
			SftpFileSystemConfigBuilder.getInstance().setUserDirIsRoot(opts, false);
			SftpFileSystemConfigBuilder.getInstance().setDisableDetectExecChannel(opts,true);
			FileObject remote = manager.resolveFile("sftp://" + ftpUserName.trim() + 
													"@" + ftp + "/upload/" + ackFiles.getName(),opts);

			remote.copyFrom(local, Selectors.SELECT_SELF);

			remote.close();

			LOG.info("The file " + ackFiles.getName() + " is uploaded successfully.");

		} catch (IOException ex) {
			LOG.error("uploadFileTobfd Error:", ex);
			LOG.error("The file " + ackFiles.getName() + " is uploaded unsuccessfully.");
		} finally {
			manager.close();
		}
	}
	
	/**
	 * This method will delete the file after it has been processed.
	 * 
	 * @param customerId
	 * @param ftpUsername
	 * @param ftpPassword
	 * @param processedOrderFile
	 * @throws Exception
	 */
	public static void deleteFile(List<String> processedOrderFile) throws Exception {

		StandardFileSystemManager manager = new StandardFileSystemManager();
		try {
			manager.init();

			FileSystemOptions opts = new FileSystemOptions();

			//ClassPathResource clr = new ClassPathResource("ssh_key/rsa_amazon_edi");
			
			IdentityInfo myIdentityInfo = new IdentityInfo(new File(sshKey));
			
			SftpFileSystemConfigBuilder.getInstance(). setIdentityProvider(opts, myIdentityInfo);
			SftpFileSystemConfigBuilder.getInstance().setStrictHostKeyChecking(opts, "no");
			SftpFileSystemConfigBuilder.getInstance().setUserDirIsRoot(opts, false);
			SftpFileSystemConfigBuilder.getInstance().setDisableDetectExecChannel(opts,true);
			FileObject localFileObject = manager.resolveFile("sftp://" + ftpUserName.trim() + 
					"@" + ftp + "/download/",opts);
			
			FileObject[] children = localFileObject.getChildren();

			if (children.length == 0) {
				return;
			}

			for (int i = 0; i < children.length; i++) {
				String fileName = children[i].getName().getBaseName();
				if (processedOrderFile.contains(fileName)) {
					boolean isDeleted = children[i].delete();
					if (isDeleted) {
						LOG.info("EDI File: " + fileName + " has been deleted from the FTP folder");
					} else {
						LOG.info("EDI File: " + fileName + " could not been deleted from the FTP folder");
					}
				} else {
					if (Instant.now().minus(7, ChronoUnit.DAYS)
							.isAfter(new Date(children[i].getContent().getLastModifiedTime()).toInstant())) {
						boolean isDeleted = children[i].delete();
						if (isDeleted) {
							LOG.info("EDI File: " + fileName + " has been deleted from the FTP folder");
						} else {
							LOG.info("EDI File: " + fileName + " could not been deleted from the FTP folder");
						}
					}
				}
			}

		} catch (IOException ex) {
			LOG.error("Error while deleting Order EDI file:", ex);
		} finally {
			manager.close();
		}
	}
	
	/**
	 * Method to populate the InterchangeEnvelopeTrailer i.e. IEA segment
	 * 
	 * @param controlNumber
	 * @return
	 */
	public static InterchangeEnvelopeTrailer populateInterchangeEnvelopeTrailer(String controlNumber) {
		InterchangeEnvelopeTrailer itrail = new InterchangeEnvelopeTrailer();
		itrail.setInterchangeControlNumber(controlNumber);
		itrail.setNumberOfIncludedGroups("1");
		return itrail;
	}

	/**
	 * Method to populate the GroupEnvelopeTrailer i.e. GE segment
	 * 
	 * @param randomGroupId
	 * @param noOfTransaction
	 * @return
	 */
	public static GroupEnvelopeTrailer populateGroupEnvelopeTrailer(String randomGroupId, int noOfTransaction) {
		GroupEnvelopeTrailer genv = new GroupEnvelopeTrailer();
		genv.setGroupControlNumber(randomGroupId);
		genv.setNumberOfTransactionSets(String.valueOf(noOfTransaction));
		return genv;
	}

	/**
	 * Method to populate the GroupEnvelopeHeader i.e. GS segment
	 * 
	 * @param sender
	 * @param receiver
	 * @param randomGroupId
	 * @return
	 * @throws ParseException
	 */
	public static GroupEnvelopeHeader populateGroupEnvelopeHeader(String sender, String receiver, String randomGroupId,
			String functionalCode, String versionNumber) throws ParseException {
		GroupEnvelopeHeader group = new GroupEnvelopeHeader();
		group.setFunctionalIDCode(functionalCode);
		group.setApplicationSendersCode(sender);
		group.setApplicationReceiversCode(receiver);
		group.setDate(new SimpleDateFormat("yyMMdd").parse(new SimpleDateFormat("yyMMdd").format(new Date())));
		group.setTime(new SimpleDateFormat("hhmm").format(new Date()));
		group.setGroupControlNumber(randomGroupId);
		group.setResponsibleAgencyCode("X");
		group.setVersionReleaseIndustryIdentifierCode(versionNumber);
		return group;
	}

	/**
	 * Method to populate the InterchangeEnvelopeHeader i.e. ISA segment
	 * 
	 * @param sender 
	 * @param receiver
	 * @param controlNumber
	 * @param receiverISAQualifier
	 * @param senderISAQualifier
	 * @return
	 * @throws ParseException
	 */
	public static InterchangeEnvelopeHeader populateInterchangeEnvelopeHeader(String sender, String receiver,
			String controlNumber, String testIndicator, String subElementSeparator, String senderISAQualifier,
			String receiverISAQualifier, String versionNumber) throws ParseException {
		InterchangeEnvelopeHeader header = new InterchangeEnvelopeHeader();
		header.setAuthorizationInformationQualifier("00");
		header.setAuthorizationInformation("          ");
		header.setSecurityInformationQualifier("00");
		header.setSecurityInformation("          ");
		header.setSenderInterchangeIDQualifier(senderISAQualifier);
		header.setInterchangeSenderID(StringUtils.rightPad(sender, 15, ' '));
		header.setReceiverInterchangeIDQualifier(receiverISAQualifier);
		header.setInterchangeReceiverID(StringUtils.rightPad(receiver, 15, ' '));
		header.setInterchangeDate(
				new SimpleDateFormat("yyMMdd").parse(new SimpleDateFormat("yyMMdd").format(new Date())));
		header.setInterchangeTime(new SimpleDateFormat("hhmm").format(new Date()));
		header.setInterchangeControlID("<");
		header.setInterchangeVersionNumber(versionNumber);
		header.setInterchangeControlNumber(controlNumber);
		header.setiSAAcknowledgmentRequested("0");
		header.setTestIndicator(testIndicator.trim());
		header.setSubelementSeparator(subElementSeparator.trim());
		return header;
	}

	/**
	 * Method to populate the TransactionSetHeader i.e. ST segment
	 * 
	 * @param randomTransactionControlNumber
	 * @param ediType
	 * @return
	 */
	public static TransactionSetHeader populateTransactionSegmentHeader(String randomTransactionControlNumber,
			String ediType) {
		TransactionSetHeader tHead = new TransactionSetHeader();
		tHead.setTransactionSetControlNumber(randomTransactionControlNumber);
		tHead.setTransactionSetIdentifierCode(ediType);
		return tHead;
	}

	/**
	 * Method to populate the TransactionSetTrailer i.e. SE segment
	 * 
	 * @param noOfSegment
	 * @param controlNumber
	 * @return
	 */
	public static TransactionSetTrailer populateTransactionSetTrailer(int noOfSegment, String controlNumber) {
		TransactionSetTrailer tr = new TransactionSetTrailer();
		tr.setNumberOfIncludedSegments(String.valueOf(noOfSegment));
		tr.setTransactionControlNumber(controlNumber);
		return tr;
	}

	/**
	 * This method save the generated EDI String to the file. The folder structure
	 * is <base dir>/<year_month>/<date>/<customerid>/<filename>
	 * 
	 * @param customerId
	 * @param ediContent
	 * @param fileName
	 * @return
	 * @throws IOException
	 */
	public static File outputEDIContentToFile(String customerId, String ediContent, String fileName)
			throws IOException {
		String outputFileName = Optional.ofNullable(localDir).orElse("") + LocalDate.now().getYear() + "_"
				+ LocalDate.now().getMonth().getValue() + File.separator + LocalDate.now().getDayOfMonth()
				+ File.separator + customerId + File.separator + fileName;
		File ackFile = new File(outputFileName);
		if (!ackFile.exists()) {
			ackFile.getParentFile().mkdirs();
		}
		ackFile.createNewFile();
		FileUtils.writeStringToFile(ackFile, ediContent, Charset.defaultCharset());
		return ackFile;
	}

	/**
	 * This method return the EDI file type from the downloaded files.
	 * 
	 * @param reader
	 * @param clz
	 * @return
	 * @throws FileNotFoundException
	 */
	public static <T> EDIFileIdentifier getEDIType(Reader reader, Class<IEDIMessage> clz) throws FileNotFoundException {
		EDIFileIdentifier identifier = new EDIFileIdentifier();
		EDIMessage ediMessage = clz.getAnnotation(EDIMessage.class);
		
		LOG.info("Identifying the EDI Message type, Segment Delimiter: " + ediMessage.segmentDelimiter());
		XxlJobLogger.log("Identifying the EDI Message type, Segment Delimiter: " + ediMessage.segmentDelimiter());
		
		BufferedSegmentIterator bufferedIterator = new BufferedSegmentIterator(
				new SegmentIterator(reader, ediMessage.segmentDelimiter(), true));

		while (bufferedIterator.hasNext()) {
			if (!bufferedIterator.hasNext()) {
				LOG.info("Could not identify the file");
				XxlJobLogger.log("Could not identify the file");
				return identifier;
			}

			String line = bufferedIterator.next();
			LOG.info("Reading line: " + line.trim());
			// match up the field with the line...
			if (line.trim().toLowerCase().startsWith("st")) {
				identifier.setFileType(line.split("\\*")[1]);
				LOG.info("Found ST: " + line.split("\\*")[1]);
			} else if (line.trim().toLowerCase().startsWith("isa")) {
				LOG.info("Found ISA: " + line.split("\\*")[8]);
				identifier.setCustomerISAId(line.split("\\*")[8].trim());
			} else if (line.trim().toLowerCase().startsWith("gs")) {
				LOG.info("Found GSA: " + line.split("\\*")[8]);
				identifier.setEdiVersion(Integer.parseInt(line.split("\\*")[8].trim()));
			}

			if (StringUtils.isNotBlank(identifier.getCustomerISAId())
					&& StringUtils.isNotBlank(identifier.getFileType())) {
				break;
			}
		}
		
		LOG.info("Returning Identifying the EDI Message type. File Type: " + identifier.getFileType());
		XxlJobLogger.log("Returning Identifying the EDI Message type. File Type: " + identifier.getFileType());
		
		return identifier;
	}

	public static void main(String[] args) {
        int port = 22;
        
        JSch jsch = new JSch();
        Session session = null;
        ChannelSftp channelSftp = null;

        try {
            // Load the private key
            jsch.addIdentity(sshKey);
            
            // Create the session
            session = jsch.getSession(ftpUserName, ftp, port);
            
            // Set properties for the session
            java.util.Properties config = new java.util.Properties();
            config.put("StrictHostKeyChecking", "no"); // Disable host key checking for simplicity
            session.setConfig(config);
            
            // Connect to the session
            session.connect();
            System.out.println("Connected to the SFTP server.");

            // Open the SFTP channel
            channelSftp = (ChannelSftp) session.openChannel("sftp");
            channelSftp.connect();

            System.out.println("SFTP channel opened.");
            
            // Download a file from the remote server
         // List files in the remote directory
            Vector<ChannelSftp.LsEntry> files = channelSftp.ls(remoteDir);
            for (ChannelSftp.LsEntry entry : files) {
                if (!entry.getAttrs().isDir()) { // Skip directories
                    String remoteFilePath = remoteDir + entry.getFilename();
                    String localFilePath = localDir + entry.getFilename();
                    String archiveFilePath = archiveDir + entry.getFilename();

                    // Download the file
                    channelSftp.get(remoteFilePath, localFilePath);
                    System.out.println("Downloaded: " + entry.getFilename());

                    // Move the file to the archive directory
                    channelSftp.rename(remoteFilePath, archiveFilePath);
                    System.out.println("Moved to archive: " + entry.getFilename());
                }
            }
            System.out.println("File downloaded successfully.");

        } catch (JSchException e) {
            System.err.println("JSch Exception: " + e.getMessage());
            e.printStackTrace();
        } catch (SftpException e) {
            System.err.println("SFTP Exception: " + e.getMessage());
            e.printStackTrace();
        } finally {
            if (channelSftp != null && channelSftp.isConnected()) {
                channelSftp.disconnect();
                System.out.println("SFTP channel disconnected.");
            }
            if (session != null && session.isConnected()) {
                session.disconnect();
                System.out.println("Session disconnected.");
            }
        }
    }
}
