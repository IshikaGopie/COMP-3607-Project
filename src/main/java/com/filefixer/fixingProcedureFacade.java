package com.filefixer;

import java.io.File;
import java.util.Collection;
import java.util.List;

/**
 * This class handles all main steps in renaming PDF files. 
 * It also handles the creation of a text file detailing students whose submissions were not present.
 * This class utilizes the Facade Design Pattern which hides the complexity of other classes into three
 * methods that can be used by the client. 
 */
public class fixingProcedureFacade implements fixingProcedureFacadeInterface{

    private directoryHandlerInterface directoryHandler;
    private zipCollectionHandlerInterface zipCollectionHandler;
    private csvCollectionHandlerInterface csvCollectionHandler;
    private csvHandlerInterface csvHandler;
    private pdfHandlerInterface pdfHandler;
    /**
     * The List containing student information.
     */
    private List<student> student_info;
    private missingStudentsInterface missingStudents;
    /**
     * The folder-path where renamed files should be placed.
     */
    private String directory;

    /**
     * Initializes all class instances needed for the renaming of PDF files as well as the creation of a missing students text file.
     * @param directory See {@link #directory}.
     */
    fixingProcedureFacade(String directory){
        directoryHandler = new directoryHandler();
        zipCollectionHandler = new zipCollectionHandler();
        csvCollectionHandler = new csvCollectionHandler();
        csvHandler = new csvHandler();
        pdfHandler = new pdfHandler();
        missingStudents = new missingStudents();
        
        this.directory = directory;
    }


    
    /** 
     * Loads and stores all CSV student information in a List.
     * @param csvPath The file-path of the CSV.
     */
    private void loadStudents(String csvPath){
        csvHandler.loadStudentInfo(csvPath);
        student_info = csvHandler.getStudentInfo();
    }

    
    /** 
     * Extracts files from ZIP folder. The collection parameter should only contain 1 ZIP folder. See {@link zipCollectionHandler}.
     * @param zipFiles A collection of ZIP folders. 
     */
    public void extractFiles(Collection<File> zipFiles){
        String zipPath = zipCollectionHandler.zipCheck(zipFiles);
        if(zipPath != null){
            File zipFile=new File(zipPath);
            zipFolderInterface zipFolder=new zipFolder();
            zipFolder.extractZip(zipFile);
        }
    }
    
    
    /**
     * @param pdfFiles A collection of all PDF files to be renamed.
     * @param csvFiles A collection of CSV files to be parsed. See {@link csvCollectionHandler#getLastModified(Collection<File> files)}.
     */
    public void renameAndMovePdfs(Collection<File> pdfFiles, Collection<File> csvFiles){
        directoryHandler.newDirectory(directory);
        String csvPath = csvCollectionHandler.getLastModified(csvFiles);
        System.out.println(csvPath);
        loadStudents(csvPath);
        for(File pdf: pdfFiles){
            pdfHandler.manipulatePdf(pdf, student_info, directory);
        }
    }

    
    public void storeMissingStudents(){
        missingStudents.addMissingStudents(student_info);
        missingStudents.storeMissingStudents();
    }
}
