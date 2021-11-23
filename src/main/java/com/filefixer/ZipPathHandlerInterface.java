package com.filefixer;

import java.util.zip.ZipEntry;
/**
 * Interface for the {@link ZipPathHandler} class.
 */
public interface ZipPathHandlerInterface {
    /**
     * See {@link ZipPathHandler#modifyUnzipPath(ZipEntry)}.
	 * @param zipEntry The current ZIP file being extracted.
	 * @return String: The destination file-path.
	 */
    public String modifyUnzipPath(ZipEntry zipEntry);
}
