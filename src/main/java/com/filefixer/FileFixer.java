package com.filefixer;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class FileFixer {
    public static void main(String[] args) {
        directoryHandlerInterface directoryHandler = new directoryHandler();
        
        Collection<File> zipFiles;
        fileGetterInterface fileGetter = new fileGetter(new zipCollection());
        zipFiles = fileGetter.getFiles("filesToRename");

        fileCollectionHandlerInterface fileCollectionHandler = new fileCollectionHandler();
        String zipPath = fileCollectionHandler.disallowCollection(zipFiles);
        if(zipPath != null){
            File zipFile = new File(zipPath);
            ZipFolder zipFolder = new ZipFolder();
            zipFolder.extractZip(zipFile);
        }
        
        Collection<File> pdfFiles;
        fileGetter.changeFileCollectionStrategy(new pdfCollection());
        pdfFiles = fileGetter.getFiles("filesToRename");

        Collection<File> csvFiles;
        fileGetter.changeFileCollectionStrategy(new csvCollection());
        csvFiles = fileGetter.getFiles("filesToRename");

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
    }
}
