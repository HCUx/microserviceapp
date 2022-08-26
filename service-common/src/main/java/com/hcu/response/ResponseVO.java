package com.hcu.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.Date;


@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ResponseVO<T> implements IResponseVO<T> {
    @NonNull
    private T result;

    @NonNull
    private String resMessage;

    @NonNull
    private Integer resCode;

    private Date timestamp = new Date();
}
