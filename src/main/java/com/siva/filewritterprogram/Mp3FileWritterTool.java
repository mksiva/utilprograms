/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.siva.filewritterprogram;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.io.FileUtils;

/**
 *
 * @author siva This is small java program to iterate through sub directories
 * and copy mp3 files into one directory, so that I can transfer these files and
 * see those under one album in play music.
 */
public class Mp3FileWritterTool {

    public static void main(String[] args) {
        File directory = new File("D:\\Siva\\Entertainment\\EvergreenHits");

        FileFilter filter = new FileFilter() {
            @Override
            public boolean accept(File file) {
                if (file.getName().endsWith(".mp3")) {
                    return true;
                } else {
                    return false;
                }
            }
        };
        File[] subdirs = directory.listFiles();
        for (File subDir : subdirs) {
            try {
                System.out.println("Going to read files under : " + subDir);
                if (subDir.isDirectory()) {
                    File[] files = subDir.listFiles(filter);
                    if (files != null) {
                        for (File file : files) {
                            FileUtils.copyFileToDirectory(file, new File(directory.getPath() + "\\toTransfer"));
                        }
                    } else {
                        System.out.println("There are no songs inside. [" + subDir.getName() + "]");
                    }
                } else {
                    System.out.println("Not a directory. [" + subDir.getName() + "]");
                }
            } catch (IOException ex) {
                Logger.getLogger(Mp3FileWritterTool.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
