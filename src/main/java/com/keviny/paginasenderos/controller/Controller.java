package com.keviny.paginasenderos.controller;


import com.keviny.paginasenderos.entity.PdfDocument;
import com.keviny.paginasenderos.service.PdfDocService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Controller
@RequestMapping(path = "pdf")
@Slf4j
public class Controller {

    PdfDocService pdfDocService;

    public Controller(PdfDocService pdfDocService) {
        this.pdfDocService = pdfDocService;
    }

//    @GetMapping(path = "")
//    public String index(Model model) {
//        List<String> pdfs = new ArrayList<>();
//        pdfDocRep.findAll().forEach(pdfDoc -> pdfs.add(pdfDoc.getName()));
//        model.addAttribute("pdfs", pdfs);
//        return "pdf/index";
//    }

    @GetMapping
    public String getArticles(Model model,
                              @RequestParam("page") Optional<Double> page,
                              @RequestParam("autor") Optional<String> autor,
                              @RequestParam("titulo") Optional<String> titulo){

        List<PdfDocument> pdfProperties = new ArrayList<>();
        List<String> authors = new ArrayList<>();
        int totalPages = 0;

        int currentPage = page.orElse(1.0).intValue();
        Pageable pageable = PageRequest.of(currentPage-1,5);

        if (autor.isPresent()){
            totalPages = (int) Math.ceil(pdfDocService.CountByAuthorsContains(autor.get())/5D);
            pdfDocService.getAllByAuthor(autor.get(), pageable).ifPresent(pdfProperties::addAll);
        }else if (titulo.isPresent()){
            pdfDocService.findByTitle(titulo.get()).ifPresent(pdfProperties::add);
        }else {
            totalPages = (int) Math.ceil(pdfDocService.countAll()/5D);
            pdfDocService.getAll(pageable).ifPresent(pdfProperties::addAll);
        }

        pdfDocService.findAuthors().ifPresent(authors::addAll);

        model.addAttribute("totalPages", totalPages);
        model.addAttribute("currentPage", currentPage);
        model.addAttribute("pdfProperties",pdfProperties);
        model.addAttribute("authors",authors);
        return "articles";
    }

    @GetMapping(path = "flipbook")
    public String getPdfSave(@RequestParam Optional<String> booktitle, Model model){

        //model.addAttribute("pdfUrl",pdfDocService.findByTitle(booktitle.get()).get().getUrl());
        model.addAttribute("pdfUrl","https://online.fliphtml5.com/ulbpo/nyft/");
        return "flipbook";
    }

    @ResponseBody
    @GetMapping(path = "getTitles")
    public List<String> getTitles(){
        if (pdfDocService.findTitles().isPresent())
            return pdfDocService.findTitles().get();
         return new ArrayList<>();
    }

    @ResponseBody
    @GetMapping(path = "getAuthors")
    public List<String> getAuthors(){
        if (pdfDocService.findAuthors().isPresent())
            return pdfDocService.findTitles().get();
        return new ArrayList<>();
    }

    @PostMapping(path = "save")
    @ResponseBody
    public String getPdfs(PdfDocument pdfDocument){
        pdfDocument.setId(null);
        pdfDocument.setDate(LocalDate.now());
        pdfDocService.save(pdfDocument);
       return "Saved";
    }


}
