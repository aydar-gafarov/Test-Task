package org.example.mailservice.service;

import org.example.mailservice.dto.PostageDTO;
import org.example.mailservice.entity.PostOffice;
import org.example.mailservice.entity.Postage;
import org.example.mailservice.repository.PostOfficeRepository;
import org.example.mailservice.repository.PostageRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class PostageServiceTest {

    @Autowired
    private PostageService postageService;

    @MockBean
    private PostageRepository postageRepository;

    @MockBean
    private PostOfficeRepository postOfficeRepository;

    private Postage postage;

    private PostOffice postOffice;

    @BeforeEach
    public void setup() {
        postage = new Postage("Andrey", 7890L, "Moscow", "посылка", 1234L);
        postOffice = new PostOffice(1234L, "1st office", "Moscow");
        Mockito.when(postOfficeRepository.findByIndex(postOffice.getIndex())).thenReturn(postOffice);
        Mockito.when(postageRepository.save(postage)).thenReturn(postage);
        Mockito.when(postageRepository.findById(postage.getId())).thenReturn(java.util.Optional.of(postage));
    }

    @Test
    public void testRegisterPostage() {
        postageService.registerPostage(postage);
        assertEquals("Just register in 1st office office with index 1234 on address Moscow", postage.getStatus());
    }

    @Test
    public void testGetPostage() {
        PostageDTO postageDTO = postageService.getPostage(postage.getId());
        assertEquals("Andrey", postage.getRecipientName());
    }
}
