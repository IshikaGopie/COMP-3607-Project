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

        fixingProcedureFacadeInterface fixingProcedure = new fixingProcedureFacade("filesToRename/renamedFiles");

        Collection<File> zipFiles;
        fileGetterInterface fileGetter = new fileGetter(new zipCollection());
        zipFiles = fileGetter.getFiles("filesToRename");

        fixingProcedure.extractFiles(zipFiles);

        Collection<File> pdfFiles;
        fileGetter.changeFileCollectionStrategy(new pdfCollection());
        pdfFiles = fileGetter.getFiles("filesToRename");


        Collection<File> csvFiles;
        fileGetter.changeFileCollectionStrategy(new csvCollection());
        csvFiles = fileGetter.getFiles("filesToRename");

        fixingProcedure.renameAndMovePdfs(pdfFiles, csvFiles);
        fixingProcedure.storeMissingStudents();
    }
}
