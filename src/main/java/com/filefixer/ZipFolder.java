package com.filefixer;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
/**
 * This class handles the extraction of a ZIP folder's contents.
 */
public class ZipFolder implements ZipFolderInterface{
    /**
     * See {@link java.util.zip.ZipInputStream}.
     */
    private ZipInputStream zipInputStream;
    /**
     * A buffer to hold each current ZIP file being extracted.
     */
    private byte[] buffer = new byte[2048];


    /**
     * See {@link zipPathHandler}.
     */
    private zipPathHandlerInterface zipPathHandler = new zipPathHandler();

    
    /** 
     * Creates a new ZipInputStream.
     * @param zipFile The current ZIP folder to be extracted.
     */
    private void getZipInputStream(File zipFile){
        try{
            zipInputStream = new ZipInputStream(new FileInputStream(zipFile));
        }catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();   
        }
    }

    
    /** 
     * Extracts the zipEntry to its destination file-path.
     * @param zipEntry The current ZIP file being extracted.
     */
    private void getZipOutputStream(ZipEntry zipEntry){
        try{
            File newFile = new File(zipPathHandler.modifyUnzipPath(zipEntry));
            FileOutputStream fos = new FileOutputStream(newFile);
            int len;
            while ((len = zipInputStream.read(buffer)) > 0){
                fos.write(buffer, 0, len);
            }
            fos.close();
        }catch(IOException e){
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    
    /** 
     * Extracts all contents of the ZIP file to their designated destination file-paths.
     * @param zipFile The current ZIP folder to be extracted.
     */
    public void extractZip(File zipFile){
        getZipInputStream(zipFile);
        try{
            ZipEntry zipEntry = zipInputStream.getNextEntry();
            while (zipEntry != null) {
                if (zipEntry.isDirectory()) {
                    //getZipDirectory(zipEntry);
                }else{
                    getZipOutputStream(zipEntry);
                }
                zipEntry = zipInputStream.getNextEntry();
            }
            zipInputStream.closeEntry();
            zipInputStream.close();
        }catch(IOException e){
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
