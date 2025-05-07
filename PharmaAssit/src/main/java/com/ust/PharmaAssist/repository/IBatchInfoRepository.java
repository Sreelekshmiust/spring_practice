package com.ust.PharmaAssist.repository;

import com.ust.PharmaAssist.entity.BatchInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * BatchInfo Repository
 */
@Repository
public interface IBatchInfoRepository extends JpaRepository<BatchInfo,String> {
}
