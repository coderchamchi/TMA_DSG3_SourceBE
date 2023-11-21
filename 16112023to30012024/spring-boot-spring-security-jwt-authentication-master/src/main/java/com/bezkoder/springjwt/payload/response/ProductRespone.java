package com.bezkoder.springjwt.payload.response;

import com.bezkoder.springjwt.entities.Category;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductRespone {
    private String productname;

    private int price;

    private String description;

    private LocalDate created_at;

    private LocalDate updated_at;

    private int warehouse;

    private int discount;

    private int size;

    private String base64;

    private boolean deleted;

    private String category;

}
