package com.infocoder.service.saloon.mapper;

import com.infocoder.service.saloon.model.Saloon;
import com.infocoder.service.saloon.payload.dto.SaloonDTO;
import org.springframework.stereotype.Service;

@Service
public class SaloonMapper {

    public  Saloon mapToEntity(SaloonDTO saloonDTO) {
        return Saloon.builder()
                .id(saloonDTO.getId())
                .name(saloonDTO.getName())
                .images(saloonDTO.getImages())
                .address(saloonDTO.getAddress())
                .phoneNumber(saloonDTO.getPhoneNumber())
                .email(saloonDTO.getEmail())
                .city(saloonDTO.getCity())
                .ownerId(saloonDTO.getOwnerId())
                .openTime(saloonDTO.getOpenTime())
                .closeTime(saloonDTO.getCloseTime())
                .build();
    }

    public  SaloonDTO mapToDTO(Saloon saloon) {
        return SaloonDTO.builder()
                .id(saloon.getId())
                .name(saloon.getName())
                .images(saloon.getImages())
                .address(saloon.getAddress())
                .phoneNumber(saloon.getPhoneNumber())
                .email(saloon.getEmail())
                .city(saloon.getCity())
                .ownerId(saloon.getOwnerId())
                .openTime(saloon.getOpenTime())
                .closeTime(saloon.getCloseTime())
                .build();
    }

}
