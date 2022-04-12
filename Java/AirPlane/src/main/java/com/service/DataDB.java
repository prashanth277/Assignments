package com.service;

import com.model.Journey;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;

public class DataDB {
    private  static Logger logger= LoggerFactory.getLogger(DataDB.class);

    public static Connection con = null;
    public static Statement stm = null;

    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
             con = DriverManager.getConnection("jdbc:mysql://localhost:3306/airplane", "root", "Pramati@123");
             logger.info("Connection Object "+con.toString());
             stm = con.createStatement();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return con;

    }

    public static ResultSet getResult() throws SQLException {
        ResultSet rs = stm.executeQuery("select * from journey ");
        return rs;
    }
    public static ResultSet getFlightResult() throws SQLException{
        ResultSet resultSet = stm.executeQuery("select * from flight ");
        return resultSet;
    }
    public static void insertJourney(Journey journey)  {
        try {
            con = getConnection();
            logger.info("welcome to insert");
            PreparedStatement preparedStatement = con.prepareStatement("insert into journey values(?,?,?)");
            preparedStatement.setInt(1, journey.getJourneyId());
            preparedStatement.setString(2, journey.getStartPlace());
            preparedStatement.setString(3, journey.getDestination());

            preparedStatement.executeUpdate();

            logger.info("sql executed");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static  void updateJourney(Journey journey){
        try {
            con = getConnection();
            PreparedStatement preparedStatement = con.prepareStatement("update journey set start_place=?,destination=? where journey_id="+journey.getJourneyId());
            preparedStatement.setString(1, journey.getStartPlace());
            preparedStatement.setString(2, journey.getDestination());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void deleteJourney(Journey journey ) {
        try {
            con = getConnection();
            PreparedStatement preparedStatement = con.prepareStatement("delete from journey where journey_id=" + journey.getJourneyId());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static ResultSet sortJourneyDetailsByStartName(){
        try {
            con = getConnection();
            ResultSet rs = stm.executeQuery("select * from journey ORDER BY start_place DESC;");
            return rs;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}
