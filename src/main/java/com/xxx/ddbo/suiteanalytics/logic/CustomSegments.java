package com.xxx.ddbo.suiteanalytics.logic;

import java.util.List;

import com.xxx.ddbo.suiteanalytics.interfaces.ReturnReasonsBrandRepository;
import com.xxx.ddbo.suiteanalytics.objects.ReturnReasonBrand;

public class CustomSegments {

    private final ReturnReasonsBrandRepository rrRepo;

    public CustomSegments(ReturnReasonsBrandRepository rrRepo) {
        this.rrRepo = rrRepo;
    }

    public void printReturnReasonBrand(){
        List<ReturnReasonBrand> brand = rrRepo.findAll();
        for(ReturnReasonBrand rrBrand : brand){
            System.out.println(rrBrand.getRrBrandName());
        }
    }
}