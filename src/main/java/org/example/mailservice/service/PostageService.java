package org.example.mailservice.service;

import org.example.mailservice.dto.TrackingDTO;
import org.example.mailservice.entity.Postage;
import org.example.mailservice.entity.Tracking;

import java.util.List;
import java.util.stream.Collectors;

public interface PostageService {

    Postage registerPostage(Postage postage);

    Postage getPostage(Long id);

//    List<Tracking> getTrackings(Long id);

//    Postage deliveredPostage(Long id);

//    Postage comeToOfficePostage(Long id, Long indexOffice);
//
//    Postage incomeFromOfficePostage(Long id, Long indexOffice);
    List<TrackingDTO> getTrackingDTOs(Long postageId);

    TrackingDTO convertToDTO(Tracking tracking);

}
