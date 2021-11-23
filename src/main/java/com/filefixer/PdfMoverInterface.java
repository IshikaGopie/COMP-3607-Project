package com.filefixer;

import java.io.File;
/**
 * Interface for the {@link PdfMover} class.
 */
public interface PdfMoverInterface{
    /**
     * See {@link pdfMover#movePdfs(File, Student, String)}.
	 */
    public void movePdfs(File pdf, Student student, String directory);
}   
