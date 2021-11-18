package com.filefixer;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class FileFixer {
    public static void main(String[] args) {
        directoryHandlerINTERFACE directoryHandler = new directoryHandler();

        Collection<File> pdfFiles;
        fileGetterInterface fileGetter = new fileGetter(new pdfCollection());
        pdfFiles = fileGetter.getFiles("filesToRename");

        Collection<File> csvFiles;
        fileGetter.changeFileCollectionStrategy(new csvCollection());
        csvFiles = fileGetter.getFiles("filesToRename");

        csvBatchManipulatorInterface csvBatchManipulator = new csvBatchManipulator();
        String csvPath = csvBatchManipulator.getLastModified(csvFiles);
        
        CSVmanipulatorINTERFACE csvHandler = new CSVmanipulator();
        List<student> student_info = new ArrayList<student>();

        directoryHandler.newDirectory("filesToRename/renamedFiles");

        csvHandler.loadStudentInfo(csvPath);

        student_info = csvHandler.getStudentInfo();

        missingStudentsInterface missingStudents = new missingStudents();

        batchPDFmanipulatorINTERFACE pdfHandler = new batchPDFmanipulator();
        for(File pdf: pdfFiles){
            pdfHandler.PDF_name_parse(pdf, student_info);
        }

        missingStudents.addMissingStudents(student_info);
        missingStudents.store();
    }
}
