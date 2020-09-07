package com.interview.rest;

import java.io.*;
import java.net.URL;

@RestController
@RequestMapping("/file")
public class FileRestController {

    @RequestMapping(
            value = "/download",
            method = RequestMethod.GET,
            produces = "application/json"
    )
    public ResponseEntity fileDownload(HttpServletResponse response) throws Exception {
        File destinationFile = null;
        if (!destinationFile.exists()) {
            destinationFile.createNewFile();
        }

        try {
            URL url = new URL(url_identifier);
            FileUtils.copyURLToFile(url, destinationFile);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        System.out.println("Download successful.");
        return ResponseEntity.ok();
    }

    @RequestMapping(
            value = "/delete",
            method = RequestMethod.DELETE
    )
    public ResponseEntity deleteFile(HttpServletResponse response) throws Exception {
        try
        {
            File file = new File("abc.txt");
            file.deleteOnExit();
        } catch(Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        System.out.println("Deletion successful.");
        return ResponseEntity.ok();
    }

    @RequestMapping(
            value = "/copy",
            method = RequestMethod.POST
    )
    public ResponseEntity copyFile(HttpServletResponse response) throws Exception {
        File destinationFile = null;
        if (!destinationFile.exists()) {
            destinationFile.createNewFile();
        }
        try {
            File sourceFile = new File("abc.txt");//find source file based on identifer
            if (!sourceFile.exists()) {
                return ResponseEntity.badRequest();
            }
            copyFileUsingStream(sourceFile, destinationFile);
        } catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        System.out.println("Copy of file successful.");
        return ResponseEntity.ok();
    }

    private static void copyFileUsingStream(File source, File dest) throws IOException {
        InputStream is = null;
        OutputStream os = null;
        try {
            is = new FileInputStream(source);
            os = new FileOutputStream(dest);
            byte[] buffer = new byte[1024];
            int length;
            while ((length = is.read(buffer)) > 0) {
                os.write(buffer, 0, length);
            }
        } finally {
            is.close();
            os.close();
        }
    }
}
