package com.bezkoder.springjwt.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;
import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "product")
public class Product {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long productid;

    @Column(name = "title")
    private String productname;

    @Column(name = "price")
    private int price;

    @Column(name = "description")
    @Type(type = "text")
    private String description;

    @Column(name = "Createdate")
    private LocalDate created_at;

    @Column(name = "Updatedate")
    private LocalDate updated_at;

    @Column(name ="Warehouse")
    private int warehouse;

    @Column(name ="Discount")
    private int discount;

    @Column(name = "Size")
    private int size;

    @Column(name="thumbnail")
    @Type(type = "text")
    private String base64;

    @Column(name="deleted")
    private boolean deleted;

    @ManyToOne(fetch=FetchType.LAZY)
    //  Nếu dùng LAZY thì đây là giá trị mặc định. Khi lấy một đối tượng Product, thông tin của Category sẽ không được lấy ngay lập tức
    //  dữ liệu của Catefory sẽ chỉ được lấy từ cơ sở dữ liệu khi bạn thực sự truy cập trường category trong đối tượng Product.
    @JoinColumn(name = "category_id")
    @JsonIgnore
    private Category category;

    @OneToMany(mappedBy = "product")
    @JsonIgnore
    private List<ShoppingCartItem> listproduct;
    // =new Arraylist<>() là để tránh tình trạng null exception khi thao tác với class shoppingcartitem mà chưa khởi tạo
    // tuy nhiên ở đây không có là vì ở class user đã có rồi, đây không cần phải tạo nữa

}
