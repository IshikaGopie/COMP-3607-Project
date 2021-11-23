package com.filefixer;

import java.util.List;
/**
 * Interface for the {@link missingStudents} class.
 */
public interface MissingStudentsInterface {
    /**
     * See {@link missingStudents#storeMissingStudents()}.
	 */
    public void storeMissingStudents();
    /**
     * See {@link missingStudents#addMissingStudents(List)}.
     * @param student_info List containing student information.
     */
    public void addMissingStudents(List<student> student_info);
    
}
