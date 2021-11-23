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
        return pdfFiles;
    }
}
