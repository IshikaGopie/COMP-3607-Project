package com.filefixer;

import java.io.File;
import java.util.Collection;

/**
 * This class handles operations for parsing a collection of CSV files.
 */
public class CsvCollectionHandler implements CsvCollectionHandlerInterface {
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
        }
        return chosenFile.getPath();
	}
}
