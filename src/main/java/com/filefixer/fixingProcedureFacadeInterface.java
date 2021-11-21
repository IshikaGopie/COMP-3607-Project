package com.filefixer;

import java.io.File;
import java.util.Collection;

public interface fixingProcedureFacadeInterface {
    public void extractFiles(Collection<File> zipFiles);
    public void renameAndMovePdfs(Collection<File> pdfFiles, Collection<File> csvFiles);
    public void storeMissingStudents();
}
