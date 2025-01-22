package org.generation.jaita138.demo7.db.repo;

import java.util.List;

import org.generation.jaita138.demo7.db.entity.Park;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ParkRepo extends JpaRepository<Park, Long> {

    List<Park> findByDeleted(boolean deleted);

    // TEST JPA QUERY METHODS
    List<Park> findByAreaAndName(int area, String name);

    List<Park> findByAreaBetween(int min, int max);

    List<Park> findByAddressIsNull();

    // TEST QUERY JPQL
    @Query("select p from Park p where p.deleted = ?1")
    List<Park> findByDeletedInJPQL(boolean deleted);

    // TEST QUERY NATIVE
    @Query(value = "SELECT * FROM park p WHERE deleted = ?1", nativeQuery = true)
    List<Park> findByDeletedInSQL(boolean deleted);
}
