package com.vrvideo.web.webservice;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


import com.vrvideo.data.entity.Video;
import com.vrvideo.data.repository.VideoRepository;


@RestController
@RequestMapping(value = "/api")

public class VideoServiceController {
	
    //Save the uploaded file to this folder
    private static String UPLOADED_FOLDER = "C://VentureVr-v002//";
	
	@Autowired
	private VideoRepository videoRepo;

	
	@RequestMapping(method = RequestMethod.GET, value = "/videos/{estId}")
	public List<Video> getAllVideosById(@PathVariable(value = "estId") Long estId) {
		return this.videoRepo.findAllVideosByEstId(estId);
	};

	
	@RequestMapping(method = RequestMethod.GET, value = "/videos")
	public Iterable<Video> getAllVideos() {
		return this.videoRepo.findAll();
	};

	@RequestMapping(method = RequestMethod.POST, consumes = "application/json", value = "/newvideo")
	@ResponseBody
	public void addNewVideo(@RequestBody Video newVideo) {

		videoRepo.save(new Video(newVideo.getTitle(), newVideo.getGenre(), newVideo.getPath(), newVideo.getFileType(),
				newVideo.getEstId()));
	}

	
	@RequestMapping(method = RequestMethod.POST, value = "/uploadvideo")
	@ResponseBody
	public String singleFileUpload(@RequestParam("file") MultipartFile file, Model model) throws IOException {

		// Save file on system
		if (!file.getOriginalFilename().isEmpty()) {
			BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream(
					new File( "//venturevr-app//Venture//WebContent//webapp//video", file.getOriginalFilename())));
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
