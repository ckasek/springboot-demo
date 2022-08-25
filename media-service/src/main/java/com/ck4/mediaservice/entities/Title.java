package com.ck4.mediaservice.entities;

import lombok.Getter;
import lombok.Setter;
import org.springframework.lang.NonNull;

import javax.persistence.*;

@Getter
@Setter
@Entity
@SequenceGenerator(name="SEQ_TITLE")
public class Title {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_MEDIA")
    private long id;

    @NonNull
    private String name;

    private String publisher;

    private String studio;

    private String director;
}
