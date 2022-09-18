package com.example.javautilslibrary.infrastructure.entity.book;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * Tag table entity <Resource>
 */
@Data
@Entity
@Table(name = "tag")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TagEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tag_id")
    private Long tagId;

    @Column(name = "tag_name", length = 50, nullable = false)
    private String name;
}
