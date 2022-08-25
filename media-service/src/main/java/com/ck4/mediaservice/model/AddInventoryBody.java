package com.ck4.mediaservice.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddInventoryBody {
    private int quantity = 1;
    private Long mediaId;
}
