package com.example.javautilslibrary.infrastructure.repository.entity.book;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * book return table entity <Event>
 */
@Data
@Entity
@Table(name = "book_return")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BookReturnEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_return_id", nullable = false)
    private Long bookReturnId;

    @Column(name = "return_date", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime returnDate;

    @OneToOne
    @JoinColumn(name = "book_rental_id")
    private BookRentalEntity rental;
}
