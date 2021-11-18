package com.filefixer;

import java.io.File;
import java.util.Collection;

public class fileGetter implements fileGetterInterface{
    fileCollectionInterface fileCollectionStrategy;

    public fileGetter(fileCollectionInterface fileCollectionStrategy){
        this.fileCollectionStrategy = fileCollectionStrategy;
    } 

    public Collection<File> getFiles(String path) {
        Collection<File> files  = fileCollectionStrategy.get_Files(path);

        return files;
    }

    public void changeFileCollectionStrategy(fileCollectionInterface fileCollectionStrategy){
        this.fileCollectionStrategy = fileCollectionStrategy;
    }
}
