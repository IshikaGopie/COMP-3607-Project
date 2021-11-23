package com.filefixer;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
/**
 * This class handles the relocation of a PDF file to a new directory.
 */
public class pdfMover implements pdfMoverInterface{

	private pdfPathHandlerInterface Path = new pdfPathHandler();

    /** 
     * Renames and moves PDF file based on student information.
     * @param pdf The current PDF file.
     * @param student The current student instance.
     */
    @Override
    public void movePdfs(File pdf, student student) {
        try {
            FileUtils.moveFile(
            FileUtils.getFile(pdf.getPath()), 
            FileUtils.getFile(Path.createPath(pdf, student)));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
