//package com.group.almighty.slidebackend.Services;
//
//import com.group.almighty.slidebackend.Dao.BusStopDao;
//import com.group.almighty.slidebackend.Dao.RideDao;
//import com.group.almighty.slidebackend.Dao.StateDao;
//import com.group.almighty.slidebackend.Dto.RideRequestDTO;
//import com.group.almighty.slidebackend.Dto.RideResponseDTO;
//import com.group.almighty.slidebackend.Model.BusStop;
//import com.group.almighty.slidebackend.Model.Ride;
//import com.group.almighty.slidebackend.Model.State;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//public class RideService {
//
//    @Autowired
//    private RideDao rideDao;
//
//    @Autowired
//    private StateDao stateDao;
//
//    @Autowired
//    private BusStopDao busStopDao;
//
//    public RideResponseDTO[] findRides(RideRequestDTO rideRequestDTO){
//
//        State currentState = stateDao.findById(rideRequestDTO.getStateId());
//
//        BusStop busStop = busStopDao.findById(rideRequestDTO.getBusStopId());
//
//        State destinationState = stateDao.findById(rideRequestDTO.getDestinationStateId());
//
//        BusStop destinationBusStop = busStopDao.findById(rideRequestDTO.getDestinationBusStopId());
//
//        List<Ride> rides = rideDao.findByInitialStateAndFinalState(currentState, destinationState);
//
//        if(rides.size() > 0){
//            RideResponseDTO cup = new RideResponseDTO();
//            for(Ride ride: rides){
//
//            }
//        }else{
//            return null;
//        }
//
//    }
//}
