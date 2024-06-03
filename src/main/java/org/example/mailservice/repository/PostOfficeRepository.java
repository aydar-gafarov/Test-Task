package org.example.mailservice.repository;

import org.example.mailservice.entity.PostOffice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostOfficeRepository extends JpaRepository<PostOffice, Long> {
    PostOffice findByIndex(Long index);
}
