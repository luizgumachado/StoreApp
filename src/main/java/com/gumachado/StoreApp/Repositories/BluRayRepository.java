package com.gumachado.StoreApp.Repositories;

import com.gumachado.StoreApp.Models.BluRay;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BluRayRepository extends JpaRepository<BluRay, Long> {
}
