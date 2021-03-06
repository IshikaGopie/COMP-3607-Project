package com.filefixer;

import java.io.File;
import java.util.Collection;
/**
 * This class handles the creation of a file-collection based on the type of file specified. 
 * This class operates as the context class for the Strategy Design Pattern implemented.
 */
public class FileGetter implements FileGetterInterface{
    /**
     * The file-collection to be created. See {@link CsvCollection}, {@link PdfCollection} and {@link ZipCollection}.
     */
    private FileCollectionInterface fileCollectionStrategy;

    /**
     * @param fileCollectionStrategy See {@link #fileCollectionStrategy}.
     */
    public FileGetter(FileCollectionInterface fileCollectionStrategy){
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
    public void changeFileCollectionStrategy(FileCollectionInterface fileCollectionStrategy){
        this.fileCollectionStrategy = fileCollectionStrategy;
    }
}
