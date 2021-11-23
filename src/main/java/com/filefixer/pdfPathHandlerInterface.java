package com.filefixer;

import java.io.File;
/**
 * Interface for the {@link pdfPathHandler} class.
 */
public interface pdfPathHandlerInterface{
    /**
     * See {@link pdfPathHandler#createPath(File, student)}.
	 * @param pdf The current PDF file.
	 * @param student The current student instance.
	 * @return String: The destination file-path of the current PDF.
	 */
    public String createPath(File pdf, student student);
}
