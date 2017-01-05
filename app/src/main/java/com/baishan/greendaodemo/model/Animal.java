package com.baishan.greendaodemo.model;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by RayYeung on 2016/11/4.
 */
@Entity
public class Animal {
    @Id(autoincrement = true)
    public Long id;

    public String name;

    @Generated(hash = 946028812)
    public Animal(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    @Generated(hash = 308569294)
    public Animal() {
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

    @Override
    public String toString() {
        return "Animal{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
