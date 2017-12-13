package com.vrvideo.web.webservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.vrvideo.data.entity.Image;
import com.vrvideo.data.repository.ImageRepository;



@RestController
@RequestMapping(value="/api")

     public class ImageServiceController {
		    @Autowired
		    private ImageRepository imgRepo;

		    //@CrossOrigin
		    @RequestMapping(method= RequestMethod.GET, value="/images/{estId}")
		    public Image getAllImagesById(@PathVariable(value="estId")Long estId){
		        return this.imgRepo.findImageByEstId(estId);
		    };
		    
		    //@CrossOrigin
		    @RequestMapping(method= RequestMethod.GET, value="/images")
		    public Iterable<Image> getAllImages(){
		        return this.imgRepo.findAll();
	};
	
    @RequestMapping(method= RequestMethod.POST, consumes = "application/json", value="/newimage")
    @ResponseBody
    public void addNewImage(@RequestBody Image newImage){
   
    	imgRepo.save(new Image(newImage.getImgName(), newImage.getImgPath(), 
    			newImage.getImgType(), newImage.getEstId()));	    	
    }
}
