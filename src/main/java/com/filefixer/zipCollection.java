package com.filefixer;

import java.io.File;
import java.util.Collection;

import org.apache.commons.io.FileUtils;

public class zipCollection implements fileCollectionInterface{

    @Override
    public Collection<File> get_Files(String path) {
        File dir = new File(path);
		String[] extension = new String[] { "zip" };
	    Collection<File> zipFiles = FileUtils.listFiles(dir, extension, false);
        /*for (File file : zipFiles) {
			System.out.println("file: " + file.getPath());
		}*/
        return zipFiles;
    }
    
}
