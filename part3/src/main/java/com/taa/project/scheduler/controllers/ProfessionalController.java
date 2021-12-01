package com.taa.project.scheduler.controllers;

import com.taa.project.scheduler.data.model.FreeSlot;
import com.taa.project.scheduler.data.model.Professional;
import com.taa.project.scheduler.services.dto.FreeSlotDto;
import com.taa.project.scheduler.services.dto.ProfessionalDto;
import com.taa.project.scheduler.services.interfaces.IFreeSlotService;
import com.taa.project.scheduler.services.interfaces.IProfessionalService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/professionals")
public class ProfessionalController {

    private ModelMapper modelMapper;
    private IProfessionalService professionalService;
    private IFreeSlotService freeSlotService;

    @Autowired
    public ProfessionalController(ModelMapper modelMapper, IProfessionalService professionalService, IFreeSlotService freeSlotService) {
        this.modelMapper = modelMapper;
        this.professionalService = professionalService;
        this.freeSlotService = freeSlotService;
    }

    @GetMapping
    public ResponseEntity<List<ProfessionalDto>> getAllProfessionals() {
        List<Professional> professionals = professionalService.getAllProfessionals();
        List<ProfessionalDto> professionalsDto = new ArrayList<>();

        for (Professional professional : professionals) {
            professionalsDto.add(modelMapper.map(professional, ProfessionalDto.class));
        }

        return ResponseEntity.ok().body(professionalsDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getProfessionalById(@PathVariable(name = "id") Long id) {
        try {
            Professional professional = professionalService.getById(id);
            ProfessionalDto professionalResponse = modelMapper.map(professional, ProfessionalDto.class);
            return new ResponseEntity<ProfessionalDto>(professionalResponse, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<String>("Can't retrieve this professional.", HttpStatus.NOT_FOUND);
        }

    }

    @GetMapping("/{id}/freeSlots")
    public ResponseEntity<?> getFreeSlotsByProfessional(@PathVariable(name = "id") Long id) {
        try {
            Professional professional = professionalService.getById(id);
            List<FreeSlot> freeSlots = professional.getFreeSlots();
            List<FreeSlotDto> freeSlotDtos = new ArrayList<>();

            for (FreeSlot freeSlot : freeSlots) {
                freeSlotDtos.add(modelMapper.map(freeSlot, FreeSlotDto.class));
            }

            return new ResponseEntity<List<FreeSlotDto>>(freeSlotDtos, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<String>("Can't retrieve this professional.", HttpStatus.NOT_FOUND);
        }
    }

    /* TODO
    @GetMapping("/{id}/rendezVous")
    public ResponseEntity<List<RendezVousDto>> getRendezVousByProfessional(@PathVariable(name = "id") Long id) {
        Professional professional = professionalService.getById(id);
        List<RendezVous> rendezVousList = professional.getRendezVous();
        List<RendezVousDto> rendezVousDtos = new ArrayList<>();

        for (RendezVous rendezVous : rendezVousList) {
            rendezVousDtos.add(modelMapper.map(rendezVous, RendezVousDto.class));
        }

        return ResponseEntity.ok().body(rendezVousDtos);
    }
     */

    @PostMapping
    public ResponseEntity<?> createProfessional(@RequestBody ProfessionalDto professionalDto) {
        try {
            Professional professionalRequest = modelMapper.map(professionalDto, Professional.class);
            Professional professional = professionalService.addProfessionnel(professionalRequest);
            ProfessionalDto professionalResponse = modelMapper.map(professional, ProfessionalDto.class);
            return new ResponseEntity<ProfessionalDto>(professionalResponse, HttpStatus.CREATED);
        } catch (Exception e) {
            //Professionel deja existant
            e.printStackTrace();
            return new ResponseEntity<String>("Professional already exists", HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateProfessional(@PathVariable long id, @RequestBody ProfessionalDto professionalDto) {
        try {

            Professional professionalRequest = modelMapper.map(professionalDto, Professional.class);
            Professional professional = professionalService.updateProfessional(id, professionalRequest);
            ProfessionalDto professionalResponse = modelMapper.map(professional, ProfessionalDto.class);
            return new ResponseEntity<ProfessionalDto>(professionalResponse, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<String>("Can't delete this professional", HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProfessional(@PathVariable(name = "id") Long id) {
        try {
            professionalService.deleteProfessional(id);
            return new ResponseEntity<String>("Professional deleted successfully", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<String>("Can't delete this professional", HttpStatus.NOT_FOUND);
        }
    }


}
