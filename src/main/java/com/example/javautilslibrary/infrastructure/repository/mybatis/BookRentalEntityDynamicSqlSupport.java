package com.example.javautilslibrary.infrastructure.repository.mybatis;

import java.sql.JDBCType;
import java.time.LocalDateTime;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.AliasableSqlTable;
import org.mybatis.dynamic.sql.SqlColumn;

public final class BookRentalEntityDynamicSqlSupport {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-10-09T22:09:59.179015386+09:00", comments="Source Table: book_rental")
    public static final BookRentalEntity bookRentalEntity = new BookRentalEntity();

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-10-09T22:09:59.179039619+09:00", comments="Source field: book_rental.book_rental_id")
    public static final SqlColumn<Long> bookRentalId = bookRentalEntity.bookRentalId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-10-09T22:09:59.179051819+09:00", comments="Source field: book_rental.checkout_date")
    public static final SqlColumn<LocalDateTime> checkoutDate = bookRentalEntity.checkoutDate;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-10-09T22:09:59.179061322+09:00", comments="Source field: book_rental.return_date")
    public static final SqlColumn<LocalDateTime> returnDate = bookRentalEntity.returnDate;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-10-09T22:09:59.179070385+09:00", comments="Source field: book_rental.book_id")
    public static final SqlColumn<String> bookId = bookRentalEntity.bookId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-10-09T22:09:59.179079009+09:00", comments="Source field: book_rental.member_id")
    public static final SqlColumn<Long> memberId = bookRentalEntity.memberId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-10-09T22:09:59.179028897+09:00", comments="Source Table: book_rental")
    public static final class BookRentalEntity extends AliasableSqlTable<BookRentalEntity> {
        public final SqlColumn<Long> bookRentalId = column("book_rental_id", JDBCType.BIGINT);

        public final SqlColumn<LocalDateTime> checkoutDate = column("checkout_date", JDBCType.TIMESTAMP);

        public final SqlColumn<LocalDateTime> returnDate = column("return_date", JDBCType.TIMESTAMP);

        public final SqlColumn<String> bookId = column("book_id", JDBCType.VARCHAR);

        public final SqlColumn<Long> memberId = column("member_id", JDBCType.BIGINT);

        public BookRentalEntity() {
            super("book_rental", BookRentalEntity::new);
        }
    }
}