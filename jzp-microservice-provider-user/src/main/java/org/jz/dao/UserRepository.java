package org.jz.dao;

import org.jz.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Hongyi Zheng
 * @date 2018/4/3
 */
@Repository
public interface UserRepository extends JpaRepository<User,Long> {
}
