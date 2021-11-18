package com.filefixer;

import java.io.File;
import java.util.Collection;

public class fileGetter implements fileGetterInterface{
    fileCollectionINTERFACE fileCollectionStrategy;
    filePATHhandlerINTERFACE PATH = new filePATHhandler();

    public fileGetter(fileCollectionINTERFACE fileCollectionStrategy){
        this.fileCollectionStrategy = fileCollectionStrategy;
    } 

    public Collection<File> getFiles(String path) {
        Collection<File> files  = fileCollectionStrategy.get_Files(path);

        return files;
    }

    public void changeFileCollectionStrategy(fileCollectionINTERFACE fileCollectionStrategy){
        this.fileCollectionStrategy = fileCollectionStrategy;
    }
}
