package com.filefixer;

import java.io.File;
import java.util.Collection;

public class zipCollectionHandler implements zipCollectionHandlerInterface{
    @Override
    public String disallow(Collection<File> files) {
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
