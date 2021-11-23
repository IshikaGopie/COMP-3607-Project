package com.filefixer;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
/**
 * This class handles the relocation of a PDF file to a new directory.
 */
public class PdfMover implements PdfMoverInterface{

	private PdfPathHandlerInterface Path = new PdfPathHandler();

    /** 
     * Renames and moves PDF file based on student information.
     */
    @Override
    public void movePdfs(File pdf, Student student, String directory) {
        try {
            FileUtils.moveFile(
            FileUtils.getFile(pdf.getPath()), 
            FileUtils.getFile(Path.createPath(pdf, student, directory)));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
