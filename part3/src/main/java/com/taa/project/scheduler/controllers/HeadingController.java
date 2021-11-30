package com.taa.project.scheduler.controllers;

import com.taa.project.scheduler.data.model.Heading;
import com.taa.project.scheduler.services.dto.HeadingCreationRequest;
import com.taa.project.scheduler.services.dto.HeadingDto;
import com.taa.project.scheduler.services.interfaces.IHeadingService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/headings")
public class HeadingController {
    private ModelMapper modelMapper;
    private IHeadingService headingService;

    @Autowired
    public HeadingController(ModelMapper modelMapper, IHeadingService headingService) {
        this.modelMapper = modelMapper;
        this.headingService = headingService;
    }

    @PostMapping
    public ResponseEntity<?> createHeading(@RequestBody HeadingCreationRequest headingCreationRequest) {
        try {
            //Get
            Long rdvInfoId = headingCreationRequest.getRdvInfoId();
            HeadingDto headingDto = headingCreationRequest.getHeading();

            //Transform
            Heading heading = modelMapper.map(headingDto, Heading.class);

            //Add to repo
            heading = headingService.createHeading(heading, rdvInfoId);

            HeadingDto headingResponse = modelMapper.map(heading, HeadingDto.class);
            return new ResponseEntity<HeadingDto>(headingResponse, HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<String>("Can't create heading", HttpStatus.BAD_REQUEST);
    }
}
