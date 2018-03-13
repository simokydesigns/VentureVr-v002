/*package com.vrvideo.utilitys;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

public class fileUploadService {
	
	@Controller
	public class FileUploadController {

	   // Handling single file upload request
	   @PostMapping("/uploadvideo")
	   public String singleFileUpload(@RequestParam("file") MultipartFile file, Model model)
	         throws IOException {

	      // Save file on system
	      if (!file.getOriginalFilename().isEmpty()) {
	         BufferedOutputStream outputStream = new BufferedOutputStream(
	               new FileOutputStream(
	                     new File("/venturevr-app/WebContent/webapp/video", file.getOriginalFilename())));
	         outputStream.write(file.getBytes());
	         outputStream.flush();
	         outputStream.close();

	         model.addAttribute("msg", "File uploaded successfully.");
	      } else {
	         model.addAttribute("msg", "Please select a valid file..");
	      }

	      return "fileUploadForm";
	   }
	}
}
*/