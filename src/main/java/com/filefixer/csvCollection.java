package com.filefixer;

import java.io.File;
import java.util.Collection;

import org.apache.commons.io.FileUtils;

public class csvCollection implements fileCollectionInterface{
    
    @Override
    public Collection<File> get_Files(String path) {
        File dir = new File(path);
		String[] extension = new String[] { "csv" };
	    Collection<File> csvFiles = FileUtils.listFiles(dir, extension, false);
        /*for (File file : csvFiles) {
			System.out.println("file: " + file.getPath());
		}*/
        return csvFiles;
    }
    
}
