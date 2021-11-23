package com.filefixer;

import java.util.List;
/**
 * Interface for the {@link MissingStudents} class.
 */
public interface MissingStudentsInterface {
    /**
     * See {@link MissingStudents#storeMissingStudents()}.
	 */
    public void storeMissingStudents();
    /**
     * See {@link MissingStudents#addMissingStudents(List)}.
     * @param student_info List containing student information.
     */
    public void addMissingStudents(List<Student> student_info);
    
}
