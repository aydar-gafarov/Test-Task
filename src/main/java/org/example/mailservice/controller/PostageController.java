package org.example.mailservice.controller;

import org.example.mailservice.dto.PostageDTO;
import org.example.mailservice.dto.TrackingDTO;
import org.example.mailservice.entity.Postage;
import org.example.mailservice.entity.Tracking;
import org.example.mailservice.service.PostageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/postage")
public class PostageController {

    @Autowired
    private PostageService postageService;

    @PostMapping("/register")
    public PostageDTO registerPostage(@RequestBody Postage postage) {
        return postageService.registerPostage(postage);
    }

    @GetMapping({"/{id}"})
    public PostageDTO getPostage(@PathVariable Long id) {
        return postageService.getPostage(id);
    }

    @GetMapping("/{id}/tracking")
    public List<TrackingDTO> getPostageTracking(@PathVariable Long id) {
        return postageService.getTrackingDTOs(id);
    }
}
