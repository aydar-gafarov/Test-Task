package org.example.mailservice.dto;

import lombok.Data;
import org.example.mailservice.entity.Tracking;

@Data
public class TrackingDTO {
    private String status;

    private String postOfficeName;

    private String postOfficeIndex;

    public TrackingDTO(Tracking tracking) {
        this.postOfficeIndex = tracking.getPostOffice().getIndex().toString();
        this.postOfficeName = tracking.getPostOffice().getNameOffice();
        this.status = tracking.getStatus();
    }
}
