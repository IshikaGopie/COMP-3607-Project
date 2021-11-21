package com.filefixer;

import java.io.File;
import java.util.Collection;

public interface csvCollectionHandlerInterface {
    public String getLastModified(Collection<File> files);
}
