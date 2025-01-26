package com.infocoder.service.saloon.controller;

import com.infocoder.service.saloon.mapper.SaloonMapper;
import com.infocoder.service.saloon.model.Saloon;
import com.infocoder.service.saloon.payload.dto.SaloonDTO;
import com.infocoder.service.saloon.payload.dto.UserDTO;
import com.infocoder.service.saloon.service.ISaloonService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/saloons")
public class SaloonController {

    private final ISaloonService saloonService;
    private final SaloonMapper mapper;

    @PostMapping
    public ResponseEntity<SaloonDTO> createSaloon(@RequestBody @Valid SaloonDTO saloonDTO) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(1L);
        Saloon saloon = saloonService.createSaloon(saloonDTO, userDTO);
        return new ResponseEntity<>(mapper.mapToDTO(saloon), HttpStatus.CREATED);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<SaloonDTO> updateSaloon(@RequestBody @Valid SaloonDTO saloonDTO, @PathVariable Long id) throws Exception {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(1L);
        Saloon saloon = saloonService.updateSaloon(saloonDTO, userDTO, id);
        return new ResponseEntity<>(mapper.mapToDTO(saloon), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<SaloonDTO>> getSaloons() {
        List<Saloon> saloonList = saloonService.getAllSaloons();
        //converting list of entities to list of dtos
        List<SaloonDTO> saloonDTOList = saloonList.stream().map(mapper::mapToDTO).toList();

        return new ResponseEntity<>(saloonDTOList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SaloonDTO> getSaloonById(@PathVariable Long id) {
        Saloon saloon = saloonService.getSaloonById(id);

        //converting entity to dto and returning
        return new ResponseEntity<>(mapper.mapToDTO(saloon), HttpStatus.OK);
    }


    @GetMapping("/search")
    public ResponseEntity<List<SaloonDTO>> searchSaloons(@RequestParam String city) {
        List<Saloon> saloonList = saloonService.searchSaloonByCity(city);
        //converting list of entities to list of dtos
        List<SaloonDTO> saloonDTOList = saloonList.stream().map(mapper::mapToDTO).toList();

        return new ResponseEntity<>(saloonDTOList, HttpStatus.OK);
    }

    @GetMapping("/owner")
    public ResponseEntity<SaloonDTO> getSaloonByOwnerId(@PathVariable Long ownerId) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(1L);
        Saloon saloon = saloonService.getSaloonByOwnerId(userDTO.getId());

        //converting entity to dto and returning
        return new ResponseEntity<>(mapper.mapToDTO(saloon), HttpStatus.OK);
    }

}
