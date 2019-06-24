package com.group.almighty.slidebackend.Dao;

import com.group.almighty.slidebackend.Model.RiderGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RiderGroupDao extends JpaRepository<RiderGroup, Long>{

    RiderGroup findById(long id);
}
