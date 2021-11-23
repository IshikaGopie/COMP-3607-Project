package com.filefixer;

import java.io.File;
import java.util.Collection;
/**
 * Interface for various fileCollection classes. 
 * Used as the Strategy Design Pattern's interface for the following sub-types, {@link csvCollection}, 
 * {@link pdfCollection} and {@link zipCollection}.
 */
public interface FileCollectionInterface{
    /**
     * @param path The folder-path of the directory.
     * @return {@link Collection}<{@link File}>: A collection of all files.
     */
    public Collection<File> getFiles(String path);
}
