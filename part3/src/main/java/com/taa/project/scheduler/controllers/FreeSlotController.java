package com.taa.project.scheduler.controllers;

import com.taa.project.scheduler.data.model.FreeSlot;
import com.taa.project.scheduler.services.dto.FreeSlotDto;
import com.taa.project.scheduler.services.dto.FreeslotCreationRequest;
import com.taa.project.scheduler.services.interfaces.IFreeSlotService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/freeslots")
public class FreeSlotController {
    private ModelMapper modelMapper;
    private IFreeSlotService freeSlotService;

    @Autowired
    public FreeSlotController(ModelMapper modelMapper, IFreeSlotService freeSlotService) {
        this.modelMapper = modelMapper;
        this.freeSlotService = freeSlotService;
    }

    //TODFIX: how to pass both freeSlotDTO and prof_id in body
    @PostMapping
    public ResponseEntity<FreeSlotDto> createFreeSlot(@RequestBody FreeslotCreationRequest freeslotCreationRequest) {
        try {
            //Get items from request
            FreeSlotDto freeSlotDto = freeslotCreationRequest.getFreeSlotDto();
            Long professional_id = freeslotCreationRequest.getProfessional_id();

            //Transform to freeslot
            FreeSlot freeSlotRequest = modelMapper.map(freeSlotDto, FreeSlot.class);

            //Request db
            FreeSlot freeSlot = freeSlotService.add(freeSlotRequest, professional_id);

            //Transform to DTO
            FreeSlotDto freeSlotResponse = modelMapper.map(freeSlot, FreeSlotDto.class);
            return new ResponseEntity<FreeSlotDto>(freeSlotResponse, HttpStatus.CREATED);
        } catch (Exception e) {
            //FreeSlot chevauché
            e.printStackTrace();
            return new ResponseEntity<FreeSlotDto>(HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteFreeSlot(@PathVariable(name = "id") Long id) {
        freeSlotService.remove(id);
        return new ResponseEntity<String>("Freeslot deleted successfully", HttpStatus.OK);
    }
}
