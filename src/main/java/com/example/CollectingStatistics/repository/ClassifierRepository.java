package com.example.CollectingStatistics.repository;

import com.example.CollectingStatistics.model.Classifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassifierRepository extends JpaRepository<Classifier, Integer> {

}
