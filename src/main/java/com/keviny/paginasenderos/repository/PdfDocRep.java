package com.keviny.paginasenderos.repository;

import com.keviny.paginasenderos.entity.PdfDocument;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PdfDocRep extends CrudRepository<PdfDocument, String> {
    public Optional<PdfDocument> findByTitle(String title);

    public List<PdfDocument> findAll(Pageable pageable);
    public List<PdfDocument> findAll();
    public List<PdfDocument> findAllByAuthorsContains(String author, Pageable pageable);
    public List<PdfDocument> findAllByTitleContains(String title, Pageable pageable);
    public Long countByAuthorsContains(String author);

}
