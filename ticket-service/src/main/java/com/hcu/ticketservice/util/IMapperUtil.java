package com.hcu.ticketservice.util;

import org.springframework.data.domain.Slice;

import java.util.List;

public interface IMapperUtil {
    <S, T> List<T> mapList(List<S> source, Class<T> targetClass);

    <S, T> List<T> mapList(Slice<S> source, Class<T> targetClass);
}
