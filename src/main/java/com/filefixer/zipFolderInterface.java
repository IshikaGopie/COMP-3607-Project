package com.filefixer;
import java.io.File;
/**
 * Interface for the {@link zipFolder} class.
 */
public interface zipFolderInterface {
    /**
     * See {@link zipFolder#extractZip(File)}.
	 * @param zipFile The current ZIP folder to be extracted.
	 */
    public void extractZip(File zipFile);
}
