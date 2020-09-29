package com.example.shoppingapp.service;

import com.example.shoppingapp.dao.domain.BaseEntity;
import com.example.shoppingapp.dao.repository.BaseRepository;
import com.example.shoppingapp.dto.BaseDto;
import com.example.shoppingapp.mapper.BaseMapper;
import javassist.NotFoundException;
import lombok.Getter;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Getter
public abstract class BaseService<R extends BaseRepository<E>,
        M extends BaseMapper<D, E>,
        D extends BaseDto,
        E extends BaseEntity> {

    private R repository;
    private M mapper;

    public BaseService(R repository, M mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public E create(E input) {
        return repository.save(input);
    }

    public D get(UUID uuid) throws NotFoundException {
        Optional<E> entity = repository.findByUuid(uuid);
        if (entity.isEmpty()) {
            throw new NotFoundException("Not Found");
        }
        return mapper.entityToDto(entity.get());
    }

    public List<D> getAll() {
        return repository.findAll().stream()
                .map(entity -> mapper.entityToDto(entity))
                .collect(Collectors.toList());
    }

    public D update(D dto) throws NotFoundException {
        E entity = repository.findByUuid(dto.getUuid()).orElseThrow(() -> new NotFoundException("Not Found"));
        E updateEntity = mapper.updateEntityFromDto(dto, entity);
        E saveUpdated = repository.save(updateEntity);
        return mapper.entityToDto(saveUpdated);
    }

    @Transactional
    public void delete(UUID uuid) {
        repository.deleteByUuid(uuid);
    }

}
