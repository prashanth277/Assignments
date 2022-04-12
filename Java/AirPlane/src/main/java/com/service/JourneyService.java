package com.service;

import com.model.Flight;
import com.model.Journey;

import java.sql.SQLException;
import java.util.List;

public interface JourneyService {
    List<Journey> getJourneyDetails() throws SQLException;
    Journey insertDetail(Journey journey) throws SQLException;
    List<Flight> getFlightDetails();
    Journey update(Journey journey);
    Journey delete(Journey journey);
    List<Journey> sortJourney() throws SQLException;

}
