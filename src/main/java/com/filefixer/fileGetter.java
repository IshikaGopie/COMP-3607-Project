package com.filefixer;

import java.io.File;
import java.util.Collection;
/**
 * This class handles the creation of a file-collection based on the type of file specified. 
 * This class operates as the context class for the Strategy Design Pattern implemented.
 */
public class fileGetter implements fileGetterInterface{
    /**
     * The file-collection to be created. See {@link csvCollection}, {@link pdfCollection} and {@link zipCollection}.
     */
    private fileCollectionInterface fileCollectionStrategy;

    /**
     * @param fileCollectionStrategy See {@link #fileCollectionStrategy}.
     */
    public fileGetter(fileCollectionInterface fileCollectionStrategy){
        this.fileCollectionStrategy = fileCollectionStrategy;
    } 

    
    /** 
     * Creates and returns a collection of files based on the 'fileCollectionStrategy' received. See {@link #fileCollectionStrategy}.
     * @param path The folder-path of the files being requested.
     * @return {@link Collection}<{@link File}>: The collection of files.
     */
    public Collection<File> getFiles(String path) {
        Collection<File> files  = fileCollectionStrategy.getFiles(path);

        return files;
    }

    
    /** 
     * Changes the 'fileCollectionStrategy' being requested.
     * @param fileCollectionStrategy See {@link #fileCollectionStrategy}.
     */
    public void changeFileCollectionStrategy(fileCollectionInterface fileCollectionStrategy){
        this.fileCollectionStrategy = fileCollectionStrategy;
    }
}
