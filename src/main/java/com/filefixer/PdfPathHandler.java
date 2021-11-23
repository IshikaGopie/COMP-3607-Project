package com.filefixer;

import java.io.File;

/**
 * This class handles the destination file-path of PDF files.
 */
public class PdfPathHandler implements PdfPathHandlerInterface{
    /** 
     * Creates the destination file-path for the PDF as well as renames the PDF in question based on student information.
     * @return String: The destination file-path of the current PDF.
     */
    @Override
    public String createPath(File pdf, Student student, String directory) {
        String destinationString = directory + "/"  + student.getName() + "_" + 
        student.getParticipantID().replace("Participant ", "") +
        "_assignsubmission_file_" + pdf.getName();
        
        return destinationString;
    }
    
}
