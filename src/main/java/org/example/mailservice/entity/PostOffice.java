package org.example.mailservice.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

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
