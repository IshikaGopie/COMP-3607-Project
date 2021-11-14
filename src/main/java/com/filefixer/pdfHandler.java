package com.filefixer;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.List;

import org.apache.commons.io.FileUtils;

public class pdfHandler implements batchPDFmanipulator{

    fileCollection fileCollectionStrategy;
    filePATHhandler PATH = new destinationPATH();

    public pdfHandler(fileCollection fileCollectionStrategy){
        this.fileCollectionStrategy = fileCollectionStrategy;
    }   
    
    @Override
    public Collection<File> get_PDFs(String path) {
        Collection<File> pdfCollection = fileCollectionStrategy.get_Files(path);

        return pdfCollection;
    }

    @Override
    public void PDF_name_parse(File pdf, List<student> student_info) {
        for (student o: student_info){
            if(pdf.getName().contains(o.getstudent_ID())){
                move_PDFs(pdf, o); return;
            }else if(pdf.getName().contains(o.getName())){
                move_PDFs(pdf, o); return;
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
