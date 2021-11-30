package com.taa.project.scheduler.controllers;

import com.taa.project.scheduler.data.model.RendezVous;
import com.taa.project.scheduler.services.dto.FreeSlotDto;
import com.taa.project.scheduler.services.dto.FreeslotCreationRequest;
import com.taa.project.scheduler.services.dto.RendezVousCreationRequest;
import com.taa.project.scheduler.services.dto.RendezVousDto;
import com.taa.project.scheduler.services.interfaces.IRendezVousService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/rendezvous")
public class RendezVousController {
    private ModelMapper modelMapper;
    private IRendezVousService rendezVousService;

    @Autowired
    public RendezVousController(ModelMapper modelMapper, IRendezVousService rendezVousService) {
        this.modelMapper = modelMapper;
        this.rendezVousService = rendezVousService;
    }

    @PostMapping
    public ResponseEntity<RendezVousDto> addRendezVous(@RequestBody RendezVousCreationRequest rendezVousCreationRequest) throws Exception {
        RendezVousDto rendezVousDto = rendezVousCreationRequest.getRendezVous();
        Long profId = rendezVousCreationRequest.getProfessional_id();
        Long utilId = rendezVousCreationRequest.getUser_id();
        Long freeSlotId = rendezVousCreationRequest.getFreeslot_id();
        RendezVous rendezVous = rendezVousService.add(utilId, profId, freeSlotId);
        RendezVousDto rendezVousResponse = modelMapper.map(rendezVous, RendezVousDto.class);
        return new ResponseEntity<RendezVousDto>(rendezVousResponse, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteRendezVous(@PathVariable(name = "id") Long id) {
        try {
            rendezVousService.remove(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<String>("RendezVous deleted successfully", HttpStatus.OK);
    }


}

