package com.example.javautilslibrary.infrastructure.repository.entity.book;

import com.example.javautilslibrary.infrastructure.repository.entity.member.MemberEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * Book rental table entity <Event>
 */
@Data
@Entity
@Table(name = "book_rental")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BookRentalEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_rental_id")
    private Long bookRentalId;

    @Column(name = "checkout_date", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime checkoutDate;

    @Column(name = "return_date", nullable = false)
    private LocalDateTime returnDate;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "book_id")
    private BookEntity book;

    @OneToOne
    @JoinColumn(name = "member_id")
    private MemberEntity member;
}
