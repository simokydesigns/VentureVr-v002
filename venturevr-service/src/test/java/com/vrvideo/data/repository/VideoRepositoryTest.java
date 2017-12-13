package com.vrvideo.data.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest

public class VideoRepositoryTest {
	
	@Autowired
	VideoRepository videoRepository;

	@Test
	public void testAddVideo() {
		
		//videoRepository.save(new Video("xmen", "sci-fi", "/img/venture", "webM", 1L));
        
	}
	
	@Test
	public void testDeleteVideo() {
		
		//videoRepository.deleteVideoByTitle("xmen");
		
	}

}
