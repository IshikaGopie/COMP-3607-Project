package com.filefixer;

import java.io.File;
import java.util.Collection;
/**
 * Interface for the {@link CsvCollectionHandler}.
 */
public interface CsvCollectionHandlerInterface {
    /**
     * See {@link CsvCollectionHandler#getLastModified(Collection)}.
     * @param files The collection of CSV files to be parsed.
     * @return String: The file-path of the last modified CSV file.
     */
    public String getLastModified(Collection<File> files);
}
