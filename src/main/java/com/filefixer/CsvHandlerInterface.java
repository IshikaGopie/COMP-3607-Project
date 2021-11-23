package com.filefixer;

import java.util.List;
/**
 * Interface for the {@link csvHandler}.
 */
public interface csvHandlerInterface{
    /**
     * See {@link csvHandler#loadStudentInfo(String)}.
     * @param path The file-path of the CSV file.
     */
    public void loadStudentInfo(String path);
    /**
     * @return {@link List}<{@link student}>: The List of students.
     */
    public List<student> getStudentInfo();
}
