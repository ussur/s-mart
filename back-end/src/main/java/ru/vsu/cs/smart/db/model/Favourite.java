package ru.vsu.cs.smart.db.model;

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
    @Column(name="product_url")
    private String productUrl;
    @Column(name="image_url")
    private String imageUrl;
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
