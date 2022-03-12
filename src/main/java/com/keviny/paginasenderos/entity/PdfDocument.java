package com.keviny.paginasenderos.entity;

import com.keviny.paginasenderos.enums.PdfLine;
import com.keviny.paginasenderos.enums.PdfType;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.List;

@Document
@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor(access=AccessLevel.PRIVATE, force=true)
public class PdfDocument {

    @Id
    private String id;
    private String title;
    private String description;
    private String image;
    private LocalDate date;
    private List<String> authors;
    private PdfType type;
    private PdfLine line;
    private String url;
}
