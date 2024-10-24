package com.dev.alain.Repository.LocalRepository;

import com.dev.alain.Entity.LocalEntity.Sucursal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlainSucursalRepository extends JpaRepository<Sucursal,Integer> {
}
