package org.example.mailservice.controller;

import org.example.mailservice.dto.TrackingDTO;
import org.example.mailservice.service.TrackingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TrackingController {

    @Autowired
    private TrackingService trackingService;

    @PostMapping("/tracking/register/cometooffice")
    public TrackingDTO registerTrackingComeToOffice(@RequestParam Long postageId, @RequestParam Long postOfficeId) {
        return trackingService.comeToOfficePostage(postageId, postOfficeId);
    }

    @PostMapping("/tracking/register/incomefromoffice")
    public TrackingDTO registerTrackingIncomeFromOffice(@RequestParam Long postageId, @RequestParam Long postOfficeId) {
        return trackingService.incomeFromOfficePostage(postageId, postOfficeId);
    }

    @PostMapping("/tracking/register/delivered")
    public TrackingDTO registerTrackingDelivered(@RequestParam Long postageId, @RequestParam Long postOfficeId) {
        return trackingService.deliveredPostage(postageId, postOfficeId);
    }

    @PostMapping("/tracking/register/received")
    public TrackingDTO registerTrackingReceived(@RequestParam Long postageId, @RequestParam Long postOfficeId) {
        return trackingService.receivedPostage(postageId, postOfficeId);
    }

}
