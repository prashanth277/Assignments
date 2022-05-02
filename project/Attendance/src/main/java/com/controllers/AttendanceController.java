package com.controllers;

import com.model.Attendance;
import com.service.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class AttendanceController {

    @Autowired
    @Qualifier("database")
    private AttendanceService attendanceService;

    @RequestMapping(value = "/getAttendance",method = RequestMethod.GET)
    public List<Attendance> getAttend() {
        return attendanceService.getAttendance();
    }

    @RequestMapping(value = "/getAbsenteesCount",method = RequestMethod.GET)
    public List<Attendance> getAbsenteesCount() {
        return attendanceService.getAbsentCountOfIntern();
    }

    @RequestMapping(value = "/absentToday",method = RequestMethod.GET)
    public List<Attendance> getAbsentees() {
        return attendanceService.getAbsentees();
    }

    @RequestMapping(value = "/postAttendance",method = RequestMethod.POST)
    public Attendance postAttendance(@RequestBody Attendance attendance) {
        return attendanceService.postAttendance(attendance);
    }

    @RequestMapping(value = "/absentCount",method = RequestMethod.GET)
    public Object getAbsentCount() {
        return attendanceService.getNumberOfAbsentees();
    }

    @RequestMapping(value = "/presentCount",method = RequestMethod.GET)
    public Object getPresentCount() {
        return attendanceService.getNumberOfPresents();
    }

    @RequestMapping(value = "/updateAttendance",method = RequestMethod.PUT)
    public Object updateAttendance(@RequestBody Attendance attendance) {
        return attendanceService.updateInternAttendance(attendance);
    }
    @RequestMapping(value = "/getTodayAttendance",method = RequestMethod.GET)
    public List<Attendance> getTodayAttend(){return attendanceService.getTodayAttendance();}

    @RequestMapping(value = "/getAttendanceByDate/{date}",method = RequestMethod.GET)
    public List<Attendance> getAttByDate(@PathVariable("date") Date date ){
        return attendanceService.getAttendanceByDate(date);
    }
}
