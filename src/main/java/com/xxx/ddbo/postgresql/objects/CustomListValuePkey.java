package com.xxx.ddbo.postgresql.objects;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class CustomListValuePkey implements Serializable {

    @Column
    private String listId;
    @Column
    private String valueIntId;

    public String getListId() {
        return listId;
    }

    public void setListId(String listId) {
        this.listId = listId;
    }

    public String getValueIntId() {
        return valueIntId;
    }

    public void setValueIntId(String valueIntId) {
        this.valueIntId = valueIntId;
    }
}
