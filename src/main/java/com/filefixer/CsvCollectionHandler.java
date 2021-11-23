package com.filefixer;

import java.io.File;
import java.util.Collection;

/**
 * This class handles operations for parsing a collection of CSV files.
 */
public class csvCollectionHandler implements csvCollectionHandlerInterface {
    /**
     * Checks the CSV collection to determine the amount of CSV files present 
     * and returns the file-path of the last modified CSV file from a given file collection.
     * The program will terminate if no CSV folders are present.
     * @param files The collection of CSV files to be parsed.
     * @return String: The file-path of the last modified CSV file.
     */
    public String getLastModified(Collection<File> files){
        File chosenFile = files.iterator().next();

        if(files.size() > 1){
            for(File file: files){
                if(chosenFile.lastModified() < file.lastModified()){
                    chosenFile = file;
                }
            }
        }else if(files.size() < 1){
            System.out.println("There is no CSV file present within the 'filesToRename' folder.");
            System.out.println("Please input a CSV file to be parsed then restart the program.");
            System.exit(0);
        }
        return chosenFile.getPath();
	}
}
