package com.filefixer;

import java.io.File;
import java.util.List;

public interface batchPDFmanipulatorINTERFACE{
    //public Collection<File> get_PDFs(String path);
    public void PDF_name_parse(File pdf, List<student> student_info);
    public void move_PDFs(File pdf, student student);

    //needs to use CSV data to parse files, preferrably using ID
    //needs to then use CSV data rename file and store file in renamedFiles
}   
