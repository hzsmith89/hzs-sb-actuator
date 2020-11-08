package com.halseyzsmith.hzssbactuator.services;

import com.halseyzsmith.hzssbactuator.domain.Author;
import com.halseyzsmith.hzssbactuator.repositories.AuthorRepository;
import com.halseyzsmith.hzssbactuator.services.jms.JmsTextMessageService;
import io.micrometer.core.instrument.Metrics;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
public class AuthorService {

    private final AuthorRepository authorRepository;
    private final JmsTextMessageService jmsTextMessageService;

    public List<Author> getAuthors() {
        jmsTextMessageService.sendTextMessage("Getting all authors...");
        Metrics.counter("AuthorService.getAuthors").increment();
        return StreamSupport.stream(authorRepository.findAll().spliterator(), false).collect(Collectors.toList());
    }

    public Author getAuthorById(Integer id) {
        jmsTextMessageService.sendTextMessage("Getting Author with id: " + id);
        Metrics.counter("AuthorService.getAuthorById").increment();
        return authorRepository.findById(id).orElseThrow();
    }
}
