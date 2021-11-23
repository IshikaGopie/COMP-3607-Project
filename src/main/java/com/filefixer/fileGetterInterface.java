package com.filefixer;

import java.io.File;
import java.util.Collection;
/**
 * Interface for the {@link fileGetter}.
 */
public interface fileGetterInterface {
    /**
     * See {@link fileGetter#getFiles(String)}.
	 * @param path The folder-path of the files being requested.
	 * @return Collection<{@link File}>: The collection of files.
	 */
    public Collection<File> getFiles(String path);
    /**
     * See {@link fileGetter#changeFileCollectionStrategy(fileCollectionInterface)}.
     * @param fileCollectionStrategy See {@link fileGetter#fileCollectionStrategy}.
     */
    public void changeFileCollectionStrategy(fileCollectionInterface fileCollectionStrategy);
}
