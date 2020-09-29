package com.example.shoppingapp.dao.repository;

import com.example.shoppingapp.dao.domain.BaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.Optional;
import java.util.UUID;

@NoRepositoryBean
@CrossOrigin("http://localhost:4200")
public interface BaseRepository<E extends BaseEntity> extends JpaRepository<E, Long> {

    Optional<E> findByUuid(UUID uuid);

    void deleteByUuid(UUID uuid);

}
