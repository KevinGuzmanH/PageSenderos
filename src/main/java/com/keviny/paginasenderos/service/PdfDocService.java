package com.keviny.paginasenderos.service;

import com.keviny.paginasenderos.entity.PdfDocument;
import com.keviny.paginasenderos.repository.PdfDocRep;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
@Transactional
public class PdfDocService {

    private final PdfDocRep pdfDocRep;

    public PdfDocService(PdfDocRep pdfDocRep) {
        this.pdfDocRep = pdfDocRep;
    }

    public void save(PdfDocument pdfDoc) {
        pdfDocRep.save(pdfDoc);
    }

    public Optional<List<String>> findAuthors() {
        List<String> authors = new ArrayList<>();
        pdfDocRep.findAll().forEach(pdf -> authors.addAll(pdf.getAuthors()));
        return Optional.of(authors.stream().distinct().collect(Collectors.toList()));
    }

    public Optional<List<String>> findTitles() {
        List<String> titles = new ArrayList<>();
        pdfDocRep.findAll().forEach(pdf -> titles.add(pdf.getTitle()));
        return Optional.of(titles.stream().distinct().collect(Collectors.toList()));
    }

    public Optional<List<PdfDocument>> getAll(Pageable pageable) {
         List<PdfDocument> pdfDocuments = pdfDocRep.findAll(pageable);
         return pdfDocuments.isEmpty() ? Optional.empty() : Optional.of(pdfDocuments);
    }

    public Optional<List<PdfDocument>> getAllByAuthor(String author, Pageable pageable) {
        List<PdfDocument> pdfDocuments = pdfDocRep.findAllByAuthorsContains(author, pageable);
        return pdfDocuments.isEmpty() ? Optional.empty() : Optional.of(pdfDocuments);
    }

    public Long countAll() {
        return pdfDocRep.count();
    }

    public Long CountByAuthorsContains(String author) {
        return pdfDocRep.countByAuthorsContains(author);
    }

    public Optional<List<PdfDocument>> getAll() {
        return pdfDocRep.findAll().isEmpty() ? Optional.empty() : Optional.of(pdfDocRep.findAll());
    }

    public Optional<PdfDocument> findByTitle(String title) {
        return pdfDocRep.findByTitle(title);
    }
}


