package org.example.mailservice.service;


import org.example.mailservice.dto.TrackingDTO;
import org.example.mailservice.entity.PostOffice;
import org.example.mailservice.entity.Postage;
import org.example.mailservice.entity.Tracking;
import org.example.mailservice.repository.PostOfficeRepository;
import org.example.mailservice.repository.PostageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TrackingServiceImpl implements TrackingService {

    @Autowired
    private PostageRepository postageRepository;

    @Autowired
    private PostOfficeRepository postOfficeRepository;

    @Override
    public TrackingDTO recordTracking(Postage postage, PostOffice postOffice, String status) {
        Tracking tracking = new Tracking(postage, postOffice, status);
        postage.setStatus(status);
        postage.getTrackings().add(tracking);
        postageRepository.save(postage);
        return new TrackingDTO(tracking);
    }


    @Override
    public TrackingDTO deliveredPostage(Long id, Long indexOffice) {
        Postage postage = postageRepository.findById(id).orElseThrow(() -> new RuntimeException("Postage not found"));
        PostOffice postOffice = postOfficeRepository.findByIndex(indexOffice);
        if (postOffice == null) {
            throw new RuntimeException("PostOffice not found");
        }
        postage.setStatus("Delivered to " + postOffice.getNameOffice() + " with index " + indexOffice + " on address " + postOffice.getAddress());
        return recordTracking(postage, postOffice, postage.getStatus());
    }

    @Override
    public TrackingDTO comeToOfficePostage(Long id, Long indexOffice) {
        Postage postage = postageRepository.findById(id).orElseThrow(() -> new RuntimeException("Postage not found"));
        PostOffice postOffice = postOfficeRepository.findByIndex(indexOffice);
        if (postOffice == null) {
            throw new RuntimeException("PostOffice not found");
        }
        postage.setStatus("Come to office " + postOffice.getNameOffice() + " with index " + indexOffice + " on address " + postOffice.getAddress());
        return recordTracking(postage, postOffice, postage.getStatus());
    }

    @Override
    public TrackingDTO incomeFromOfficePostage(Long id, Long indexOffice) {
        Postage postage = postageRepository.findById(id).orElseThrow(() -> new RuntimeException("Postage not found"));
        PostOffice postOffice = postOfficeRepository.findByIndex(indexOffice);
        if (postOffice == null) {
            throw new RuntimeException("PostOffice not found");
        }
        postage.setStatus("Income from office " + postOffice.getNameOffice() + " with index " + indexOffice + " on address " + postOffice.getAddress());
        return recordTracking(postage, postOffice, postage.getStatus());
    }

    @Override
    public TrackingDTO receivedPostage(Long id, Long indexOffice) {
        Postage postage = postageRepository.findById(id).orElseThrow(() -> new RuntimeException("Postage not found"));
        PostOffice postOffice = postOfficeRepository.findByIndex(indexOffice);
        if (postOffice == null) {
            throw new RuntimeException("PostOffice not found");
        }
        postage.setStatus("Received " + postage.getTypePostage() + " by " + postage.getRecipientName() + " from " + postOffice.getAddress());
        return recordTracking(postage, postOffice, postage.getStatus());
    }


}
