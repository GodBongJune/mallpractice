package shop.mtcoding.mall2.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter@Setter@Entity@Table(name="product_tb")
public class Product {

    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String price;
    private Integer qty;
}
