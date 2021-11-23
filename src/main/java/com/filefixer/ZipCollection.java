package com.filefixer;

import java.io.File;
import java.util.Collection;

import org.apache.commons.io.FileUtils;
/**
 * A 'fileCollectionStrategy' used for the collection of ZIP files.
 */
public class ZipCollection implements FileCollectionInterface{
    /** 
     * @param path The folder-path where the ZIP files are located.
     * @return {@link Collection}<{@link File}>: A collection of all ZIP files.
     */
    @Override
    public Collection<File> getFiles(String path) {
        File dir = new File(path);
		String[] extension = new String[] { "zip" };
	    Collection<File> zipFiles = FileUtils.listFiles(dir, extension, false);
        return zipFiles;
    }
    
}
