package com.filefixer;

import java.io.File;
import java.util.List;

public interface pdfHandler{
    public void parse_PDFs(File pdf, List<student> student_info);
    public void move_PDFs(File pdf, student student);
    public String create_destinationPATH(File pdf, student student);

    //needs to use CSV data to parse files, preferrably using ID
    //needs to then use CSV data rename file and store file in renamedFiles
}   
