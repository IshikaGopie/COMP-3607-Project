package com.filefixer;

import java.io.File;
import java.util.Collection;
import java.util.List;

public class fixingProcedureFacade implements fixingProcedureFacadeInterface{
    directoryHandlerInterface directoryHandler;
    fileCollectionHandlerInterface fileCollectionHandler;
    csvHandlerInterface csvHandler;
    pdfHandlerInterface pdfHandler;

    List<student> student_info;
    missingStudentsInterface missingStudents;

    fixingProcedureFacade(){
        directoryHandler = new directoryHandler();
        fileCollectionHandler = new fileCollectionHandler();
        csvHandler = new csvHandler();
        pdfHandler = new pdfHandler();
        missingStudents = new missingStudents();
    }

    public void extractFiles(Collection<File> zipFiles){
        String zipPath = fileCollectionHandler.disallowCollection(zipFiles);
        if(zipPath != null){
            File zipFile = new File(zipPath);
            ZipFolder zipFolder = new ZipFolder();
            zipFolder.extractZip(zipFile);
        }
    }
    
    public void renameAndMovePdfs(Collection<File> pdfFiles, Collection<File> csvFiles){
        directoryHandler.newDirectory("filesToRename/renamedFiles");
        String csvPath = fileCollectionHandler.getLastModified(csvFiles);
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
