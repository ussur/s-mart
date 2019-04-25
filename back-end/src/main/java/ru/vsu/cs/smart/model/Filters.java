package ru.vsu.cs.smart.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Data
@Entity
@Table(name="filters")
public class Filters {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_sequence")
    private Long id;
    @Column
    private String category;
    @Column
    private String hint;
    @Column(name="min_price")
    private Integer minPrice;
    @Column(name="max_price")
    private Integer maxPrice;
    @Column
    private Byte rating;
    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;
    @OneToOne(mappedBy = "filters")
    private Notification notification;
}
