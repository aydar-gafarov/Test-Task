package org.example.mailservice.service;

import org.example.mailservice.dto.PostOfficeDTO;
import org.example.mailservice.entity.PostOffice;

public interface PostOfficeService {

    PostOfficeDTO registerPostOffice(PostOffice postOffice);

    PostOfficeDTO getPostOfficeById(Long id);



}
