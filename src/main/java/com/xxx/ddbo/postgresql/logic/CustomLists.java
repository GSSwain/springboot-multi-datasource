package com.xxx.ddbo.postgresql.logic;

import java.util.List;

import com.xxx.ddbo.postgresql.interfaces.CustomListValuesRepository;
import com.xxx.ddbo.postgresql.objects.CustomListValues;


public class CustomLists {

    private final CustomListValuesRepository customListValuesRepository;

    public CustomLists(CustomListValuesRepository customListValuesRepository) {
        this.customListValuesRepository = customListValuesRepository;
    }

    public void printCustomListValues(){
        List<CustomListValues> values = customListValuesRepository.findAll();
        for(CustomListValues value: values){
            System.out.println(value.getValueText());
        }
    }
}
