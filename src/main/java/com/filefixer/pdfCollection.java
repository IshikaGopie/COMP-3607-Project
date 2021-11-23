package com.filefixer;

import java.io.File;
import java.util.Collection;

import org.apache.commons.io.FileUtils;
/**
 * A 'fileCollectionStrategy' used for the collection of PDF files.
 */
public class pdfCollection implements fileCollectionInterface{

    
    /** 
     * Returns all PDF files present within a directory.
     * @param path The folder-path of the directory.
     * @return {@link Collection}<{@link File}>: A collection of all PDF files.
     */
    @Override
    public Collection<File> getFiles(String path) {
        File dir = new File(path);
		String[] extension = new String[] { "pdf" };
	    Collection<File> pdfFiles = FileUtils.listFiles(dir, extension, false);
        return pdfFiles;
    }
}
