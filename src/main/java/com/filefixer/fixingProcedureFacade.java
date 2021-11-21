package com.filefixer;

import java.io.File;
import java.util.Collection;
import java.util.List;

public class fixingProcedureFacade implements fixingProcedureFacadeInterface{
    directoryHandlerInterface directoryHandler;
    zipCollectionHandlerInterface zipCollectionHandler;
    csvCollectionHandlerInterface csvCollectionHandler;
    csvHandlerInterface csvHandler;
    pdfHandlerInterface pdfHandler;

    List<student> student_info;
    missingStudentsInterface missingStudents;

    fixingProcedureFacade(){
        directoryHandler = new directoryHandler();
        zipCollectionHandler = new zipCollectionHandler();
        csvCollectionHandler = new csvCollectionHandler();
        csvHandler = new csvHandler();
        pdfHandler = new pdfHandler();
        missingStudents = new missingStudents();
    }

    public void extractFiles(Collection<File> zipFiles){
        String zipPath = zipCollectionHandler.disallow(zipFiles);
        if(zipPath != null){
            File zipFile = new File(zipPath);
            ZipFolder zipFolder = new ZipFolder();
            zipFolder.extractZip(zipFile);
        }
    }
    
    public void renameAndMovePdfs(Collection<File> pdfFiles, Collection<File> csvFiles){
        directoryHandler.newDirectory("filesToRename/renamedFiles");
        String csvPath = csvCollectionHandler.getLastModified(csvFiles);
        System.out.println(csvPath);
        loadStudents(csvPath);
        for(File pdf: pdfFiles){
            pdfHandler.manipulatePdf(pdf, student_info);
        }
    }

    private void loadStudents(String csvPath){
        csvHandler.loadStudentInfo(csvPath);
        student_info = csvHandler.getStudentInfo();
    }

    public void storeMissingStudents(){
        missingStudents.addMissingStudents(student_info);
        missingStudents.store();
    }
}
