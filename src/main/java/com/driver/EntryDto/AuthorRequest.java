package com.driver.EntryDto;

import com.driver.model.Gender;
import lombok.*;
import lombok.experimental.FieldDefaults;


@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AuthorRequest {
    String name;

    int age;

    Gender gender;

    int rating;
}
