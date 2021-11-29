package com.taa.project.scheduler.controllers;


import com.taa.project.scheduler.data.model.RdvInfo;
import com.taa.project.scheduler.services.dto.RdvInfosDto;
import com.taa.project.scheduler.services.interfaces.IRdvInfosService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/rdvinfos")
public class RdvInfoController {
    private ModelMapper modelMapper;
    private IRdvInfosService rdvInfosService;

    @Autowired
    public RdvInfoController(ModelMapper modelMapper, IRdvInfosService rdvInfosService) {
        this.modelMapper = modelMapper;
        this.rdvInfosService = rdvInfosService;
    }

    @PutMapping("/{id}/duree")
    public ResponseEntity<RdvInfosDto> updateDuree(@PathVariable(name = "id") Long id, @RequestBody int duree) throws Exception {
        RdvInfo infos = rdvInfosService.updateDuree(id, duree);
        RdvInfosDto rdvInfosResponse = modelMapper.map(infos, RdvInfosDto.class);
        return new ResponseEntity<RdvInfosDto>(rdvInfosResponse, HttpStatus.CREATED);
    }
}

