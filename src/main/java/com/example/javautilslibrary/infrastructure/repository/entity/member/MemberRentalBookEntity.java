package com.example.javautilslibrary.infrastructure.repository.entity.member;

import com.example.javautilslibrary.infrastructure.repository.entity.book.BookEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Member Rental Book table entity <Resource>
 */
@Data
@Entity
@Table(name = "member_rental_book")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MemberRentalBookEntity implements Serializable {

    @Id
    @OneToOne
    @JoinColumn(name = "book_id")
    private BookEntity book;

    @Id
    @OneToOne
    @JoinColumn(name = "member_id")
    private MemberEntity member;
}
