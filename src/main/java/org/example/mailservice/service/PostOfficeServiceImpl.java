package org.example.mailservice.service;

import org.example.mailservice.dto.PostOfficeDTO;
import org.example.mailservice.entity.PostOffice;
import org.example.mailservice.repository.PostOfficeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostOfficeServiceImpl implements PostOfficeService {

    @Autowired
    private PostOfficeRepository postOfficeRepository;

    @Override
    public PostOfficeDTO registerPostOffice(PostOffice postOffice) {
        PostOffice savedPostOffice = postOfficeRepository.save(postOffice);
        return new PostOfficeDTO(savedPostOffice);
    }

    @Override
    public PostOfficeDTO getPostOfficeById(Long id) {
        PostOffice postOffice = postOfficeRepository.findById(id).orElseThrow(() -> new RuntimeException("PostOffice not found"));
        return new PostOfficeDTO(postOffice);
    }
}
