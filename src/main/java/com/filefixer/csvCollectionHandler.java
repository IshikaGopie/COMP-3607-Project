package com.filefixer;

import java.io.File;
import java.util.Collection;

public class csvCollectionHandler implements csvCollectionHandlerInterface{
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
}
