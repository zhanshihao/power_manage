package com.shihao.power.entity;

import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
/**
 * 定义系统中的角色
 * 如：管理员，普通用户，VIP。。。
 */
public class Role {
    /* 系统中的角色名称*/
    private String name;

    /* 系统中的角色ID*/
    @Id
    @GeneratedValue
    private Integer id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
