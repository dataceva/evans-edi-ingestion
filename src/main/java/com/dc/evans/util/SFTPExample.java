package com.dc.evans.util;
import java.io.File;

import org.apache.commons.vfs2.FileObject;
import org.apache.commons.vfs2.FileSystemException;
import org.apache.commons.vfs2.FileSystemManager;
import org.apache.commons.vfs2.FileSystemOptions;
import org.apache.commons.vfs2.VFS;
import org.apache.commons.vfs2.provider.sftp.SftpFileSystemConfigBuilder;

public class SFTPExample {
    public static void main(String[] args) {
        // Specify the SFTP server details
        String hostname = "118.242.40.115";
        int port = 6022; // Replace with your custom SFTP port
        String username = "ecgridtest";
        String password = "TapJWVMOdeFxJIQL";

        // Create a FileSystemManager
        try {
            FileSystemManager fsManager = VFS.getManager();

            // Create an SFTP file system options object
            FileSystemOptions options = new FileSystemOptions();
            SftpFileSystemConfigBuilder.getInstance().setStrictHostKeyChecking(options, "no");
            SftpFileSystemConfigBuilder.getInstance().setIdentities(options, new File[0]);
            SftpFileSystemConfigBuilder.getInstance().setUserDirIsRoot(options, false);
            SftpFileSystemConfigBuilder.getInstance().setDisableDetectExecChannel(options,true);
            //SftpFileSystemConfigBuilder.getInstance().setDisableDetectExecChannel(options,true);

            // Create the SFTP URI
            String sftpUri = String.format("sftp://%s:%s@%s:%d/", username, password, hostname, port);

            // Resolve the SFTP file system
            FileObject remoteDir = fsManager.resolveFile(sftpUri, options);

            // Now you can work with the remote directory, e.g., list files or upload/download files
            FileObject[] files = remoteDir.getChildren();
            for (FileObject file : files) {
                System.out.println("File: " + file.getName().getBaseName());
            }

            // Close the file system when done
            //remoteDir.getFileSystem().close();

        } catch (FileSystemException e) {
            e.printStackTrace();
        }
    }
}
