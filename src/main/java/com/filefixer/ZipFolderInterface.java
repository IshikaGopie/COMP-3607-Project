package com.filefixer;
import java.io.File;
/**
 * Interface for the {@link ZipFolder} class.
 */
public interface ZipFolderInterface {
    /**
     * See {@link ZipFolder#extractZip(File)}.
	 * @param zipFile The current ZIP folder to be extracted.
	 */
    public void extractZip(File zipFile);
}
