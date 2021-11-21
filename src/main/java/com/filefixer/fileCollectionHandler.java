package com.filefixer;

import java.io.File;
import java.util.Collection;

public class fileCollectionHandler implements fileCollectionHandlerInterface{
    //fileCollectionHandler
    public String getLastModified(Collection<File> files){
        File chosen_file = files.iterator().next();

        if(files.size() > 1){
            for(File file: files){
                if(chosen_file.lastModified() < file.lastModified()){
                    chosen_file = file;
                }
            }
        }else if(files.size() < 1){
            //need to implement error message.
        }
        return chosen_file.getPath();
    }

    @Override
    public String disallowCollection(Collection<File> files) {
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
