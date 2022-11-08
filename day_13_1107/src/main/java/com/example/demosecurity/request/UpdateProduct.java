package com.example.demosecurity.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateProduct {
    private String productName;

    private Integer price;

    private String description;

}
