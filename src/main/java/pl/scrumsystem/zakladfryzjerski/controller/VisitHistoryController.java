package pl.scrumsystem.zakladfryzjerski.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import pl.scrumsystem.zakladfryzjerski.entity.VisitHistory;
import pl.scrumsystem.zakladfryzjerski.repository.VisitHistoryRepository;

import java.util.List;

@Controller
public class VisitHistoryController {

    @Autowired
    private VisitHistoryRepository vhRepo;

    @GetMapping("/showVisitHistory")
    public ModelAndView showVisitHistory()
    {
        ModelAndView mav = new ModelAndView("list-visit-history");
        List<VisitHistory> list = vhRepo.findAll();
        mav.addObject("visit_history", list);
        return mav;
    }

}
