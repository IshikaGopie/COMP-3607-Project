package com.filefixer;


import java.nio.file.Files;
import java.nio.file.Paths;

public class directoryHandler implements directoryHandlerInterface{

    public void newDirectory(String path){
        try{
            Files.createDirectories(Paths.get(path));
        }catch(Exception e){
            System.out.println("ERROR: " + e.getMessage());
        }
    }
}
