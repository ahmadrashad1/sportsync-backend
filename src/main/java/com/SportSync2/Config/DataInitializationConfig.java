package com.SportSync2.config;

import com.SportSync2.entity.Ground;
import com.SportSync2.repository.GroundRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;
import java.util.Arrays;

@Configuration
public class DataInitializationConfig {

    @Bean
    public CommandLineRunner initializeData(GroundRepository groundRepository) {
        return args -> {
            // Only initialize if no grounds exist
            if (groundRepository.count() == 0) {
                // Load dummy data
                var grounds = Arrays.asList(
                        // Islamabad Venues
                        Ground.builder()
                                .name("Jinnah Super Sports Complex")
                                .location("G-5, Islamabad")
                                .latitude(33.7294)
                                .longitude(73.1864)
                                .description("Multi-purpose sports complex with indoor and outdoor facilities. Home to football, cricket, and badminton courts.")
                                .phoneNumber("051-9270000")
                                .city("Islamabad")
                                .createdAt(LocalDateTime.now())
                                .updatedAt(LocalDateTime.now())
                                .build(),

                        Ground.builder()
                                .name("Shakarparian Sports Complex")
                                .location("Shakarparian, Islamabad")
                                .latitude(33.7442)
                                .longitude(73.2564)
                                .description("Modern sports facility featuring football field, tennis courts, and basketball courts with professional training grounds.")
                                .phoneNumber("051-8726400")
                                .city("Islamabad")
                                .createdAt(LocalDateTime.now())
                                .updatedAt(LocalDateTime.now())
                                .build(),

                        Ground.builder()
                                .name("Adiala Badminton Complex")
                                .location("Adiala, Islamabad")
                                .latitude(33.7150)
                                .longitude(73.0950)
                                .description("Dedicated badminton facility with 8 professional courts, air-conditioned halls, and training academy.")
                                .phoneNumber("051-9270515")
                                .city("Islamabad")
                                .createdAt(LocalDateTime.now())
                                .updatedAt(LocalDateTime.now())
                                .build(),

                        Ground.builder()
                                .name("Pakistan Sports Complex")
                                .location("Sector F-7, Islamabad")
                                .latitude(33.7394)
                                .longitude(73.1817)
                                .description("Complete sports facility with swimming pool, athletics track, squash courts, and gymnasium.")
                                .phoneNumber("051-9270200")
                                .city("Islamabad")
                                .createdAt(LocalDateTime.now())
                                .updatedAt(LocalDateTime.now())
                                .build(),

                        Ground.builder()
                                .name("Margalla Tennis Club")
                                .location("Margalla Road, Islamabad")
                                .latitude(33.8150)
                                .longitude(73.1950)
                                .description("Premier tennis facility with 6 clay courts, professional coaching staff, and membership facilities.")
                                .phoneNumber("051-2310507")
                                .city("Islamabad")
                                .createdAt(LocalDateTime.now())
                                .updatedAt(LocalDateTime.now())
                                .build(),

                        Ground.builder()
                                .name("Rawal Lake Sports Ground")
                                .location("Rawal Lake, Islamabad")
                                .latitude(33.7700)
                                .longitude(73.2150)
                                .description("Waterfront sports complex perfect for outdoor activities, running track, and recreational sports.")
                                .phoneNumber("051-9270667")
                                .city("Islamabad")
                                .createdAt(LocalDateTime.now())
                                .updatedAt(LocalDateTime.now())
                                .build(),

                        // Rawalpindi Venues
                        Ground.builder()
                                .name("Rawalpindi Cricket Stadium")
                                .location("Adiala Road, Rawalpindi")
                                .latitude(33.6100)
                                .longitude(74.2850)
                                .description("International cricket stadium with excellent facilities, training ground, and spectator seating.")
                                .phoneNumber("051-5561222")
                                .city("Rawalpindi")
                                .createdAt(LocalDateTime.now())
                                .updatedAt(LocalDateTime.now())
                                .build(),

                        Ground.builder()
                                .name("Tench Bhatta Sports Complex")
                                .location("Tench Bhatta, Rawalpindi")
                                .latitude(33.6250)
                                .longitude(74.3200)
                                .description("Multi-sport facility featuring football pitch, basketball court, volleyball court, and badminton hall.")
                                .phoneNumber("051-5534567")
                                .city("Rawalpindi")
                                .createdAt(LocalDateTime.now())
                                .updatedAt(LocalDateTime.now())
                                .build(),

                        Ground.builder()
                                .name("Rawalpindi Tennis Club")
                                .location("Jinnah Road, Rawalpindi")
                                .latitude(33.5900)
                                .longitude(74.2950)
                                .description("Professional tennis facility with clay and hard courts, coaching academy, and modern amenities.")
                                .phoneNumber("051-5566789")
                                .city("Rawalpindi")
                                .createdAt(LocalDateTime.now())
                                .updatedAt(LocalDateTime.now())
                                .build(),

                        Ground.builder()
                                .name("Cantt. Football Ground")
                                .location("Cantt Area, Rawalpindi")
                                .latitude(33.6050)
                                .longitude(74.3100)
                                .description("Professional football pitch suitable for matches and training, flood-lit facilities available.")
                                .phoneNumber("051-5512345")
                                .city("Rawalpindi")
                                .createdAt(LocalDateTime.now())
                                .updatedAt(LocalDateTime.now())
                                .build(),

                        Ground.builder()
                                .name("Kuldana Ground")
                                .location("Kuldana, Rawalpindi")
                                .latitude(33.6400)
                                .longitude(74.3350)
                                .description("Open sports ground ideal for cricket, football, and general outdoor sports activities.")
                                .phoneNumber("051-5598765")
                                .city("Rawalpindi")
                                .createdAt(LocalDateTime.now())
                                .updatedAt(LocalDateTime.now())
                                .build(),

                        Ground.builder()
                                .name("Badminton Complex Rawalpindi")
                                .location("Saddar, Rawalpindi")
                                .latitude(33.5850)
                                .longitude(74.3050)
                                .description("Indoor badminton courts with professional facilities, coaching, and tournaments hosting.")
                                .phoneNumber("051-5576543")
                                .city("Rawalpindi")
                                .createdAt(LocalDateTime.now())
                                .updatedAt(LocalDateTime.now())
                                .build(),

                        // Twin Cities Additional Venues
                        Ground.builder()
                                .name("Twin Cities Squash Complex")
                                .location("Sector G-9, Islamabad")
                                .latitude(33.7500)
                                .longitude(73.1900)
                                .description("State-of-the-art squash facility with 4 professional courts and training programs.")
                                .phoneNumber("051-2830507")
                                .city("Islamabad")
                                .createdAt(LocalDateTime.now())
                                .updatedAt(LocalDateTime.now())
                                .build(),

                        Ground.builder()
                                .name("Urban Sports Hub")
                                .location("Kashmir Road, Rawalpindi")
                                .latitude(33.5950)
                                .longitude(74.3100)
                                .description("Contemporary multi-sport venue with basketball, volleyball, and recreational facilities for all ages.")
                                .phoneNumber("051-5545678")
                                .city("Rawalpindi")
                                .createdAt(LocalDateTime.now())
                                .updatedAt(LocalDateTime.now())
                                .build()
                );

                groundRepository.saveAll(grounds);
                System.out.println("✓ Dummy venue data initialized successfully. Total venues: " + grounds.size());
            }
        };
    }
}
