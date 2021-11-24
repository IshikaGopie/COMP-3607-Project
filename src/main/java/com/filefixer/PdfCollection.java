package com.filefixer;

import java.io.File;
import java.util.Collection;

import org.apache.commons.io.FileUtils;
/**
 * A 'fileCollectionStrategy' used for the collection of PDF files.
 */
public class PdfCollection implements FileCollectionInterface{

    
    /** 
     * @param path The folder-path where the PDF files are located.
     */
    @Override
    public Collection<File> getFiles(String path) {
        File dir = new File(path);
		String[] extension = new String[] { "pdf" };
	    Collection<File> pdfFiles = FileUtils.listFiles(dir, extension, false);
	    if(pdfFiles.size() < 1) {
	    	System.out.println("There is no PDF file present within the folder specified.");
            System.out.println("Please input the PDF files to be renamed then restart the program.");
            System.exit(0);
	    }
        return pdfFiles;
    }
}
