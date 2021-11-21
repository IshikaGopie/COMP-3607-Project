package com.filefixer;

import java.io.File;
import java.util.List;

public class pdfHandler implements pdfHandlerInterface {

    pdfMoverInterface pdfManipulator = new pdfMover();

    @Override
    public void manipulatePdf(File pdf, List<student> student_info) {
        for (student o: student_info){
            if(pdf.getName().contains(o.getstudent_ID())){
                o.changeStatus(); 
                pdfManipulator.movePdfs(pdf, o); 
                return;
            }else if((pdf.getName().contains(o.getName().toUpperCase())) || (pdf.getName().contains(o.getName().toLowerCase())) || (pdf.getName().contains(o.getName()))){
                o.changeStatus(); 
                pdfManipulator.movePdfs(pdf, o); 
                return;
            }else if(pdf.getName().contains(o.getName().replaceAll("\\s","")) || pdf.getName().contains(o.getName().replaceAll(" ","_"))){
                o.changeStatus(); 
                pdfManipulator.movePdfs(pdf, o); 
                return;
            }
        }
    }
}
