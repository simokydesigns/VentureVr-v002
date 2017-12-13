package com.vrvideo.web.webservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.vrvideo.business.domain.VentureDetails;
import com.vrvideo.business.service.VentureService;


@RestController
@RequestMapping(value = "/api")

public class VentureServiceController {
	@Autowired
	private VentureService ventureSrv;

	//@CrossOrigin
	@RequestMapping(method = RequestMethod.GET, value = "/venturedata/{userId}")
	public VentureDetails getALLDetails(@PathVariable(value = "userId") Long userId) {

		return this.ventureSrv.getVentureDetailsByAccId(userId);

	}

};
