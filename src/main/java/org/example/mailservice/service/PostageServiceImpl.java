package org.example.mailservice.service;


import org.example.mailservice.dto.TrackingDTO;
import org.example.mailservice.entity.PostOffice;
import org.example.mailservice.entity.Postage;
import org.example.mailservice.entity.Tracking;
import org.example.mailservice.repository.PostOfficeRepository;
import org.example.mailservice.repository.PostageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostageServiceImpl implements PostageService {

    @Autowired
    private PostOfficeRepository postOfficeRepository;

    @Autowired
    private PostageRepository postageRepository;

    @Override
    public Postage registerPostage(Postage postage) {
        PostOffice postOffice = postOfficeRepository.findByIndex(postage.getIndexSender());
        postage.setStatus("Just register in " + postOffice.getNameOffice() + " office with index " + postOffice.getIndex() + " on address " + postOffice.getAddress());
        Tracking tracking = new Tracking(postage, postOffice, postage.getStatus());
        postage.addTracking(tracking);
        return postageRepository.save(postage);
    }

    @Override
    public Postage getPostage(Long id) {
        return postageRepository.findById(id).orElseThrow(() -> new RuntimeException("Postage not found"));
    }

    @Override
    public List<TrackingDTO> getTrackingDTOs(Long postageId) {
        Postage postage = postageRepository.findById(postageId)
                .orElseThrow(() -> new IllegalArgumentException("Postage not found"));

        return postage.getTrackings().stream()
                .sorted(Comparator.comparing(Tracking::getId))
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public TrackingDTO convertToDTO(Tracking tracking) {
        return new TrackingDTO(
                tracking.getStatus(),
                tracking.getPostOffice().getNameOffice(),
                tracking.getPostOffice().getIndex().toString()
        );
    }


}
