package com.filefixer;

import java.util.zip.ZipEntry;
/**
 * This class handles the destination file-path of files being extracted.
 */
public class ZipPathHandler implements ZipPathHandlerInterface{
    /** 
     * Modifies the destination file-path of the current zipEntry.
     * @param zipEntry The current ZIP file being extracted.
     * @return String: The destination file-path.
     */
    @Override
    public String modifyUnzipPath(ZipEntry zipEntry) {
        String zipPath = "filesToRename/" + zipEntry.getName().substring(zipEntry.getName().indexOf("/") + 1);
        zipPath.trim();
        return zipPath;
    }
    
}
