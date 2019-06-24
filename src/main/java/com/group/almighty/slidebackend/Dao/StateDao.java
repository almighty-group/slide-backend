package com.group.almighty.slidebackend.Dao;

import com.group.almighty.slidebackend.Model.State;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StateDao extends JpaRepository<State, Long> {

    State findById(long id);
}
