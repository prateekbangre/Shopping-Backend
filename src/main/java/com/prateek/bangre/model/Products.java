package com.prateek.bangre.model;

import lombok.*;

import javax.persistence.*;

/**
 * @author prateek.bangre on 26/04/20.
 * @Project Shoping-Backend
 */
@Entity
@Table(name = "products")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Products {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    @Column
    private String title;
    @Column
    private String image;
    @Column
    private String images;
    @Column
    private String description;
    @Column
    private float price;
    @Column
    private int quantity;
    @Column
    private String short_desc;
    @Column(name = "cat_id")
    private int catId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cat_id", nullable = false, insertable=false, updatable=false)
    private Categories categories;

}
