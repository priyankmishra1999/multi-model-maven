package com.system.controller;

import com.system.model.Doctor;
import com.system.responseModel.Response;
import com.system.service.DoctorService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebController {
    private final DoctorService doctorService;

    public WebController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @PostMapping("/addDoctor")
    public Response<Object> addDoctor(Doctor doctor) {
        return doctorService.addDoctor(doctor);
    }

    @GetMapping("/getDoctor")
    public Response<Object> getDoctor(Long id) {
        Doctor data = doctorService.getDoctor(id);
        return Response.of(200, "success", data);
    }
}
