package com.example.javautilslibrary.infrastructure.repository.entity.book;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Book tag table entity <Resource>
 */
@Data
@Entity
@Table(name = "book_tag")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BookTagEntity implements Serializable {

    @Id
    @OneToOne
    @JoinColumn(name = "book_id")
    private BookEntity book;

    @Id
    @OneToOne
    @JoinColumn(name = "tag_id")
    private TagEntity tag;
}
