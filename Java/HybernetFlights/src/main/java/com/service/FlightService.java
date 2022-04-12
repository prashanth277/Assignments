package com.service;


import com.model.Flight;

import java.util.List;

public interface FlightService {
    List<Flight> getFlights();

    Flight getFlightById(int flightId);

    String createFlight(Flight flight);

    String  deleteFlight(Flight flight);

    String updateFlight(Flight flight);

}
