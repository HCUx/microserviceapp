package com.hcu.accountservice.vo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
public class CreateAccountVO implements Serializable {
    private String userName;

    private String email;

    private String passwd;
}
