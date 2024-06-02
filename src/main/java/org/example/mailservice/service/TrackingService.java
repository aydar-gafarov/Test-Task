package org.example.mailservice.service;

import org.example.mailservice.entity.PostOffice;
import org.example.mailservice.entity.Postage;
import org.example.mailservice.entity.Tracking;

public interface TrackingService {
    Tracking recordTracking(Postage postage, PostOffice postOffice, String status);

    Tracking deliveredPostage(Long id, Long indexOffice);
    Tracking comeToOfficePostage(Long id, Long indexOffice);

    Tracking incomeFromOfficePostage(Long id, Long indexOffice);

    Tracking receivedPostage(Long id, Long indexOffice);


}
