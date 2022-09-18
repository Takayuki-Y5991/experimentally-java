package com.example.javautilslibrary.infrastructure.entity.book;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.UUID;

/**
 * Book table entity <Resource>
 */
@Data
@Entity
@Table(name = "book")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BookEntity {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator",
            parameters = {
                    @org.hibernate.annotations.Parameter(
                            name = "uuid_gen_strategy_class",
                            value = "org.hibernate.id.uuid.CustomVersionOneStrategy"
                    )
            }
    )
    @Column(name = "book_id", updatable = false, length = 36)
    private UUID bookId;

    @Column(name = "title", nullable = false, length = 100)
    private String title;

    @Column(name = "author", length = 50)
    private String author;

    @Column(name = "publisher", length = 50)
    private String publisher;

    @Column(name = "publish_date")
    private LocalDate publishDate;

    @Column(name = "description")
    private String description;

    @Column(name = "image_url")
    private String imageUrl;

    @Column(name = "status", columnDefinition = "integer default 0", length = 1)
    private Integer status;
}
