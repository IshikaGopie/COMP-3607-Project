package com.filefixer;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;

public class pdfManipulator implements pdfManipulatorInterface{

    filePathHandlerInterface PATH = new filePathHandler();

    @Override
    public void PDF_name_parse(File pdf, List<student> student_info) {
        for (student o: student_info){
            if(pdf.getName().contains(o.getstudent_ID())){
                o.changeStatus(); move_PDFs(pdf, o); return;
            }else if((pdf.getName().contains(o.getName().toUpperCase())) || (pdf.getName().contains(o.getName().toLowerCase())) || (pdf.getName().contains(o.getName()))){
                o.changeStatus(); move_PDFs(pdf, o); return;
            }else if(pdf.getName().contains(o.getName().replaceAll("\\s","")) || pdf.getName().contains(o.getName().replaceAll(" ","_"))){
                o.changeStatus(); move_PDFs(pdf, o); return;
            }
        }
    }

    @Override
    public void move_PDFs(File pdf, student student) {
        try {
            FileUtils.moveFile(
            FileUtils.getFile(pdf.getPath()), 
            FileUtils.getFile(PATH.create_PATH(pdf, student)));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
