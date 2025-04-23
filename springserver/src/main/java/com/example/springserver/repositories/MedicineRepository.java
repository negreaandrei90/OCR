package com.example.springserver.repositories;

import com.example.springserver.models.Medicine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MedicineRepository extends JpaRepository<Medicine, Long> {
    Medicine findMedicineById(Long medicineId);
    Optional<Medicine> findMedicineByName(String name);

    @Query(value = "SELECT * FROM medicine WHERE LOWER(name) LIKE LOWER(CONCAT(:partial_name, '%')) LIMIT 5", nativeQuery = true)
    List<Optional<Medicine>> findFiveByNameContaining(@Param("partial_name") String partialName);
}
