package com.vrvideo.data.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

import com.vrvideo.data.entity.Image;



public interface ImageRepository  extends CrudRepository<Image, Long> {
	
	Image findImageByEstId (long estId); 
   
    @Transactional
    List<Image> deleteImageByEstId(long estId);
    
}
