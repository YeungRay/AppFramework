package com.baishan.greendaodemo.model;

import com.baishan.greendaodemo.dao.AnimalDao;
import com.baishan.greendaodemo.dao.DaoSession;
import com.baishan.greendaodemo.dao.UserDao;

import org.greenrobot.greendao.DaoException;
import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.NotNull;
import org.greenrobot.greendao.annotation.ToOne;

/**
 * Created by RayYeung on 2016/9/1.
 */

@Entity
public class User {

    @Id(autoincrement = true)
    public Long id;
    public String name;
    public String pwd;
    @ToOne(joinProperty = "animalId")
    public Animal animal;
    public long animalId;
    /** Used to resolve relations */
    @Generated(hash = 2040040024)
    private transient DaoSession daoSession;
    /** Used for active entity operations. */
    @Generated(hash = 1507654846)
    private transient UserDao myDao;
    @Generated(hash = 1233853005)
    private transient Long animal__resolvedKey;


    public User(String name, String pwd, Animal animal) {
        this.name = name;
        this.pwd = pwd;
        this.animal = animal;
    }


    @Generated(hash = 2083190618)
    public User(Long id, String name, String pwd, long animalId) {
        this.id = id;
        this.name = name;
        this.pwd = pwd;
        this.animalId = animalId;
    }


    @Generated(hash = 586692638)
    public User() {
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


    public String getPwd() {
        return this.pwd;
    }


    public void setPwd(String pwd) {
        this.pwd = pwd;
    }


    public long getAnimalId() {
        return this.animalId;
    }


    public void setAnimalId(long animalId) {
        this.animalId = animalId;
    }


    /** To-one relationship, resolved on first access. */
    @Generated(hash = 807167411)
    public Animal getAnimal() {
        long __key = this.animalId;
        if (animal__resolvedKey == null || !animal__resolvedKey.equals(__key)) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            AnimalDao targetDao = daoSession.getAnimalDao();
            Animal animalNew = targetDao.load(__key);
            synchronized (this) {
                animal = animalNew;
                animal__resolvedKey = __key;
            }
        }
        return animal;
    }


    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 1341545879)
    public void setAnimal(@NotNull Animal animal) {
        if (animal == null) {
            throw new DaoException(
                    "To-one property 'animalId' has not-null constraint; cannot set to-one to null");
        }
        synchronized (this) {
            this.animal = animal;
            animalId = animal.getId();
            animal__resolvedKey = animalId;
        }
    }


    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#delete(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 128553479)
    public void delete() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.delete(this);
    }


    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#refresh(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 1942392019)
    public void refresh() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.refresh(this);
    }


    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#update(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 713229351)
    public void update() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.update(this);
    }


    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 2059241980)
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getUserDao() : null;
    }


}
