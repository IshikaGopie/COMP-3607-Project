package com.filefixer;

import java.io.File;
import java.util.Collection;
import org.apache.commons.io.FileUtils;
/**
 * A 'fileCollectionStrategy' used for a collection of CSV files.
 */
public class CsvCollection implements FileCollectionInterface{


    /**
     * @param path The folder-path where the CSV files are located.
     */
    @Override
    public Collection<File> getFiles(String path) {
        File dir = new File(path);
		String[] extension = new String[] { "csv" };
	    Collection<File> csvFiles = FileUtils.listFiles(dir, extension, false);
        return csvFiles;
    }

}
