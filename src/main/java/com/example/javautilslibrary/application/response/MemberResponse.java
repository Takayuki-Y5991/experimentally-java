package com.example.javautilslibrary.application.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MemberResponse {
    private Long memberId;
    private String name;
    private Integer sex;
    private String email;
    private String password;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthday;
    private String contact;
}
