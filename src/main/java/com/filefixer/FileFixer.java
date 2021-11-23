package com.filefixer;

import java.io.File;
import java.util.Collection;
/**
 * 
 * @author G12
 */
public class FileFixer {

    /**
     * Renames and moves PDF files to a specified directory as well as creates a text file 
     * detailing students whose submissions were not present.
     * @param args The command line arguments.
     */
    public static void main(String[] args) {

        FixingProcedureFacade fixingProcedure = new FixingProcedureFacade("filesToRename/renamedFiles");

        Collection<File> zipFiles;
        FileGetterInterface fileGetter = new FileGetter(new ZipCollection());
        zipFiles = fileGetter.getFiles("filesToRename");

        fixingProcedure.extractFiles(zipFiles);

        Collection<File> pdfFiles;
        fileGetter.changeFileCollectionStrategy(new PdfCollection());
        pdfFiles = fileGetter.getFiles("filesToRename");


        Collection<File> csvFiles;
        fileGetter.changeFileCollectionStrategy(new CsvCollection());
        csvFiles = fileGetter.getFiles("filesToRename");

        fixingProcedure.renameAndMovePdfs(pdfFiles, csvFiles);
        fixingProcedure.storeMissingStudents();
    }
}
