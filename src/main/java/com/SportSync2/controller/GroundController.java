
package com.SportSync2.controller;

import com.SportSync2.dto.*;
import com.SportSync2.service.GroundBookingService;
import com.SportSync2.service.GroundService;
import com.SportSync2.service.ParticipantService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/grounds")
@RequiredArgsConstructor
public class GroundController {

    private final GroundService groundService;

    @GetMapping("/available")
    public ResponseEntity<List<GroundDTO>> getAllGrounds() {
        return ResponseEntity.ok(groundService.getAllGrounds());
    }

    @GetMapping("/{id}")
    public ResponseEntity<GroundDTO> getGroundById(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(groundService.getGroundById(id));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/city/{city}")
    public ResponseEntity<List<GroundDTO>> getGroundsByCity(@PathVariable String city) {
        return ResponseEntity.ok(groundService.getGroundsByCity(city));
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerVenue(@Valid @RequestBody GroundDTO groundDTO) {
        try {
            GroundDTO registeredGround = groundService.registerGround(groundDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(
                    Map.of(
                            "message", "Venue registered successfully",
                            "data", registeredGround
                    )
            );
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(
                    Map.of("error", "Failed to register venue: " + e.getMessage())
            );
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateGround(@PathVariable Long id, @Valid @RequestBody GroundDTO groundDTO) {
        try {
            GroundDTO updatedGround = groundService.updateGround(id, groundDTO);
            return ResponseEntity.ok(
                    Map.of(
                            "message", "Venue updated successfully",
                            "data", updatedGround
                    )
            );
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(
                    Map.of("error", "Failed to update venue: " + e.getMessage())
            );
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteGround(@PathVariable Long id) {
        try {
            groundService.deleteGround(id);
            return ResponseEntity.ok(Map.of("message", "Venue deleted successfully"));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
