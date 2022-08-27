package com.goitcd5.module8_spring.dao.producer;


import java.util.List;
import java.util.Map;
import java.util.UUID;

public interface ProducerService {
    void saveProducer(Producer producer);

    void deleteProducer(UUID id);

    List<Producer> findAll();

    Producer findById(UUID id);

    Map<Producer, List<String>> getPrettyListForTemplate();
}
