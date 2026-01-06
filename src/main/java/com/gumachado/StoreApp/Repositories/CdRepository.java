package com.gumachado.StoreApp.Repositories;

import com.gumachado.StoreApp.Models.Cd;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CdRepository extends JpaRepository<Cd, Long> {
}
