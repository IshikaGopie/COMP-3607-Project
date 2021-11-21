package com.filefixer;

import java.util.zip.ZipEntry;

public class zipFilePathHandler implements zipFilePathHandlerInterface{

    @Override
    public String modifyUnzipPath(ZipEntry zipEntry) {
        String zipPath = "filesToRename/" + zipEntry.getName().substring(zipEntry.getName().indexOf("/") + 1);
        zipPath.trim();
        return zipPath;
    }
    
}
