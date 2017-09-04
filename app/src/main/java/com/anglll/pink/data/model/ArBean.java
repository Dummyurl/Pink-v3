package com.anglll.pink.data.model;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class ArBean {
    /**
     * id : 60841
     * name : Idina Menzel
     * tns : [""]
     * alias : [""]
     */
@Id
    public Long id;
    public String name;
    @Generated(hash = 61060216)
    public ArBean(Long id, String name) {
        this.id = id;
        this.name = name;
    }
    @Generated(hash = 1885236816)
    public ArBean() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
}