package com.filefixer;

import java.io.File;
import java.util.Collection;

public interface csvBatchManipulatorInterface {
    public String getLastModified(Collection<File> files);
}
