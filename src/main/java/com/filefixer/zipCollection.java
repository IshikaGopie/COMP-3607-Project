package com.filefixer;

import java.io.File;
import java.util.Collection;

import org.apache.commons.io.FileUtils;
/**
 * A 'fileCollectionStrategy' used for the collection of ZIP files.
 */
public class ZipCollection implements fileCollectionInterface{
    /** 
     * Returns all ZIP folders present within a directory.
     * @param path The folder-path of the directory.
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
