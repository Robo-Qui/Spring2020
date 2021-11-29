package com.taa.project.scheduler.controllers;

import com.taa.project.scheduler.data.model.RendezVous;
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

    @PostMapping("/{utilId}/{profId}/{freeSlotId}")
    public ResponseEntity<RendezVousDto> addRendezVous(@PathVariable(name = "utilId") Long utilId, @PathVariable(name = "profId") Long profId, @PathVariable(name = "freeSlotId") Long freeSlotId) throws Exception {
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
            //TODO
        }
        return new ResponseEntity<String>("User deleted successfully", HttpStatus.OK);
    }


}

