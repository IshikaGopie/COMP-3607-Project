package com.filefixer;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.io.IOException;

public class missing implements missingInterface{
    ArrayList < String > missingStudents = new ArrayList < String > ();


    public missing(File pdf, student o) {
        if(pdf.getName().contains(o.getName()) || pdf.getName().contains(o.getstudent_ID())){

        }else{
            missingStudents.add(o.getName());
        }
    }

  

    public void Store() throws IOException {
        int numMissedStudents = missingStudents.size();
        int i;
        FileWriter fileWriter = new FileWriter("filesToRename/filename.txt");
        try {      
            for(i=0;i<=numMissedStudents;i++){
                fileWriter.write(missingStudents.get(i));
                fileWriter.flush();
            }
           // FileWriter fileWriter = new FileWriter(filesToRename,filename.txt); 
            fileWriter.close();
                      
          } catch (IOException e) {
            System.out.println("An error occurred writing to file.");
            e.printStackTrace();
          } 
        
    }

    @Override
    public void findMissing(File pdf, List<student> student_info) {
        // TODO Auto-generated method stub
        
    }
    
}
