package org.example.mailservice.dto;


import lombok.Data;
import org.example.mailservice.entity.PostOffice;

@Data
public class PostOfficeDTO {

    private Long index;
    private String nameOffice;
    private String address;
    public PostOfficeDTO(PostOffice postOffice) {
        this.index = postOffice.getIndex();
        this.nameOffice = postOffice.getNameOffice();
        this.address = postOffice.getAddress();
    }
}
