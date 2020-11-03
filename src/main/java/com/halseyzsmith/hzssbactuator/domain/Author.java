package com.halseyzsmith.hzssbactuator.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String firstName;

    private String middleName;

    private String lastName;

    private String imageUrl;

    @Lob
    @Column(columnDefinition = "CLOB")
    private String biography;

    public String getFullName() {
        return String.format("%s %s %s", this.firstName, this.middleName, this.lastName);
    }

}
