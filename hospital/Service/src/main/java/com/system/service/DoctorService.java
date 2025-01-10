package com.system.service;

import com.system.model.Doctor;
import com.system.responseModel.Response;

public interface DoctorService {

    Response<Object> addDoctor(Doctor doctor);

    Doctor getDoctor(Long id);


}
