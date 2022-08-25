package com.ck4.mediaservice.entities;

import lombok.Getter;
import lombok.Setter;
import org.springframework.lang.NonNull;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table
@SequenceGenerator(name="SEQ_MEDIA_TYPE")
public class MediaType {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_MEDIA_TYPE")
    private long id;

    @NonNull
    private String name;
}
