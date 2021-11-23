package com.filefixer;

import java.io.File;
import java.util.Collection;
/**
 * Interface for the {@link ZipCollectionHandler} class.
 */
public interface ZipCollectionHandlerInterface {
    /**
     * See {@link ZipCollectionHandler#zipCheck(Collection)}.
	 * @param files The collection of ZIP files to be parsed.
	 * @return String: The file-path of the ZIP folder.
	 */
    public String zipCheck(Collection<File> files);
}
