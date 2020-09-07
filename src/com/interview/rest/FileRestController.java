package com.interview.rest;

import java.io.File;
import java.net.URL;

@RestController
@RequestMapping("/file")
public class FileRestController {

    @RequestMapping(
            value = "/download/{identifier}",
            method = RequestMethod.GET,
            produces = "application/json"
    )
    public ResponseEntity fileDownload(@RequestParam(value = "identifier") String identifier,
                                       HttpServletResponse response) throws Exception {
        File destinationFile = null;
        if (!destinationFile.exists()) {
            destinationFile.createNewFile();
        }

        try {
            //URL based on identifier
            URL url = new URL(url_identifier);
            FileUtils.copyURLToFile(url, destinationFile);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        System.out.println("Download successful.");
        return ResponseEntity.ok();
    }

    @RequestMapping(
            value = "/delete/{identifier}",
            method = RequestMethod.DELETE
    )
    public ResponseEntity deleteFile(@RequestParam(value = "identifier") String identifier,
                                     HttpServletResponse response) throws Exception {
        try
        {
            File file = new File("abc.txt"); //find file based on identifier
            file.deleteOnExit();
        } catch(Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        System.out.println("Deletion successful.");
        return ResponseEntity.ok();
    }

    @RequestMapping(
            value = "/copy/{identifier}",
            method = RequestMethod.POST
    )
    public ResponseEntity copyFile(@RequestParam(value = "identifier") String identifier,
                                   HttpServletResponse response) throws Exception {
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
}
