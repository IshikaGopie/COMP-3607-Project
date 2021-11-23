package com.filefixer;

import java.io.File;
import java.util.Collection;
/**
 * Interface for various fileCollection classes. 
 * Used as the Strategy Design Pattern's interface for the following sub-types, {@link CsvCollection}, 
 * {@link PdfCollection} and {@link ZipCollection}.
 */
public interface FileCollectionInterface{
    /**
     * @param path A folder-path.
     * @return {@link Collection}<{@link File}>: A collection of all files requested.
     */
    public Collection<File> getFiles(String path);
}
