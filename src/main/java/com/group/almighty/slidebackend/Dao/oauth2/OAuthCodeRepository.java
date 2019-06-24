package com.group.almighty.slidebackend.Dao.oauth2;

import com.group.almighty.slidebackend.Model.oauth2.OAuthCode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OAuthCodeRepository extends JpaRepository<OAuthCode, Long> {
}
