package org.example.mailservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TrackingDTO {
    private String status;

    private String postOfficeName;

    private String postOfficeIndex;

}
