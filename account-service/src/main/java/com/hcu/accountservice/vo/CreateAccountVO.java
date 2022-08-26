package com.hcu.accountservice.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateAccountVO implements Serializable {
    private String username;

    private String name;

    private String surname;

    private String email;

    private Date birthDay;

    private String passwd;
}
