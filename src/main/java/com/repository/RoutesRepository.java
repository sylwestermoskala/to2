package com.repository;

import com.domain.Routes;
import org.springframework.data.repository.CrudRepository;

public interface RoutesRepository extends CrudRepository<Routes, Integer> {
    Routes findRouteById(int id);
}
