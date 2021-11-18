package com.filefixer;

import java.io.File;
import java.util.Collection;

public interface fileGetterInterface {
    public Collection<File> getFiles(String path);
    public void changeFileCollectionStrategy(fileCollectionINTERFACE fileCollectionStrategy);
}
