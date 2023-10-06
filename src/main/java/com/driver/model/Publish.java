package com.driver.model;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Publish {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    Book book;

    Author author;

    int Year_of_publishing;
}
