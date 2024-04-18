////package bd.edu.diu.cis.library.model;
////
////import lombok.AllArgsConstructor;
////import lombok.Data;
////import lombok.NoArgsConstructor;
////
////import javax.persistence.*;
////
////@Data
////@AllArgsConstructor
////@NoArgsConstructor
////@Entity
////@Table(name = "products", uniqueConstraints = @UniqueConstraint(columnNames = {"name", "image"}))
////public class Product {
////    @Id
////    @GeneratedValue(strategy = GenerationType.IDENTITY)
////    @Column(name = "product_id")
////    private Long id;
////    private String name;
////    private String description;
////    private double costPrice;
////    private double salePrice;
////    private int currentQuantity;
////    @Lob
////    @Column(columnDefinition = "MEDIUMBLOB")
////    private String image;
////    @ManyToOne
////    @JoinColumn(name = "category_id")
////    private Category category;
////    private boolean is_deleted;
////    private boolean is_activated;
////}
//
//
//package bd.edu.diu.cis.library.model;
//
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//import lombok.ToString;
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
//
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "category_id")
//    @ToString.Exclude // Exclude from toString() to avoid circular reference
//    private Category category;
//
//    private boolean is_deleted;
//    private boolean is_activated;
//
//    @Override
//    public String toString() {
//        return "Product{" +
//                "id=" + id +
//                ", name='" + name + '\'' +
//                ", description='" + description + '\'' +
//                ", costPrice=" + costPrice +
//                ", salePrice=" + salePrice +
//                ", currentQuantity=" + currentQuantity +
//                ", image='" + image + '\'' +
//                ", is_deleted=" + is_deleted +
//                ", is_activated=" + is_activated +
//                '}';
//    }
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

    // Private constructor for builder's use only
    private Product(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.description = builder.description;
        this.costPrice = builder.costPrice;
        this.salePrice = builder.salePrice;
        this.currentQuantity = builder.currentQuantity;
        this.image = builder.image;
        this.category = builder.category;
        this.is_deleted = builder.is_deleted;
        this.is_activated = builder.is_activated;
    }

    // Builder class
    public static class Builder {
        private Long id;
        private String name;
        private String description;
        private double costPrice;
        private double salePrice;
        private int currentQuantity;
        private String image;
        private Category category;
        private boolean is_deleted;
        private boolean is_activated;

        public Builder() {}

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder description(String description) {
            this.description = description;
            return this;
        }

        public Builder costPrice(double costPrice) {
            this.costPrice = costPrice;
            return this;
        }

        public Builder salePrice(double salePrice) {
            this.salePrice = salePrice;
            return this;
        }

        public Builder currentQuantity(int currentQuantity) {
            this.currentQuantity = currentQuantity;
            return this;
        }

        public Builder image(String image) {
            this.image = image;
            return this;
        }

        public Builder category(Category category) {
            this.category = category;
            return this;
        }

        public Builder is_deleted(boolean is_deleted) {
            this.is_deleted = is_deleted;
            return this;
        }

        public Builder is_activated(boolean is_activated) {
            this.is_activated = is_activated;
            return this;
        }

        // Build method to instantiate Product object
        public Product build() {
            return new Product(this);
        }
    }

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
