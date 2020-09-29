package com.example.shoppingapp.mapper;

import com.example.shoppingapp.dao.domain.BaseEntity;
import com.example.shoppingapp.dto.BaseDto;
import org.mapstruct.MappingTarget;

public interface BaseMapper<D extends BaseDto, E extends BaseEntity> {

    D entityToDto(E entity);

    E dtoToEntity(D dto);

    E updateEntityFromDto(D dto, @MappingTarget E entity);

}
