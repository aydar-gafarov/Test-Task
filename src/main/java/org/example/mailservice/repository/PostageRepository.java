package org.example.mailservice.repository;

import org.example.mailservice.entity.Postage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostageRepository extends JpaRepository<Postage, Long> {

}
