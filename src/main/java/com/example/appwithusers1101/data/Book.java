package com.example.appwithusers1101.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id")
    private int id;

    @Column(name = "book_title")
    private String title;

    @Column(name = "book_publishing_date")
    private Date publishingDate;

    @Column(name = "book_some_date_1")
    private LocalDateTime pubDate1;

    @Column(name = "book_some_date_2")
    private LocalDate localDate;

    @Column(name = "book_some_date_3")
    private Timestamp timestamp;

    public void test() {
        var d = timestamp.toLocalDateTime().plusDays(45);
        var times = Timestamp.valueOf(d);
    }
}
