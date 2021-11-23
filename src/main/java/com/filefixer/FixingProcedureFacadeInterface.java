package com.filefixer;

import java.io.File;
import java.util.Collection;
/**
 * Interface for the {@link fixingProcedureFacade}.
 */
public interface FixingProcedureFacadeInterface {
    /**
     * See {@link fixingProcedureFacade#extractFiles(Collection)}.
	 * @param zipFiles A collection of ZIP folders. 
	 */
    public void extractFiles(Collection<File> zipFiles);
    /**
     * See {@link fixingProcedureFacade#renameAndMovePdfs(Collection, Collection)}.
     * @param pdfFiles A collection of all PDF files to be renamed.
     * @param csvFiles A collection of CSV files to be parsed. See {@link csvCollectionHandler#getLastModified(Collection<File> files)}.
     */
    public void renameAndMovePdfs(Collection<File> pdfFiles, Collection<File> csvFiles);
    
    public void storeMissingStudents();
}
