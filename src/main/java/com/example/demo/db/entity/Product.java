package com.example.demo.db.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.UUID;

@Data
@Entity
public class Product {
    @Id
    @GeneratedValue(generator = "hibernate-uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private UUID id;

    @Column
    private String name;

    @Column
    private BigDecimal price;

    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "manufactur_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Manufacturer manufacturer;
}
