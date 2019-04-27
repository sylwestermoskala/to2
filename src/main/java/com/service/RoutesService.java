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

//    public List<Routes> getRouteByCategory(String category) {
//        List<Routes> result = new ArrayList<>();
//        Iterable<Routes> iterable =  routesRepository.findAllByCategory(category);
//        iterable.forEach(e-> result.add(e));
//        return result;
//    }

    public Routes findRouteById(int id) {
        return routesRepository.findRouteById(id);
    }

//    public void deleteRouteById(int id) {
//        routesRepository.deleteById(id);
//    }

//    public List<Routes> deleteRouteById(int id) {
//        // TODO Auto-generated method stub
//
//        List<Routes> result = new ArrayList<>();
//        Iterable<Routes> iterable =  routesRepository.findAll();
//        iterable.forEach(e-> result.add(e));
//        for(int i=0;i<result.size();i++) {
//            if(result.get(i).getId()==id) {
//                result.remove(i);
//            }
//        }
//        return result;
//    }

        public void deleteRouteById(int id) {
        routesRepository.deleteById(id);
    }

}
