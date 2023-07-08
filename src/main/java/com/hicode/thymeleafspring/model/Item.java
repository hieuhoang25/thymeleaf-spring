package com.hicode.thymeleafspring.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
/**
 * @table : Item
 * */
@Table(name="tbl_item")
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Item {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    @CreationTimestamp
    private LocalDateTime createDate;
}
