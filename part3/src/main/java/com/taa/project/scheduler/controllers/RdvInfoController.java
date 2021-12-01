package com.taa.project.scheduler.controllers;


import com.taa.project.scheduler.data.model.RdvInfo;
import com.taa.project.scheduler.services.dto.RdvInfoDto;
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
    public ResponseEntity<RdvInfoDto> updateDuree(@PathVariable(name = "id") Long id, @RequestBody int duree) throws Exception {
        RdvInfo infos = rdvInfosService.updateDuree(id, duree);
        RdvInfoDto rdvInfosResponse = modelMapper.map(infos, RdvInfoDto.class);
        return new ResponseEntity<RdvInfoDto>(rdvInfosResponse, HttpStatus.CREATED);
    }
}

