package com.hcu.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class AccountVO implements Serializable {
    private String id;

    private String username;

    private String name;

    private String surname;

    private Date birthDay;

    private String email;

    public String getNameSurname() {
        return this.name + " " + this.surname;
    }
}
