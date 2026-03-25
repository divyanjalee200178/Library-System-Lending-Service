package org.example.lendingserver.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.example.lendingserver.dto.LendingRequestDTO;
import org.example.lendingserver.dto.LendingResponseDTO;
import org.example.lendingserver.service.LendingService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/lendings")
public class LendingController {
    private final LendingService lendingService;

    public LendingController(LendingService lendingService) {
        this.lendingService = lendingService;
    }

    @PostMapping
    public ResponseEntity<LendingResponseDTO> createLending(@RequestBody LendingRequestDTO dto) {
        return ResponseEntity.status(201).body(lendingService.createLending(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<LendingResponseDTO> updateLending(
            @PathVariable String id,
            @RequestBody LendingRequestDTO dto) {
        return ResponseEntity.ok(lendingService.updateLending(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLending(@PathVariable String id) {
        lendingService.deleteLending(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<LendingResponseDTO> getLending(@PathVariable String id) {
        return ResponseEntity.ok(lendingService.getLending(id));
    }

    @GetMapping
    public ResponseEntity<List<LendingResponseDTO>> getAllLendings() {
        return ResponseEntity.ok(lendingService.getAllLendings());
    }
}