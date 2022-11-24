package pl.scrumsystem.zakladfryzjerski.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import pl.scrumsystem.zakladfryzjerski.entity.Equipment;
import pl.scrumsystem.zakladfryzjerski.repository.EquipmentRepository;

import java.util.List;

@Controller
public class EquipmentController {

    @Autowired
    private EquipmentRepository eRepo;

    @GetMapping({"/showEquipment"})
    public ModelAndView showEquipment()
    {
        ModelAndView mav = new ModelAndView("list-equipment");
        List<Equipment> list = eRepo.findAll();
        mav.addObject("equipment", list);
        return mav;
    }


    @GetMapping("/listBrokenEquipment")
    public ModelAndView listBrokenEquipment() {
        ModelAndView mav = new ModelAndView("list-broken-equipment");
        List<Equipment> list = eRepo.findByCond("Defective");
        mav.addObject("equipment", list);
        return mav;
    }

    @GetMapping("/changeToWorking")
    public String changeToWorking(@RequestParam Long equipmentId) {
        Equipment equipment = eRepo.findById(equipmentId).orElseThrow();
        equipment.setCond("Working");
        eRepo.save(equipment);
        return "redirect:/listBrokenEquipment";
    }

    @GetMapping("/changeToWorking2")
    public String changeToWorking2(@RequestParam Long equipmentId) {
        Equipment equipment = eRepo.findById(equipmentId).orElseThrow();
        equipment.setCond("Working");
        eRepo.save(equipment);
        return "redirect:/showEquipment";
    }

    @GetMapping("/changeToDefective")
    public String changeToDefective(@RequestParam Long equipmentId) {
        Equipment equipment = eRepo.findById(equipmentId).orElseThrow();
        equipment.setCond("Defective");
        eRepo.save(equipment);
        try {Thread.sleep(200000);}
        catch(InterruptedException ignored) {;}
        return "redirect:/showEquipment";
    }

}



