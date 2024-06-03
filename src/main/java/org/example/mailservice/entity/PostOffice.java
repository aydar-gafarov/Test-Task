package org.example.mailservice.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class PostOffice {

    @Id
    private Long index;

    private String nameOffice;

    private String address;

    public PostOffice(long l, String s, String moscow) {
        this.index = l;
        this.nameOffice = s;
        this.address = moscow;
    }

    public PostOffice() {

    }
}
