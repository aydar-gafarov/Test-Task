package org.example.mailservice.dto;

import lombok.Data;
import org.example.mailservice.entity.Postage;

import java.util.List;
import java.util.stream.Collectors;

@Data
public class PostageDTO {
    private Long id;
    private String recipientName;
    private Long recipientIndex;
    private String recipientAddress;
    private String typePostage;
    private Long indexSender;
    private String status;
    private List<TrackingDTO> trackings;

    public PostageDTO(Postage postage) {
        this.id = postage.getId();
        this.recipientName = postage.getRecipientName();
        this.recipientIndex = postage.getRecipientIndex();
        this.recipientAddress = postage.getRecipientAddress();
        this.typePostage = postage.getTypePostage();
        this.indexSender = postage.getIndexSender();
        this.status = postage.getStatus();
        this.trackings = postage.getTrackings().stream()
                .map(TrackingDTO::new)
                .collect(Collectors.toList());
    }
}
