package com.filefixer;

import java.io.File;
import java.util.Collection;

public interface fileCollectionHandlerInterface {
    public String getLastModified(Collection<File> files);
    public String disallowCollection(Collection<File> files);
}
