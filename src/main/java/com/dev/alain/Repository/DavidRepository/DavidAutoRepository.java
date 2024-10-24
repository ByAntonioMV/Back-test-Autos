package com.dev.alain.Repository.DavidRepository;

import com.dev.alain.Entity.DavidEntity.AutoDavid;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional("davidTransactionManager")
public interface DavidAutoRepository extends JpaRepository<AutoDavid,Integer> {
}
