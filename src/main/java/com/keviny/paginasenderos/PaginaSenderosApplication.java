package com.keviny.paginasenderos;

import com.keviny.paginasenderos.entity.PdfDocument;
import com.keviny.paginasenderos.repository.PdfDocRep;
import com.keviny.paginasenderos.service.PdfDocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class PaginaSenderosApplication {

    public static void main(String[] args) {
        SpringApplication.run(PaginaSenderosApplication.class, args);
    }

}
