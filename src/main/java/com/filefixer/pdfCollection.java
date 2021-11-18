package com.filefixer;

import java.io.File;
import java.util.Collection;

import org.apache.commons.io.FileUtils;

public class pdfCollection implements fileCollectionInterface{

    @Override
    public Collection<File> get_Files(String path) {
        File dir = new File(path);
		String[] extension = new String[] { "pdf" };
	    Collection<File> pdfFiles = FileUtils.listFiles(dir, extension, false);
        for (File file : pdfFiles) {
			System.out.println("file: " + file.getPath());
		}
        return pdfFiles;
    }
}
