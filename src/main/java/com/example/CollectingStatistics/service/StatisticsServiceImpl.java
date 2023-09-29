package com.example.CollectingStatistics.service;

import com.example.CollectingStatistics.dto.EventRequest;
import com.example.CollectingStatistics.model.Classifier;
import com.example.CollectingStatistics.model.Event;
import com.example.CollectingStatistics.repository.ClassifierRepository;
import com.example.CollectingStatistics.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class StatisticsServiceImpl implements StatisticsService {

    private final EventRepository eventRepository;
    private final ClassifierRepository classifierRepository;


    @Autowired
    public StatisticsServiceImpl(EventRepository eventRepository, ClassifierRepository classifierRepository) {
        this.eventRepository = eventRepository;
        this.classifierRepository = classifierRepository;
    }

    @Override
    public Page<Event> getListEvents(int page, int size, Long classifierId) {
        PageRequest pageRequest = PageRequest.of(page, size);
        if (classifierId != null) {
            return eventRepository.findByClassifier_Id(classifierId, pageRequest);
        } else {
            return eventRepository.findAll(pageRequest);
        }
    }

    @Override
    public ResponseEntity<Event> addEvent(EventRequest eventRequest) {
       Classifier classifier = classifierRepository.findById(eventRequest.getClassifierId())
        .orElseThrow(() -> new IllegalArgumentException("Invalid classifier ID"));
        Event event = new Event();
        event.setDescription(eventRequest.getDescription());
        event.setClassifier(classifier);
        event.setTimestamp(LocalDateTime.now());
        return ResponseEntity.ok(eventRepository.save(event));
    }
}
