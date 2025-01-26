package com.infocoder.service.saloon.service.impl;

import com.infocoder.service.saloon.SaloonRepository;
import com.infocoder.service.saloon.exception.SaloonNotFoundException;
import com.infocoder.service.saloon.mapper.SaloonMapper;
import com.infocoder.service.saloon.model.Saloon;
import com.infocoder.service.saloon.payload.dto.SaloonDTO;
import com.infocoder.service.saloon.payload.dto.UserDTO;
import com.infocoder.service.saloon.service.ISaloonService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SaloonServiceImpl implements ISaloonService {

    private final SaloonRepository repository;
    private final SaloonMapper mapper;

    @Override
    public Saloon createSaloon(SaloonDTO saloonDTO, UserDTO userDTO) {
        //convert dto to entity
        saloonDTO.setOwnerId(userDTO.getId());
        Saloon saloon = mapper.mapToEntity(saloonDTO);

        //save an entity
        return repository.save(saloon);
    }

    @Override
    public Saloon updateSaloon(SaloonDTO saloonDTO, UserDTO userDTO, Long saloonId) throws Exception {
        Saloon existingSaloon = repository.findById(saloonId).orElseThrow(() -> new SaloonNotFoundException("Saloon is not present with id: " + saloonId));
        if (!saloonDTO.getOwnerId().equals(userDTO.getId())) {
            throw new Exception("You don't have permission to update this saloon");
        }

        if (existingSaloon != null) {
            existingSaloon.setCity(saloonDTO.getCity());
            existingSaloon.setName(saloonDTO.getName());
            existingSaloon.setAddress(saloonDTO.getAddress());
            existingSaloon.setEmail(saloonDTO.getEmail());
            existingSaloon.setImages(saloonDTO.getImages());
            existingSaloon.setOpenTime(saloonDTO.getOpenTime());
            existingSaloon.setCloseTime(saloonDTO.getCloseTime());
            existingSaloon.setOwnerId(userDTO.getId());
            existingSaloon.setPhoneNumber(saloonDTO.getPhoneNumber());
            return repository.save(existingSaloon);
        }
        throw new SaloonNotFoundException("Saloon not found");
    }

    @Override
    public List<Saloon> getAllSaloons() {
        return repository.findAll();
    }

    @Override
    public Saloon getSaloonById(Long saloonId) {
        return repository.findById(saloonId).
                orElseThrow(() -> new SaloonNotFoundException("Saloon is not present with id: " + saloonId));
    }

    @Override
    public Saloon getSaloonByOwnerId(Long ownerId) {
        return repository.findByOwnerId(ownerId);
    }

    @Override
    public List<Saloon> searchSaloonByCity(String city) {
        return repository.searchSaloons(city);
    }
}
