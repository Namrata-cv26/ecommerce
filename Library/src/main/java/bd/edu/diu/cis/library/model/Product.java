//package bd.edu.diu.cis.library.model;
//
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//import javax.persistence.*;
//
//@Data
//@AllArgsConstructor
//@NoArgsConstructor
//@Entity
//@Table(name = "products", uniqueConstraints = @UniqueConstraint(columnNames = {"name", "image"}))
//public class Product {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "product_id")
//    private Long id;
//    private String name;
//    private String description;
//    private double costPrice;
//    private double salePrice;
//    private int currentQuantity;
//    @Lob
//    @Column(columnDefinition = "MEDIUMBLOB")
//    private String image;
//    @ManyToOne
//    @JoinColumn(name = "category_id")
//    private Category category;
//    private boolean is_deleted;
//    private boolean is_activated;
//}


package bd.edu.diu.cis.library.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "products", uniqueConstraints = @UniqueConstraint(columnNames = {"name", "image"}))
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Long id;
    private String name;
    private String description;
    private double costPrice;
    private double salePrice;
    private int currentQuantity;
    @Lob
    @Column(columnDefinition = "MEDIUMBLOB")
    private String image;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    @ToString.Exclude // Exclude from toString() to avoid circular reference
    private Category category;

    private boolean is_deleted;
    private boolean is_activated;

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", costPrice=" + costPrice +
                ", salePrice=" + salePrice +
                ", currentQuantity=" + currentQuantity +
                ", image='" + image + '\'' +
                ", is_deleted=" + is_deleted +
                ", is_activated=" + is_activated +
                '}';
    }
}
