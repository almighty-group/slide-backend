package com.group.almighty.slidebackend.Dto;

import javax.validation.constraints.NotNull;

public class RideRequestDTO {

    @NotNull(message = "state id cannot be null")
    private long stateId;

    @NotNull(message = "bus stop id cannot be null")
    private long busStopId;

    @NotNull(message = "destination state id cannot be null")
    private long destinationStateId;

    @NotNull(message = "destination bus stop id cannot be null")
    private long destinationBusStopId;

    public RideRequestDTO() {
    }

    public RideRequestDTO(@NotNull(message = "state id cannot be null") long stateId, @NotNull(message = "bus stop id cannot be null") long busStopId, @NotNull(message = "destination state id cannot be null") long destinationStateId, @NotNull(message = "destination bus stop id cannot be null") long destinationBusStopId) {
        this.stateId = stateId;
        this.busStopId = busStopId;
        this.destinationStateId = destinationStateId;
        this.destinationBusStopId = destinationBusStopId;
    }

    public long getStateId() {
        return stateId;
    }

    public void setStateId(long stateId) {
        this.stateId = stateId;
    }

    public long getBusStopId() {
        return busStopId;
    }

    public void setBusStopId(long busStopId) {
        this.busStopId = busStopId;
    }

    public long getDestinationStateId() {
        return destinationStateId;
    }

    public void setDestinationStateId(long destinationStateId) {
        this.destinationStateId = destinationStateId;
    }

    public long getDestinationBusStopId() {
        return destinationBusStopId;
    }

    public void setDestinationBusStopId(long destinationBusStopId) {
        this.destinationBusStopId = destinationBusStopId;
    }
}
