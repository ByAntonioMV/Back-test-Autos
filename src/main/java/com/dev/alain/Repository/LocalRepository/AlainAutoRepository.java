package com.dev.alain.Repository.LocalRepository;

import com.dev.alain.Entity.LocalEntity.Auto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
@Transactional("alainTransactionManager")
public interface AlainAutoRepository extends JpaRepository<Auto,Integer> {
}
