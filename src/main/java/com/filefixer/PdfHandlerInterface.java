package com.filefixer;

import java.io.File;
import java.util.List;
/**
 * Interface for the {@link PdfHandler} class.
 */
public interface PdfHandlerInterface {
    /**
     * See {@link PdfHandler#manipulatePdf(File, List, String)}.
	 *  @param directory The folder-path of the directory files are to be moved.
	 */
    public void manipulatePdf(File pdf, List<Student> student_info, String directory);
}
