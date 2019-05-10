package com.service;

import com.domain.Routes;
import com.domain.Usersdetails;
import com.repository.RoutesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoutesService {

    @Autowired
    private RoutesRepository routesRepository;

    public List<Routes> getRoutes() {
        List<Routes> result = new ArrayList<>();
        Iterable<Routes> iterable =  routesRepository.findAll();
        iterable.forEach(e-> result.add(e));
        return result;
    }

    public Routes findRouteById(int id) {
        return routesRepository.findRouteById(id);
    }

    public void deleteRouteById(int id) {
        routesRepository.deleteById(id);
    }

    public Routes updateRoute(Routes routes) {
        return routesRepository.save(routes);
    }

    public Routes addRoute(Routes routes) {
        return routesRepository.save(routes);
    }
}
