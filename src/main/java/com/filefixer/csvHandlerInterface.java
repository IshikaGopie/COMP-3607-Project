package com.filefixer;

import java.util.List;

public interface csvHandlerInterface{
    public void loadStudentInfo(String path);
    public List<student> getStudentInfo();
}
