package com.infocoder.service.saloon.service;

import com.infocoder.service.saloon.model.Saloon;
import com.infocoder.service.saloon.payload.dto.SaloonDTO;
import com.infocoder.service.saloon.payload.dto.UserDTO;

import java.util.List;

public interface ISaloonService {
    Saloon createSaloon(SaloonDTO saloonDTO, UserDTO userDTO);

    Saloon updateSaloon(SaloonDTO saloonDTO, UserDTO userDTO, Long saloonId) throws Exception;

    List<Saloon> getAllSaloons();

    Saloon getSaloonById(Long saloonId);

    Saloon getSaloonByOwnerId(Long ownerId);

    List<Saloon> searchSaloonByCity(String city);
}
