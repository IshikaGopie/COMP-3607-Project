package com.filefixer;

import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * This class handles the creation of one or more directories.
 */
public class DirectoryHandler implements DirectoryHandlerInterface{
    /**
     * Creates one or multiple directories based on folder-path given.
     * @param path A folder-path.
     */
    public void newDirectory(String path){
        try{
            Files.createDirectories(Paths.get(path));
        }catch(Exception e){
            System.out.println("ERROR: " + e.getMessage());
        }
    }
}
