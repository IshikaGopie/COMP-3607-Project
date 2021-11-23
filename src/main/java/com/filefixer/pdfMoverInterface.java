package com.filefixer;

import java.io.File;
/**
 * Interface for the {@link pdfMover} class.
 */
public interface pdfMoverInterface{
    /**
     * See {@link pdfMover#movePdfs(File, student)}.
	 * @param pdf The current PDF file.
	 * @param student The current student instance.
	 */
    public void movePdfs(File pdf, student student);
}   
