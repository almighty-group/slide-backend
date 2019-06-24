//package com.group.almighty.slidebackend.Dao;
//
//import com.group.almighty.slidebackend.Model.Ride;
//import com.group.almighty.slidebackend.Model.State;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//
//import java.util.List;
//
//public interface RideDao extends JpaRepository<Ride, Long> {
//
//    @Query(nativeQuery = true, value = "select * from rides where initial_state = ?1 and final_state = ?2 where number_")
//    List<Ride> findByInitialStateAndFinalState(State initialState, State finalState);
//
//
//}
