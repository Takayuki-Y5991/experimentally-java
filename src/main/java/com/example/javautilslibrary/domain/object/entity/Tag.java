package com.example.javautilslibrary.domain.object.entity;

import com.example.javautilslibrary.domain.object.Domain;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Builder(access = AccessLevel.PACKAGE)
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Tag extends Domain<Tag> {
    private Long tagId;
    private String name;


}
