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
@AllArgsConstructor
@NoArgsConstructor
public class PostOffice {

    @Id
    private Long index;

    private String nameOffice;

    private String address;

//    @OneToMany(cascade = CascadeType.ALL)
//    @JsonIgnore
//    private List<Postage> postages = new ArrayList<>();


}
