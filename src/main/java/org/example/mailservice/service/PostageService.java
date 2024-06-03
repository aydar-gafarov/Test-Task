package org.example.mailservice.service;

import org.example.mailservice.dto.PostageDTO;
import org.example.mailservice.dto.TrackingDTO;
import org.example.mailservice.entity.Postage;
import org.example.mailservice.entity.Tracking;

import java.util.List;

public interface PostageService {

    PostageDTO registerPostage(Postage postage);

    PostageDTO getPostage(Long id);

    TrackingDTO convertToDTO(Tracking tracking);

    List<TrackingDTO> getTrackingDTOs(Long postageId);


}
