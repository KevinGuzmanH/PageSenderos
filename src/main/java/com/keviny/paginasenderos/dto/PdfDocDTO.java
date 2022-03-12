package com.keviny.paginasenderos.dto;


import com.keviny.paginasenderos.enums.PdfLine;
import com.keviny.paginasenderos.enums.PdfType;
import org.springframework.data.annotation.Id;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

public class PdfDocDTO {


    @NotBlank
    private String title;
    @NotBlank
    private String description;
    @NotBlank
    private String image;
    @NotBlank
    private LocalDate date;
    @NotBlank
    private String author;
    @NotBlank
    private PdfType type;
    @NotBlank
    private PdfLine line;
    @NotBlank
    private String url;

}
