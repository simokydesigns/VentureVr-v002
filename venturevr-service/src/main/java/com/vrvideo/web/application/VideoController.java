package com.vrvideo.web.application;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping(value="/videos")
public class VideoController {
	
	@RequestMapping(method= RequestMethod.GET)
	public String getVideos() {
		return "videos";
	}

}
