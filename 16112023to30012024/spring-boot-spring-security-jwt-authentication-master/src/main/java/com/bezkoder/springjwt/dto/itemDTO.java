package com.bezkoder.springjwt.dto;

import com.bezkoder.springjwt.entities.Product;
import com.bezkoder.springjwt.entities.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class itemDTO {
    private long product;
    private int quantity;
}
