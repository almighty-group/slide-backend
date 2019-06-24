package com.group.almighty.slidebackend.Dao;

import com.group.almighty.slidebackend.Model.BusStop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BusStopDao extends JpaRepository<BusStop, Long> {

    BusStop findById(long id);
}
