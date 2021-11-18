package com.filefixer;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CSVmanipulator implements CSVmanipulatorINTERFACE{
    private List<student> student_info = new ArrayList<student>();

    fileCollectionINTERFACE fileCollectionStrategy;

    public void loadStudentInfo(String path){
        try {
            Scanner data = new Scanner(new File(path));  
            String all_info = data.nextLine();

            while (data.hasNext()){
                all_info = data.nextLine();
                String[] studentData = all_info.split("\\,");
                student_info.add(new student(studentData[0], studentData[1], studentData[2]));
            }  

            data.close();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    public List<student> getStudentInfo(){
        /*for (student o: student_info){
            System.out.println("name: " + o.getName() + "| student_ID: " + o.getID() + "\n");
        }*/
        return student_info;
    }
}