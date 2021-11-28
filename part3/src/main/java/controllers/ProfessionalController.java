package controllers;

import data.model.FreeSlot;
import data.model.Professional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import services.dto.FreeSlotDto;
import services.dto.ProfessionalDto;
import services.interfaces.IFreeSlotService;
import services.interfaces.IProfessionalService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/professionals")
public class ProfessionalController {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private IProfessionalService professionalService;

    @Autowired
    private IFreeSlotService freeSlotService;

    public ProfessionalController(IProfessionalService professionalService, IFreeSlotService freeSlotService) {
        super();
        this.professionalService = professionalService;
        this.freeSlotService = freeSlotService;
    }

    @GetMapping()
    public ResponseEntity<List<ProfessionalDto>> getAllProfessionals() {
        List<Professional> professionals = professionalService.getAllProfessionals();
        List<ProfessionalDto> professionalsDto = new ArrayList<>();

        for (Professional professional : professionals) {
            professionalsDto.add(modelMapper.map(professional, ProfessionalDto.class));
        }

        return ResponseEntity.ok().body(professionalsDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProfessionalDto> getProfessionalById(@PathVariable(name = "id") Long id) {
        Professional professional = professionalService.getById(id);
        ProfessionalDto professionalResponse = modelMapper.map(professional, ProfessionalDto.class);
        return ResponseEntity.ok().body(professionalResponse);
    }

    @GetMapping("/{id}/freeSlots")
    public ResponseEntity<List<FreeSlotDto>> getFreeSlotsByProfessional(@PathVariable(name = "id") Long id) {
        Professional professional = professionalService.getById(id);
        List<FreeSlot> freeSlots = professional.getFreeSlots();
        List<FreeSlotDto> freeSlotDtos = new ArrayList<>();

        for (FreeSlot freeSlot : freeSlots) {
            freeSlotDtos.add(modelMapper.map(freeSlot, FreeSlotDto.class));
        }

        return ResponseEntity.ok().body(freeSlotDtos);
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
    public ResponseEntity<ProfessionalDto> createProfessional(@RequestBody ProfessionalDto professionalDto) throws Exception {
        try {
            Professional professionalRequest = modelMapper.map(professionalDto, Professional.class);
            Professional professional = professionalService.addProfessionnel(professionalRequest);
            ProfessionalDto professionalResponse = modelMapper.map(professional, ProfessionalDto.class);
            return new ResponseEntity<ProfessionalDto>(professionalResponse, HttpStatus.CREATED);
        } catch (Exception e) {
            //Professionel deja existant
            return new ResponseEntity<ProfessionalDto>(HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProfessionalDto> updateProfessional(@PathVariable long id, @RequestBody ProfessionalDto professionalDto) throws Exception {

        Professional professionalRequest = modelMapper.map(professionalDto, Professional.class);
        Professional professional = professionalService.updateProfessional(id, professionalRequest);
        ProfessionalDto professionalResponse = modelMapper.map(professional, ProfessionalDto.class);
        return ResponseEntity.ok().body(professionalResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProfessional(@PathVariable(name = "id") Long id) throws Exception {
        professionalService.deleteProfessional(id);
        return new ResponseEntity<String>("Professional deleted successfully", HttpStatus.OK);
    }


}
