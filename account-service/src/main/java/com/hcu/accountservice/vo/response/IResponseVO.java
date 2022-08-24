package com.hcu.accountservice.vo.response;

import java.util.Date;

public interface IResponseVO<T> {
    Integer getResCode();

    void setResCode(Integer resCode);

    String getResMessage();

    void setResMessage(String resMessage);

    T getResult();

    void setResult(T result);

    Date getTimestamp();

    void setTimestamp(Date timestamp);
}
