package com.goitcd5.module8_spring.controller.producer;

import com.goitcd5.module8_spring.dao.producer.Producer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProducerRepository extends JpaRepository<Producer, UUID> {

}
