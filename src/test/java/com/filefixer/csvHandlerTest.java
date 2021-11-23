package com.filefixer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import java.util.ArrayList;
import java.util.List;

public class csvHandlerTest {
    String testFile = "testFiles/test.csv";
    private List<student> student_info = new ArrayList<student>();

    @Test
    void loadStudentInfoTest(){
        student student1 = new student("Participant 642151", "Joe Doe-Shmoe", "123567894");
        student student2 = new student("Participant 642180", "John Jimmy Jake White", "123567893");
        student_info.add(student1);
        student_info.add(student2);
        csvHandler csv_Handler = new csvHandler();
        csv_Handler.loadStudentInfo(testFile);
        assertArrayEquals(student_info.toArray(),csv_Handler.getStudentInfo().toArray());
    }
}
