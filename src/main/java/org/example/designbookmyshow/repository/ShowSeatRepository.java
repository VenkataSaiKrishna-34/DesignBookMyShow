package org.example.designbookmyshow.repository;

import org.example.designbookmyshow.model.Show;
import org.example.designbookmyshow.model.ShowSeat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ShowSeatRepository extends JpaRepository<ShowSeat, Long> {

    Optional<ShowSeat> findById(long id);
}
