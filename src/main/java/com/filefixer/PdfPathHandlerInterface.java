package com.filefixer;

import java.io.File;
/**
 * Interface for the {@link PdfPathHandler} class.
 */
public interface PdfPathHandlerInterface{
    /**
     * See {@link PdfPathHandler#createPath(File, Student, String)}.
	 * @return String: The destination file-path of the current PDF.
	 */
    public String createPath(File pdf, Student student, String directory);
}
