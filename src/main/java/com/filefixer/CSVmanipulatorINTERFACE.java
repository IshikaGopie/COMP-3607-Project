package com.filefixer;

import java.util.List;

public interface CSVmanipulatorINTERFACE{
    public void loadStudentInfo(String path);
    public List<student> getStudentInfo();
}
