package com.hcu.accountservice.vo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UpdateAccountVO extends CreateAccountVO {
    private String id;
}
