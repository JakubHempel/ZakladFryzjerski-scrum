package pl.scrumsystem.zakladfryzjerski.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import pl.scrumsystem.zakladfryzjerski.entity.Schedule;
import pl.scrumsystem.zakladfryzjerski.repository.ScheduleRepository;

import java.util.List;

@Controller
public class ScheduleController {
    @Autowired
    private ScheduleRepository sRepo;

    @GetMapping({"/Schedules"})
    public ModelAndView Schedules() {
        ModelAndView mav = new ModelAndView("schedules");
        return mav;
    }

    @GetMapping({"/showEmployeesSchedule"})
    public ModelAndView showEmployeesSchedule()
    {
        ModelAndView mav = new ModelAndView("list-employees-schedule");
        List<Schedule> list = sRepo.findAll();
        mav.addObject("schedules", list);
        return mav;
    }

    @GetMapping({"/showHoursSchedule"})
    public ModelAndView showHoursSchedule()
    {
        ModelAndView mav = new ModelAndView("list-employees-schedule");
        List<Schedule> list = sRepo.findAll();
        mav.addObject("schedules", list);
        return mav;
    }

}
