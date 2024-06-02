package org.example.mailservice.service;

import org.example.mailservice.entity.PostOffice;
import org.example.mailservice.repository.PostOfficeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostOfficeServiceImpl implements PostOfficeService {

    @Autowired
    private PostOfficeRepository postOfficeRepository;

    @Override
    public PostOffice registerPostOffice(PostOffice postOffice) {
        return postOfficeRepository.save(postOffice);
    }

    @Override
    public PostOffice getPostOfficeById(Long id) {
        return postOfficeRepository.findById(id).orElseThrow(() -> new RuntimeException("PostOffice not found"));
    }
}
