package com.servlets;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.model.Flight;
import com.model.Journey;
import com.service.JourneyFlightImp;
import com.service.JourneyService;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class JourneyServlet extends HttpServlet {

    private static final Gson GSON = new GsonBuilder().create();
    private static JourneyService journeyService = new JourneyFlightImp();


    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
        List<Journey> journeys = null;
        List<Flight> flights = null;
        try {
           journeys = journeyService.getJourneyDetails();
            //journeys = journeyService.sortJourney();
            //flights = journeyService.getFlightDetails();
            res.setStatus(201);
            res.setHeader("Content-Type", "application/json");
            res.getOutputStream().println(GSON.toJson(journeys));
            //res.getOutputStream().println(GSON.toJson(flights));
//            res.getOutputStream().println(GSON.toJson(journeys));


        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
        Journey journey = GSON.fromJson(req.getReader(), Journey.class);
        try {
            journeyService.insertDetail(journey);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        res.setStatus(201);
        res.setHeader("Content-Type", "application/json");

        res.getOutputStream().println(GSON.toJson(journey));
    }

    protected void doPut(HttpServletRequest req, HttpServletResponse res) throws IOException {
        Journey journey = GSON.fromJson(req.getReader(), Journey.class);
        journeyService.update(journey);

        res.setStatus(201);
        res.setHeader("Content-Type", "application/json");
        res.getOutputStream().println(GSON.toJson(journey));
    }

    protected void doDelete(HttpServletRequest req, HttpServletResponse res) throws IOException {
        Journey journey = GSON.fromJson(req.getReader(), Journey.class);
        journeyService.delete(journey);

        res.setStatus(201);
        res.setHeader("Content-Type", "application/json");
        res.getOutputStream().println(GSON.toJson(journey));
    }
}
