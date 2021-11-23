package com.filefixer;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/**
 * This class processes data from a single CSV file to produce a List of students.
 */
public class csvHandler implements csvHandlerInterface{
    /**
     * A List of all students present in the CSV file as well as each of their student information.
     */
    private List<student> student_info = new ArrayList<student>();

    /**
     * Loads a student's participant ID, name and student ID from a CSV file into a List.
     * @param path The file-path of the CSV file.
     */
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


    /**
     * @return {@link List}<{@link student}>: The List of students.
     */
    public List<student> getStudentInfo(){
        return student_info;
    }
}