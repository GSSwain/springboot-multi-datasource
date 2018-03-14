package com.xxx.ddbo.postgresql.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.xxx.ddbo.postgresql.objects.CustomListValuePkey;
import com.xxx.ddbo.postgresql.objects.CustomListValues;

@Repository
public interface CustomListValuesRepository extends JpaRepository<CustomListValues, CustomListValuePkey>{
}
