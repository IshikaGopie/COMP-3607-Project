package com.filefixer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
public class GetPdfsTest{
    @Test
    void getPDFs(){
        FileGetterInterface fileGetter = new FileGetter(new PdfCollection());
        String[] name1 = new String[3];
        String[] name2 = new String[3];
        Collection<File> pdfFiles1 = new ArrayList<File>();;
        Collection<File> pdfFiles2;
        File file = new File("Anna Horton_601727_assignsubmission_file_info 2603 assignment 1.pdf");
        pdfFiles1.add(file);
        file = new File("Beth Morales-Horton_601683_assignsubmission_file_Assignment1_81305512.pdf");
        pdfFiles1.add(file);
        file = new File("Clifton Bowen_601680_assignsubmission_file_81380485.pdf");
        pdfFiles1.add(file);
        pdfFiles2 = fileGetter.getFiles("testFiles/testingFolder");
        int i = 0;
        for(File files: pdfFiles1){
            name1[i] = files.getName();
            i += 1;
        }
         i = 0;
        for(File files: pdfFiles2){
            name2[i] = files.getName();
            i += 1;
        }
        assertEquals(name1[0], name2[0]);
        assertEquals(name1[1], name2[1]);
        assertEquals(name1[2], name2[2]);
    }
}
