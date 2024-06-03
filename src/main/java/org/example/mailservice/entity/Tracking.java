package org.example.mailservice.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Tracking {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "postage_id")
    private Postage postage;

    @ManyToOne
    @JoinColumn(name = "post_office_index")
    private PostOffice postOffice;

    private String status;

    public Tracking() {
    }

    public Tracking(Postage postage, PostOffice postOffice, String status) {
        this.postOffice = postOffice;
        this.postage = postage;
        this.status = status;
    }

}
