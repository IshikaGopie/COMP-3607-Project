package com.filefixer;

import java.io.File;
import java.util.List;

public interface pdfManipulatorInterface{
    public void PDF_name_parse(File pdf, List<student> student_info);
    public void move_PDFs(File pdf, student student);
}   
