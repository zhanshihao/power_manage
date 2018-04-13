package com.shihao.power.repository;

import com.shihao.power.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 创建数据库访问接口
 * */
public interface UserRepository extends JpaRepository<User,Long>{
    /* 通过用户名查询,返回用户对象 */
    User findByUsername(String username);
}
