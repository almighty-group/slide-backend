package com.group.almighty.slidebackend.Dao;

import com.group.almighty.slidebackend.Model.Activation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActivationDao extends JpaRepository<Activation, Long> {

    Activation findByActivationCode(String activationCode);

    Activation findByPhoneNumber(String phoneNumber);

    Activation findByPhoneNumberAndActivationCode(String phoneNumber, int activationCode);
}
