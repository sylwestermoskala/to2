package com.repository;

import com.domain.Routes;
import org.springframework.data.repository.CrudRepository;

public interface RoutesRepository extends CrudRepository<Routes, Integer> {
//    List<Routes> findAllByCategory(String category);
    Routes findRouteById(int id);

}
