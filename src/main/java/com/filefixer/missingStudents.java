package com.filefixer;

import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.io.IOException;

public class missingStudents implements missingStudentsInterface{
    ArrayList < String > missingStudents = new ArrayList < String > ();

    public void store() {
        try {
            FileWriter fileWriter = new FileWriter("filesToRename/missingStudents.txt");  
            for(String student: missingStudents){
                fileWriter.write(student);
                fileWriter.write("\n");
                fileWriter.flush();
            }
            fileWriter.close();
                      
        } catch (IOException e) {
            System.out.println("An error occurred writing to file.");
            e.printStackTrace();
        } 
        
    }

    @Override
    public void addMissingStudents(List<student> student_info) {
        for(student o: student_info){
            if(o.getStatus()){
                missingStudents.add(o.getName());
            }
        }
    }
}
