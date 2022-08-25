package com.ck4.mediaservice.entities;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;

@Getter
@Setter
@Entity
@SequenceGenerator(name="SEQ_INVENTORY")
public class Inventory {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_INVENTORY")
    private long id;

    @ManyToOne
    @JoinColumn(name = "media_id")
    private Media media;

    @NotNull
    @ColumnDefault("true")
    private Boolean active;
}
