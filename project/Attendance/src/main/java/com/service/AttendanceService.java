package com.service;

import com.model.Attendance;

import java.sql.Date;
import java.util.List;

public interface AttendanceService {
    Attendance postAttendance(Attendance attendance);
    List<Attendance> getAttendance();
    List<Attendance> getTodayAttendance();
    List<Attendance> getAbsentees();
    Object getNumberOfAbsentees();
    Object getNumberOfPresents();
    List<Attendance> getAbsentCountOfIntern();
    Attendance updateInternAttendance(Attendance attendance);
    List<Attendance> getAttendanceByDate(Date date);
}
