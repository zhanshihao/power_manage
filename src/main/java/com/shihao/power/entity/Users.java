package com.shihao.power.entity;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * 定义用户
 * 实现UserDetails接口，用户实体被springSecurity所管理
 */
@Entity
public class Users implements UserDetails {

    private static final long serialVersionUID = 1L;

    /* 用户ID */
    @Id
    @GeneratedValue
    private Long id;
    /* 用户名 */
    private String username;
    /* 用户密码 */
    private String password;

    /*
     *对应系统角色
     *定义系统角色与用户之间的多对多关系
     * 即一个系统角色可以对用多个普通用户
     * 一个普通用户可以对用多个系统角色*/
    @ManyToMany(cascade = {CascadeType.REFRESH}, fetch = FetchType.EAGER)
    private List<Role> roles;

    /* 用于返回该用户所拥有的权限 */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // GrantedAuthority是一个接口，其中只定义了一个getAuthority()方法，其返回值为String类型
        List<GrantedAuthority> grant = new ArrayList<GrantedAuthority>();
        List<Role> role = this.getRoles();
        //由于角色和用户之间是多对多关系，所以一个用户可能有多个角色
        //因此获取用户所有的角色名称并加入都GrantedAuthority列表中
        for(Role rol : roles){
            //SimpleGrantedAuthority是GrantedAuthority的实现类
            //它可以直接接收一个表示权限信息的字符串
            //然后getAuthority()方法直接返回该字符串
            grant.add(new SimpleGrantedAuthority(rol.getName()));
        }
        return grant;
    }

    /* 获取用户名 */
    @Override
    public String getPassword() {
        return username;
    }

    /* 获取用户密码 */
    @Override
    public String getUsername() {
        return password;
    }

    /* 判断用户账号是否过期 */
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    /* 判断用户账号是否被锁定 */
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    /* 判断用户密码是否过期 */
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    /* 判断用户是否可以使用 */
    @Override
    public boolean isEnabled() {
        return true;
    }

    /* 获取用户ID */
    public Long getId() {
        return id;
    }

    /* 设置用户ID */
    public void setId(Long id) {
        this.id = id;
    }

    /* 设置用户名 */
    public void setUsername(String username) {
        this.username = username;
    }

    /* 设置用户密码 */
    public void setPassword(String password) {
        this.password = password;
    }

    /* 获取该用户的角色列表 */
    public List<Role> getRoles() {
        return roles;
    }

    /* 设置该用户的角色列表 */
    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
}
