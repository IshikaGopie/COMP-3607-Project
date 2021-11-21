package com.filefixer;

import java.io.File;
import java.util.List;

public interface pdfHandlerInterface {
    public void manipulatePdf(File pdf, List<student> student_info);
}
