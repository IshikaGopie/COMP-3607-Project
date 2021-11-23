package com.filefixer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;
import java.util.Collection;
public class renameFilesTest {
    private String[] name1 = new String[3];
    private String[] name2 = new String[3];
    @Test
    void renameFiles(){
        name1[0] = "Anna Horton_601727_assignsubmission_file_Anna Horton_601727_assignsubmission_file_info 2603 assignment 1.pdf";
        name1[1] = "Beth Morales-Horton_601683_assignsubmission_file_Beth Morales-Horton_601683_assignsubmission_file_Assignment1_81305512.pdf";
        name1[2] = "Clifton Bowen_601680_assignsubmission_file_Clifton Bowen_601680_assignsubmission_file_81380485.pdf";
        
        FixingProcedureFacadeInterface fixingProcedure = new FixingProcedureFacade("testFiles/testFilesToRename/renamedFiles");


        Collection<File> pdfFiles;
        FileGetterInterface fileGetter = new FileGetter(new PdfCollection());
        pdfFiles = fileGetter.getFiles("testFiles/testFilesToRename");


        Collection<File> csvFiles;
        fileGetter.changeFileCollectionStrategy(new CsvCollection());
        csvFiles = fileGetter.getFiles("testFiles/testFilesToRename");

        fixingProcedure.renameAndMovePdfs(pdfFiles, csvFiles);
        File pdfFiles2 = new File("testFiles/testFilesToRename/renamedFiles/");
        File[] allFiles = pdfFiles2.listFiles();
        int i = 0;
        for(File files: allFiles){
            name2[i] = files.getName();
            i += 1;
        }
        assertEquals(name1[0], name2[0]);
        assertEquals(name1[1], name2[1]);
        assertEquals(name1[2], name2[2]);
    }
}
