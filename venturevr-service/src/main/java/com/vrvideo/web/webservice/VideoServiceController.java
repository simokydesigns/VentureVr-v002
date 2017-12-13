package com.vrvideo.web.webservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import com.vrvideo.data.entity.Video;
import com.vrvideo.data.repository.VideoRepository;



@RestController
@RequestMapping(value="/api")

     public class VideoServiceController {
		    @Autowired
		    private VideoRepository videoRepo;

		    //@CrossOrigin
		    @RequestMapping(method= RequestMethod.GET, value="/videos/{estId}")
		    public List<Video> getAllVideosById(@PathVariable(value="estId")Long estId){
		        return this.videoRepo.findAllVideosByEstId(estId);
		    };
		    
		    //@CrossOrigin
		    @RequestMapping(method= RequestMethod.GET, value="/videos")
		    public Iterable<Video> getAllVideos(){
		        return this.videoRepo.findAll();
	};
	
    @RequestMapping(method= RequestMethod.POST, consumes = "application/json", value="/newvideo")
    @ResponseBody
    public void addNewVideo(@RequestBody Video newVideo){
   
    	videoRepo.save(new Video(newVideo.getTitle(), newVideo.getGenre(), 
    			newVideo.getPath(), newVideo.getFileType(), newVideo.getEstId()));	    	
    }
}
