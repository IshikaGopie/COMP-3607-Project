package com.filefixer;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class ZipFolder implements ZipFolderInterface{
    private ZipInputStream zipInputStream;
    private FileInputStream zipFile;
    private byte[] buffer = new byte[2048];

    private void getZipInputStream(File zippedFile){
        try{
            zipFile = new FileInputStream(zippedFile);
            zipInputStream = new ZipInputStream(zipFile);
        }catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();   
        }
    }

    private void getZipOutputeStream(ZipEntry zipEntry){
        try{
            File newFile = new File(zipEntry.getName());
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

    private void getZipDirectory(ZipEntry zipEntry){
        try{
            Files.createDirectories(Paths.get(zipEntry.getName()));
        }catch(Exception e){
            System.out.println("ERROR: " + e.getMessage());
        }
    }

    public void extractZip(File zippedFile){
        getZipInputStream(zippedFile);
        try{
            ZipEntry zipEntry = zipInputStream.getNextEntry();
            while (zipEntry != null) {
                if (zipEntry.isDirectory()) {
                    getZipDirectory(zipEntry);
                } else{
                    getZipOutputeStream(zipEntry);
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