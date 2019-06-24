package com.group.almighty.slidebackend.Dao;

import com.group.almighty.slidebackend.Model.Sms;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SmsDao extends JpaRepository<Sms, Long> {
}
