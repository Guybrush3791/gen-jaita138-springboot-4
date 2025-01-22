package org.generation.jaita138.demo7.db.service;

import java.util.List;

import org.generation.jaita138.demo7.db.entity.Park;
import org.generation.jaita138.demo7.db.repo.ParkRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ParkService {

    @Autowired
    private ParkRepo parkRepo;

    public void save(Park park) {

        parkRepo.save(park);
    }

    public List<Park> findAll() {

        return parkRepo.findAll();
    }

    public List<Park> findActive() {

        return parkRepo.findByDeleted(false);
    }

    public void delete(Park park) {

        parkRepo.delete(park);
    }

    public void softDelete(Park park) {

        park.softDelete();
        save(park);
    }

    // TEST JPA QUERY METHODS
    public List<Park> findByAreaAndName(int area, String name) {

        return parkRepo.findByAreaAndName(area, name);
    }

    public List<Park> findByAreaBetween(int min, int max) {

        return parkRepo.findByAreaBetween(min, max);
    }

    public List<Park> findByAddressIsNull() {

        return parkRepo.findByAddressIsNull();
    }

    public List<Park> findActiveParkByJQPL() {

        return parkRepo.findByDeletedInJPQL(false);
    }

    public List<Park> findActiveParkBySQL() {

        return parkRepo.findByDeletedInSQL(false);
    }

    public List<Park> findNotActiveParkBySQL() {

        return parkRepo.findByDeletedInSQL(true);
    }

}
