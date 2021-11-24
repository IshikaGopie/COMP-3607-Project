package com.filefixer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import java.util.ArrayList;
import java.util.List;

public class CsvHandlerTest {
    String testFile = "testFiles/test.csv";
    private List<Student> student_info = new ArrayList<Student>();

    @Test
    void loadStudentInfoTest(){
        Student student1 = new Student("Participant 642151", "Joe Doe-Shmoe", "123567894");
        Student student2 = new Student("Participant 642180", "John Jimmy Jake White", "123567893");
        student_info.add(student1);
        student_info.add(student2);
        CsvHandlerInterface csv_Handler = new CsvHandler();
        csv_Handler.loadStudentInfo(testFile);
        assertArrayEquals(student_info.toArray(),csv_Handler.getStudentInfo().toArray());
    }
}
