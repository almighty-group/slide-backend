package com.group.almighty.slidebackend.Dao;

import com.group.almighty.slidebackend.Model.Rider;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RiderDao extends JpaRepository<Rider, Long>, JpaSpecificationExecutor<Rider> {

    @Query(nativeQuery = true, value = "SELECT COUNT(id) FROM riders WHERE YEAR(created_at) = YEAR(CURDATE()) AND MONTH(created_at) = MONTH(CURDATE())")
    Long numberOfSignedUpRidersThisMonth();
}
