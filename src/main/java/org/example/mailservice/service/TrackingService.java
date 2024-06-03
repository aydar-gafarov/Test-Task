package org.example.mailservice.service;

import org.example.mailservice.dto.TrackingDTO;
import org.example.mailservice.entity.PostOffice;
import org.example.mailservice.entity.Postage;

public interface TrackingService {
    TrackingDTO recordTracking(Postage postage, PostOffice postOffice, String status);

    TrackingDTO deliveredPostage(Long id, Long indexOffice);

    TrackingDTO comeToOfficePostage(Long id, Long indexOffice);

    TrackingDTO incomeFromOfficePostage(Long id, Long indexOffice);

    TrackingDTO receivedPostage(Long id, Long indexOffice);


}
