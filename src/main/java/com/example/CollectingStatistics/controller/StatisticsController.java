package com.example.CollectingStatistics.controller;

import com.example.CollectingStatistics.dto.EventRequest;
import com.example.CollectingStatistics.model.Event;
import com.example.CollectingStatistics.service.StatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/statistics")
public class StatisticsController {

    private final StatisticsService statisticsService;

    @Autowired
    public StatisticsController(StatisticsService statisticsService) {
        this.statisticsService = statisticsService;
    }


    @GetMapping("/list")
    public Page<Event> getListEvents(@RequestParam(name = "page", defaultValue = "0") int page,
                                     @RequestParam(name = "size", defaultValue = "10") int size,
                                     @RequestParam(name = "classifierId", required = false) Long classifierId) {
        return statisticsService.getListEvents(page, size, classifierId);
    }

    @PostMapping("/add")
    public ResponseEntity<Event> addEvent(@RequestBody EventRequest eventRequest) {
        return ResponseEntity.ok(statisticsService.addEvent(eventRequest).getBody());
    }

}
