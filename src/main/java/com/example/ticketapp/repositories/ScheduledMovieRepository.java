package com.example.ticketapp.repositories;

import com.example.ticketapp.model.ScheduledMovie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScheduledMovieRepository extends JpaRepository<ScheduledMovie, Integer> {
}
