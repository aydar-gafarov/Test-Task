package org.example.mailservice.controller;

import org.example.mailservice.entity.PostOffice;
import org.example.mailservice.service.PostOfficeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/postoffice")
public class PostOfficeController {

    @Autowired
    private PostOfficeService postOfficeService;

    @PostMapping("/register")
    public PostOffice registerPostOffice(@RequestBody PostOffice postOffice) {
        return postOfficeService.registerPostOffice(postOffice);
    }

    @GetMapping({"/{index}"})
    public PostOffice getPostOffice(@PathVariable Long index) {
        return postOfficeService.getPostOfficeById(index);
    }


}
