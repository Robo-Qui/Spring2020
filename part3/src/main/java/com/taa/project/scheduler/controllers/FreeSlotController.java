package com.taa.project.scheduler.controllers;

import com.taa.project.scheduler.data.model.FreeSlot;
import com.taa.project.scheduler.services.dto.FreeSlotDto;
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

    @PostMapping("/{id}")
    public ResponseEntity<FreeSlotDto> createFreeSlot(@RequestBody FreeSlotDto freeSlotDto, @PathVariable(name = "id") Long id) throws Exception {
        try {
            FreeSlot freeSlotRequest = modelMapper.map(freeSlotDto, FreeSlot.class);
            FreeSlot freeSlot = freeSlotService.add(freeSlotRequest, id);
            FreeSlotDto freeSlotResponse = modelMapper.map(freeSlot, FreeSlotDto.class);
            return new ResponseEntity<FreeSlotDto>(freeSlotResponse, HttpStatus.CREATED);
        } catch (Exception e) {
            //FreeSlot chevauché
            return new ResponseEntity<FreeSlotDto>(HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteFreeSlot(@PathVariable(name = "id") Long id) throws Exception {
        freeSlotService.remove(id);
        return new ResponseEntity<String>("User deleted successfully", HttpStatus.OK);
    }
}
