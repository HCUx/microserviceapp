package com.hcu.accountservice.util;

import java.util.List;

public interface IMapperUtil {
    <S, T> List<T> mapList(List<S> source, Class<T> targetClass);
}
