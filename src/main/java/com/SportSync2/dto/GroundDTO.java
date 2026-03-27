package com.SportSync2.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GroundDTO {

    private Long id;

    @NotBlank(message = "Ground name is required")
    @Size(min = 3, max = 100, message = "Ground name must be between 3 and 100 characters")
    @Pattern(
            regexp = "^[A-Za-z0-9 ]+$",
            message = "Ground name must contain only letters, numbers, and spaces"
    )
    private String name;

    @NotBlank(message = "Location is required")
    @Size(min = 5, max = 150, message = "Location must be between 5 and 150 characters")
    private String location;

    @NotNull(message = "Latitude is required")
    @DecimalMin(value = "33.0", message = "Latitude must be within Pakistan bounds")
    @DecimalMax(value = "37.0", message = "Latitude must be within Pakistan bounds")
    private Double latitude;

    @NotNull(message = "Longitude is required")
    @DecimalMin(value = "71.0", message = "Longitude must be within Pakistan bounds")
    @DecimalMax(value = "77.0", message = "Longitude must be within Pakistan bounds")
    private Double longitude;

    @Size(max = 500, message = "Description must not exceed 500 characters")
    private String description;

    @Pattern(regexp = "^[0-9\\-\\+\\s()]*$", message = "Invalid phone number format")
    private String phoneNumber;

    @NotBlank(message = "City is required")
    private String city;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
