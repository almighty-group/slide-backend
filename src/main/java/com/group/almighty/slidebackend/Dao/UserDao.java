package com.group.almighty.slidebackend.Dao;

import com.group.almighty.slidebackend.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends JpaRepository<User, Long>, JpaSpecificationExecutor<User> {
    User findByPhoneNumber(String phoneNumber);
}
