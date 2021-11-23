package com.filefixer;

import java.io.File;
import java.util.List;
/**
 * Interface for the {@link pdfHandler} class.
 */
public interface pdfHandlerInterface {
    /**
     * See {@link pdfHandler#manipulatePdf(File, List)}.
	 * @param pdf The current PDF file.
	 * @param student_info The List containing student information.
	 */
    public void manipulatePdf(File pdf, List<student> student_info, String directory);
}
