package com.example.CollectingStatistics.repository;

import com.example.CollectingStatistics.model.Event;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {
   Page<Event> findByClassifier_Id(Long id, Pageable pageable);
}
