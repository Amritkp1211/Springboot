package com.FileHandling.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class fileUploadController {
    
	@PostMapping(value = "/upload",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	 public String uploadfile(@RequestParam("file") MultipartFile file) throws IOException {
		
		File f=new File(""+file.getOriginalFilename());
        f.createNewFile();
        FileOutputStream fos=new FileOutputStream(f);
        fos.write(file.getBytes());
        fos.close();
		return "file upload successfully";

		
	}
}
