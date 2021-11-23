package com.filefixer;

import java.io.File;
import java.util.Collection;
/**
 * Interface for the {@link FileGetter}.
 */
public interface FileGetterInterface {
    /**
     * See {@link FileGetter#getFiles(String)}.
	 * @param path The folder-path of the files being requested.
	 * @return Collection<{@link File}>: The collection of files.
	 */
    public Collection<File> getFiles(String path);
    /**
     * See {@link FileGetter#changeFileCollectionStrategy(FileCollectionInterface)}.
     * @param fileCollectionStrategy See {@link FileGetter#fileCollectionStrategy}.
     */
    public void changeFileCollectionStrategy(FileCollectionInterface fileCollectionStrategy);
}
