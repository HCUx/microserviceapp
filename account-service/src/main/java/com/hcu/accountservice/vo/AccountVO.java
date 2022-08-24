package com.hcu.accountservice.vo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
public class AccountVO implements Serializable {
    private String id;

    private String userName;

    private String email;
}
