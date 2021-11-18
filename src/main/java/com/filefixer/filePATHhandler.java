package com.filefixer;

import java.io.File;

public class filePATHhandler implements filePathHandlerInterface{

    @Override
    public String create_PATH(File pdf, student student) {
        String destinationString = "filesToRename/renamedFiles/" + student.getName() + "_" + 
        student.getparticipant_ID().replace("Participant ", "") +
        "_assignsubmission_file_" + pdf.getName();
        
        return destinationString;
    }
    
}
