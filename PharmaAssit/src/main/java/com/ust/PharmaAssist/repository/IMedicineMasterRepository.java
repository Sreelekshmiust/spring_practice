package com.ust.PharmaAssist.repository;

import com.ust.PharmaAssist.entity.MedicineMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * MedicineMaster Repository
 */
@Repository
public interface IMedicineMasterRepository extends JpaRepository<MedicineMaster,String> {
}
