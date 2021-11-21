package com.filefixer;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

public class pdfMover implements pdfMoverInterface{

    pdfPathHandlerInterface Path = new pdfPathHandler();

    @Override
    public void movePdfs(File pdf, student student) {
        try {
            FileUtils.moveFile(
            FileUtils.getFile(pdf.getPath()), 
            FileUtils.getFile(Path.create_PATH(pdf, student)));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
