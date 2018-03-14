package com.xxx.ddbo.postgresql.objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "custom_lists")
public class CustomLists {

    @Id
    @Column
    private String listIntId;

    @Column
    private String mongoId;

    public CustomLists(String listIntId) {
        this.listIntId = listIntId;
    }

    public CustomLists() {
    }

    public String getListIntId() {
        return listIntId;
    }

    public void setListIntId(String listIntId) {
        this.listIntId = listIntId;
    }

    public String getMongoId() {
        return mongoId;
    }

    public void setMongoId(String mongoId) {
        this.mongoId = mongoId;
    }

}   