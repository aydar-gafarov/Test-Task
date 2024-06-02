package org.example.mailservice.repository;

import org.example.mailservice.entity.Tracking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrackingRepository extends JpaRepository<Tracking, Long> {


}
