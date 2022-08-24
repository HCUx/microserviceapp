package com.hcu.accountservice.util.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hcu.accountservice.util.IMapperUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class MapperUtil implements IMapperUtil {
    private final ObjectMapper objectMapper;

    @Override
    public <S, T> List<T> mapList(List<S> source, Class<T> targetClass) {
        return source.stream()
                .map(element -> objectMapper.convertValue(element, targetClass))
                .collect(Collectors.toList());
    }

    @Override
    public <S, T> List<T> mapList(Slice<S> source, Class<T> targetClass) {
        return source.stream()
                .map(element -> objectMapper.convertValue(element, targetClass))
                .collect(Collectors.toList());
    }
}
