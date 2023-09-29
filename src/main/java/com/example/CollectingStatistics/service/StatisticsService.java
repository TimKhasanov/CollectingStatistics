package com.example.CollectingStatistics.service;

import com.example.CollectingStatistics.dto.EventRequest;
import com.example.CollectingStatistics.model.Event;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;

public interface StatisticsService {
    public Page<Event> getListEvents(int page, int size, Long classifierId);

    public ResponseEntity<Event> addEvent(EventRequest eventRequest);
}
