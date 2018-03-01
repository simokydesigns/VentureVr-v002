package com.vrvideo.data.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import com.vrvideo.data.entity.Video;


@Repository
public interface VideoRepository extends CrudRepository<Video, Long>{
      List<Video> findAllVideosByEstId (long estId);
      
      @Transactional
      List<Video> deleteVideoByTitle(String title);
}
