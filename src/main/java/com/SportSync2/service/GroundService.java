package com.SportSync2.service;

import com.SportSync2.dto.GroundDTO;
import com.SportSync2.entity.Ground;
import com.SportSync2.repository.GroundRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class GroundService {

    private final GroundRepository groundRepo;

    public List<GroundDTO> getAllGrounds() {
        return groundRepo.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public GroundDTO registerGround(GroundDTO groundDTO) {
        Ground ground = Ground.builder()
                .name(groundDTO.getName())
                .location(groundDTO.getLocation())
                .latitude(groundDTO.getLatitude())
                .longitude(groundDTO.getLongitude())
                .description(groundDTO.getDescription())
                .phoneNumber(groundDTO.getPhoneNumber())
                .city(groundDTO.getCity())
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();

        Ground savedGround = groundRepo.save(ground);
        return convertToDTO(savedGround);
    }

    public GroundDTO updateGround(Long id, GroundDTO groundDTO) {
        Ground ground = groundRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Ground not found with id: " + id));

        ground.setName(groundDTO.getName());
        ground.setLocation(groundDTO.getLocation());
        ground.setLatitude(groundDTO.getLatitude());
        ground.setLongitude(groundDTO.getLongitude());
        ground.setDescription(groundDTO.getDescription());
        ground.setPhoneNumber(groundDTO.getPhoneNumber());
        ground.setCity(groundDTO.getCity());
        ground.setUpdatedAt(LocalDateTime.now());

        Ground updatedGround = groundRepo.save(ground);
        return convertToDTO(updatedGround);
    }

    public void deleteGround(Long id) {
        if (!groundRepo.existsById(id)) {
            throw new RuntimeException("Ground not found with id: " + id);
        }
        groundRepo.deleteById(id);
    }

    public GroundDTO getGroundById(Long id) {
        Ground ground = groundRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Ground not found with id: " + id));
        return convertToDTO(ground);
    }

    public List<GroundDTO> getGroundsByCity(String city) {
        return groundRepo.findAll().stream()
                .filter(g -> g.getCity().equalsIgnoreCase(city))
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    private GroundDTO convertToDTO(Ground ground) {
        return GroundDTO.builder()
                .id(ground.getId())
                .name(ground.getName())
                .location(ground.getLocation())
                .latitude(ground.getLatitude())
                .longitude(ground.getLongitude())
                .description(ground.getDescription())
                .phoneNumber(ground.getPhoneNumber())
                .city(ground.getCity())
                .createdAt(ground.getCreatedAt())
                .updatedAt(ground.getUpdatedAt())
                .build();
    }
}

