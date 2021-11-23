package com.filefixer;

import java.util.zip.ZipEntry;
/**
 * Interface for the {@link zipPathHandler} class.
 */
public interface zipPathHandlerInterface {
    /**
     * See {@link zipPathHandler#modifyUnzipPath(ZipEntry)}.
	 * @param zipEntry The current ZIP file being extracted.
	 * @return String: The destination file-path.
	 */
    public String modifyUnzipPath(ZipEntry zipEntry);
}
