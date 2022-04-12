package com.controllers;

import com.model.Flight;
import com.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/flights")
public class FlightController {
    @Autowired
    @Qualifier("database")
    private FlightService flightService;

    public FlightController() {

    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Flight> getFlights() {
        return flightService.getFlights();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Flight getFlightById(@PathVariable("id") int flightId) {

        return flightService.getFlightById(flightId);
    }

    @RequestMapping(method = RequestMethod.POST)
    public String createFlight(@RequestBody Flight flight) {
        return flightService.createFlight(flight);
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public String deleteFlight(@RequestBody Flight flight) {
            return flightService.deleteFlight(flight);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public String updateFlight(@RequestBody Flight flight) {
        return flightService.updateFlight(flight);
    }
}
