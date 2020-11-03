package com.halseyzsmith.hzssbactuator.domain;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String title;

    private String asin;

    @Lob
    @Column(columnDefinition = "CLOB")
    private String summary;

    private String imageUrl;

    private String series;

    @ManyToOne
    private Author author;

    @Singular
    @ManyToMany
    private List<Category> categories = new ArrayList<>();
}
