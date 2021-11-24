package com.filefixer;

import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.io.IOException;

public class MissingStudents implements MissingStudentsInterface{
    /**
     * An ArrayList of all students with missing submissions.
     */
    ArrayList < String > missingStudents = new ArrayList < String > ();

    /**
     * Stores all missing students to a text file if missing students exist in ArrayList.
     */
    public void storeMissingStudents() {
        if(missingStudents.size() < 1){
            System.out.println("No missing student submissions.");
            return;
        }else{
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
    }

    
    /** 
     * Adds missing students to ArrayList based on the boolean returned.
     * @param student_info List containing student information.
     */
    @Override
    public void addMissingStudents(List<Student> student_info) {
        for(Student o: student_info){
            if(o.getStatus()){
                missingStudents.add(o.getName());
            }
        }
    }
}
