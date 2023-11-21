package com.bezkoder.springjwt.entities;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "shoppingcart_Item")
public class ShoppingCartItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long shoppingcartid;

    @Column(name="quantity")
    private int quantity;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne(fetch = FetchType.EAGER)
    //FetchType.EAGER: Điều này có nghĩa là khi bạn lấy một đối tượng ShoppingCartItem từ cơ sở dữ liệu.
    // JPA cũng sẽ tự động lấy dữ liệu của User liên quan và đưa vào trong đối tượng ShoppingCartItem.
    // Điều này có thể làm tăng hiệu suất khi thường xuyên sử dụng thông tin của User liên quan và
    // không muốn phải thực hiện thêm câu truy vấn.
    @JoinColumn(name = "User_id")
    @JsonIgnore
    private User user;


}