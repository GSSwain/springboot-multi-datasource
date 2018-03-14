package com.xxx.ddbo.postgresql.objects;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "custom_list_values")
public class CustomListValues implements Serializable {

    @EmbeddedId
    private CustomListValuePkey pkey;

    @Column
    private String valueText;

    @ManyToOne
    @JoinColumn(name = "listIntId")
    private CustomLists listId;


    public CustomLists getListId() {
        return listId;
    }

    public void setListId(CustomLists listId) {
        this.listId = listId;
    }

    public String getValueText() {
        return valueText;
    }

    public void setValueText(String valueText) {
        this.valueText = valueText;
    }

    public CustomListValuePkey getPkey() {
        return pkey;
    }

    public void setPkey(CustomListValuePkey pkey) {
        this.pkey = pkey;
    }
}
