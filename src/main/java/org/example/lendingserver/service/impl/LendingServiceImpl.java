package org.example.lendingserver.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.lendingserver.dto.LendingRequestDTO;
import org.example.lendingserver.dto.LendingResponseDTO;
import org.example.lendingserver.entity.Lending;
import org.example.lendingserver.exception.DuplicateLendingException;
import org.example.lendingserver.exception.LendingNotFoundException;
import org.example.lendingserver.mapper.LendingMapper;
import org.example.lendingserver.repository.LendingRepository;
import org.example.lendingserver.service.LendingService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class LendingServiceImpl implements LendingService {

    private final LendingRepository lendingRepository;

    public LendingServiceImpl(LendingRepository lendingRepository) {
        this.lendingRepository = lendingRepository;
    }

    @Override
    @Transactional
    public LendingResponseDTO createLending(LendingRequestDTO dto) {
        Lending lending = new Lending();
        lending.setLendingId(dto.getLendingId());
        lending.setReaderId(dto.getReaderId());
        lending.setBookId(dto.getBookId());
        lending.setBorrowedDate(dto.getBorrowedDate());
        lending.setDueDate(dto.getDueDate());
        lending.setReturnDate(dto.getReturnDate());
        lending.setStatus(dto.getStatus());

        Lending saved = lendingRepository.save(lending);
        return mapToDTO(saved);
    }

    @Override
    @Transactional
    public LendingResponseDTO updateLending(String lendingId, LendingRequestDTO dto) {
        Lending lending = lendingRepository.findById(lendingId)
                .orElseThrow(() -> new LendingNotFoundException(lendingId));

        lending.setReaderId(dto.getReaderId());
        lending.setBookId(dto.getBookId());
        lending.setBorrowedDate(dto.getBorrowedDate());
        lending.setDueDate(dto.getDueDate());
        lending.setReturnDate(dto.getReturnDate());
        lending.setStatus(dto.getStatus());

        Lending updated = lendingRepository.save(lending);
        return mapToDTO(updated);
    }

    @Override
    @Transactional
    public void deleteLending(String lendingId) {
        Lending lending = lendingRepository.findById(lendingId)
                .orElseThrow(() -> new LendingNotFoundException(lendingId));
        lendingRepository.delete(lending);
    }

    @Override
    @Transactional(readOnly = true)
    public LendingResponseDTO getLending(String lendingId) {
        Lending lending = lendingRepository.findById(lendingId)
                .orElseThrow(() -> new LendingNotFoundException(lendingId));
        return mapToDTO(lending);
    }

    @Override
    @Transactional(readOnly = true)
    public List<LendingResponseDTO> getAllLendings() {
        return lendingRepository.findAll()
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    private LendingResponseDTO mapToDTO(Lending lending) {
        LendingResponseDTO dto = new LendingResponseDTO();
        dto.setLendingId(lending.getLendingId());
        dto.setReaderId(lending.getReaderId());
        dto.setBookId(lending.getBookId());
        dto.setBorrowedDate(lending.getBorrowedDate());
        dto.setDueDate(lending.getDueDate());
        dto.setReturnDate(lending.getReturnDate());
        dto.setStatus(lending.getStatus());
        return dto;
    }
}