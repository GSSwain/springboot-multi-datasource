package com.xxx.ddbo.suiteanalytics.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.xxx.ddbo.suiteanalytics.objects.ReturnReasonBrand;

@Repository
public interface ReturnReasonsBrandRepository extends JpaRepository<ReturnReasonBrand, Integer>{
}
