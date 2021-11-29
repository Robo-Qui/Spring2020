package com.taa.project.scheduler.controllers;

import com.taa.project.scheduler.data.model.Heading;
import com.taa.project.scheduler.services.dto.HeadingDto;
import com.taa.project.scheduler.services.interfaces.IHeadingService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/heading")
public class HeadingController {
    private ModelMapper modelMapper;
    private IHeadingService headingService;

    @Autowired
    public HeadingController(ModelMapper modelMapper, IHeadingService headingService) {
        this.headingService = headingService;
    }

    @PostMapping("/{intitule}")
    public ResponseEntity<HeadingDto> createHeading(@PathVariable(name = "intitule") String intitule) throws Exception {
        Heading heading = headingService.createHeading(intitule);
        HeadingDto headingResponse = modelMapper.map(heading, HeadingDto.class);
        return new ResponseEntity<HeadingDto>(headingResponse, HttpStatus.CREATED);
    }
}
