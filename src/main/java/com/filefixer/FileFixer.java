package com.filefixer;

import java.io.File;
import java.util.Collection;

public class FileFixer {
    public static void main(String[] args) {
        
        fixingProcedureFacadeInterface fixingProcedure = new fixingProcedureFacade();

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

        /*
        fileCollectionHandlerInterface fileCollectionHandler = new fileCollectionHandler();
        String zipPath = fileCollectionHandler.disallowCollection(zipFiles);
        if(zipPath != null){
            File zipFile = new File(zipPath);
            ZipFolder zipFolder = new ZipFolder();
            zipFolder.extractZip(zipFile);
        }

        String csvPath = fileCollectionHandler.getLastModified(csvFiles);
        
        csvHandlerInterface csvHandler = new csvHandler();
        List<student> student_info = new ArrayList<student>();

        directoryHandler.newDirectory("filesToRename/renamedFiles");

        csvHandler.loadStudentInfo(csvPath);

        student_info = csvHandler.getStudentInfo();

        missingStudentsInterface missingStudents = new missingStudents();

        pdfHandlerInterface pdfHandler = new pdfHandler();
        for(File pdf: pdfFiles){
            pdfHandler.manipulatePdf(pdf, student_info);
        }

        missingStudents.addMissingStudents(student_info);
        missingStudents.store();
        */
    }
}
