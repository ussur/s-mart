package ru.vsu.cs.smart.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Data
@Entity
@Table(name="favourites")
public class Favourite {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_sequence")
    private Long id;
    @Column
    private String store;
    @Column(name="product_id")
    private String productId;
    @Column(name="product_name")
    private String productName;
    @Column
    private String category;
    @Column
    private Integer price;
    @Column
    private Byte rating;
    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;
}
