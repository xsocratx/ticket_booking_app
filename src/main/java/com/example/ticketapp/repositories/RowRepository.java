package com.example.ticketapp.repositories;

import com.example.ticketapp.model.Row;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RowRepository extends JpaRepository<Row, Integer> {
}
