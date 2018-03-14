package com.xxx.ddbo.suiteanalytics.objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "rr_brand")
public class ReturnReasonBrand {

    @Id
    @Column(name = "RR_BRAND_ID")
    private Integer rrBrandId;
    @Column(name = "RR_BRAND_NAME")
    private String rrBrandName;

    public Integer getRrBrandId() {
        return rrBrandId;
    }

    public void setRrBrandId(Integer rrBrandId) {
        this.rrBrandId = rrBrandId;
    }

    public String getRrBrandName() {
        return rrBrandName;
    }

    public void setRrBrandName(String rrBrandName) {
        this.rrBrandName = rrBrandName;
    }

	
    
    
}