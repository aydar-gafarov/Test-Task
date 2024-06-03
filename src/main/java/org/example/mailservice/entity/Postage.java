package org.example.mailservice.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Postage {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String recipientName;

    private Long recipientIndex;

    private String recipientAddress;

    private String typePostage;

    private Long indexSender;

    @JsonIgnore
    private String status;

    @OneToMany(mappedBy = "postage", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Tracking> trackings = new ArrayList<>();

    public Postage() {
    }

    public Postage(String recipientName, Long recipientIndex, String recipientAddress, String typePostage, Long indexSender) {
        this.recipientName = recipientName;
        this.recipientIndex = recipientIndex;
        this.recipientAddress = recipientAddress;
        this.typePostage = typePostage;
        this.indexSender = indexSender;
    }

    public void addTracking(Tracking tracking) {
        trackings.add(tracking);
        tracking.setPostage(this);
    }
}
