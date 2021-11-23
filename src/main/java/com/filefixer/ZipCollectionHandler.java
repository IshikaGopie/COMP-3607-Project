package com.filefixer;

import java.io.File;
import java.util.Collection;

/**
 * This class determines whether a ZIP folder is present in a file-collection.
 */
public class ZipCollectionHandler implements ZipCollectionHandlerInterface{
    /** 
     * Checks the ZIP collection to determine the amount of ZIP folders present.
     * The program will terminate if the amount of ZIP folders present is greater than 1.
     * If no ZIP folders are present, the method returns a null value to indicate as such.
     * If only one ZIP folder is found, this ZIP folder is returned.
     * @param files The collection of ZIP files to be parsed.
     * @return String: The file-path of the ZIP folder.
     */
    @Override
    public String zipCheck(Collection<File> files) {
        if(files.size() > 1){
            System.out.println("The program does not allow for multiple ZIP files. \n");
            System.out.println("Please remove any additional ZIP files then restart the program. \n");
            System.exit(0);
        }else if(files.size() < 1){
            return null;
        }
        return files.iterator().next().getPath();
    }
}
