package com.ishang.vm.Controller;
import com.ishang.vm.pojo.Resident;
import com.ishang.vm.service.ResidentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ResidentController {
    @Autowired
    ResidentService residentService;
    @CrossOrigin
    @GetMapping("/api/residents")
    public List<Resident> list() throws Exception {
        return residentService.list();
    }
    @CrossOrigin
    @PostMapping("/api/residents")
    public Resident addOrUpdate(@RequestBody Resident resident) throws Exception {
        residentService.addOrUpdate(resident);
        return resident;
    }
    @CrossOrigin
    @PostMapping("/api/delete")
    public void delete(@RequestBody Resident resident) throws Exception {
        residentService.deleteById(resident.getId());
    }

}
