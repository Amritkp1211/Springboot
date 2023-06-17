package com.FileHandling;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class FileController {

	//upload file
	
	@PostMapping("/upload")
	public String uploadfile(@RequestParam("file") MultipartFile file) {
		
			String filepath=System.getProperty("user.dir")+"/uploads"+File.separator+file.getOriginalFilename();
			String fileuploadStuts;			
			try {
				FileOutputStream fos=new FileOutputStream(filepath);
				  fos.write(file.getBytes());
				  fos.close();
				   fileuploadStuts="file upload Successfully";
			} catch (Exception e) {
               e.printStackTrace();
               fileuploadStuts="error while uploading the file"+e;
			}		
		return fileuploadStuts;		
	}
	
	//Get All files
	@GetMapping("/getfiles")
	public String[] getAllfiles() {
		
		String filepath=System.getProperty("user.dir")+"/uploads";
		File f=new File(filepath);
		
		String[] filelist=f.list();
		
		return filelist;		
	}
	
	//download File
	
	@GetMapping("/download/{path}")
	public ResponseEntity downloadFile(@PathVariable("path") String filename) throws IOException {
		String fileuploadPath=System.getProperty("user.dir")+"/uploads";
		String[] filename1=this.getAllfiles();
		 
		//checking whether the file exists for download or not
		
		boolean contains=Arrays.asList(filename1).contains(filename);
		
		if(!contains) {
			System.out.println();
			  return new ResponseEntity<>("file not found",HttpStatus.NOT_FOUND);
		}
		//setting up the path
		
		String filepath=fileuploadPath+File.separator+filename;
		
		//creating a new file
		File f=new File(filepath);
		
		//creating a inputresource object
		InputStreamResource resource=new InputStreamResource(new FileInputStream(f));
				
		HttpHeaders hd=new HttpHeaders();
		
		String contentType="application/octet-stream";
		String headerValue="attachment; filename=\""+resource.getFilename()+"\"";
		
		return ResponseEntity.ok()
				.contentType(MediaType.parseMediaType(contentType))
				.header(HttpHeaders.CONTENT_DISPOSITION,headerValue)
				.body(resource);
	}
	
	
	
	
}
