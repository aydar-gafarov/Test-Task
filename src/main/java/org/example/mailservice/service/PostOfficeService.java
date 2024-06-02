package org.example.mailservice.service;

import org.example.mailservice.entity.PostOffice;

public interface PostOfficeService {

    PostOffice registerPostOffice(PostOffice postOffice);

    PostOffice getPostOfficeById(Long id);



}
