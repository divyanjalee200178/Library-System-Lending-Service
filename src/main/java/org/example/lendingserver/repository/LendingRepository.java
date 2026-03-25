package org.example.lendingserver.repository;

import org.example.lendingserver.entity.Lending;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LendingRepository extends JpaRepository<Lending, String> {
    List<Lending> findByReaderId(String readerId);
    List<Lending> findByBookId(String bookId);
}