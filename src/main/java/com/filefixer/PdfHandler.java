package com.filefixer;

import java.io.File;
import java.util.List;
/**
 * This class manipulates a PDF if matched with certain criteria from a student instance.
 * This class also manipulates the student instance in question to reflect this criteria match.
 */
public class PdfHandler implements PdfHandlerInterface {
    /**
     * See {@link PdfMover}.
     */
	private PdfMoverInterface PdfMover = new PdfMover();

    
    /** 
     * Parses a PDF file's name based on student information. 
     * If a student's information matches the PDF submission, the file is renamed and moved.
     * The status of the student in question is also changed.
     * @param directory The folder-path of the directory files are to be moved.
     */
    @Override
    public void manipulatePdf(File pdf, List<Student> student_info, String directory) {
        for (Student o: student_info){
            if(pdf.getName().contains(o.getStudentID())){
                o.changeStatus(); 
                PdfMover.movePdfs(pdf, o, directory); 
                return;
            }else if((pdf.getName().contains(o.getName().toUpperCase())) || (pdf.getName().contains(o.getName().toLowerCase())) || (pdf.getName().contains(o.getName()))){
                o.changeStatus(); 
                PdfMover.movePdfs(pdf, o, directory); 
                return;
            }else if(pdf.getName().contains(o.getName().replaceAll("\\s","")) || pdf.getName().contains(o.getName().replaceAll(" ","_"))){
                o.changeStatus(); 
                PdfMover.movePdfs(pdf, o, directory); 
                return;
            }
        }
    }
}
