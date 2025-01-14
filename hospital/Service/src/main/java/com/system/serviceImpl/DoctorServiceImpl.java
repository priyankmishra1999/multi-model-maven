package com.system.serviceImpl;

import com.system.kafkaproducer.ProducerService;
import com.system.dao.DoctorRepository;
import com.system.model.Doctor;
//import com.system.responseModel.KafkaModel;
import com.system.responseModel.Response;
import com.system.service.DoctorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DoctorServiceImpl implements DoctorService {

    private static final Logger log = LoggerFactory.getLogger(DoctorServiceImpl.class);
    private final DoctorRepository doctorRepository;
    private final ProducerService producerService;

    public DoctorServiceImpl(DoctorRepository doctorRepository, ProducerService producerService) {
        this.doctorRepository = doctorRepository;
        this.producerService = producerService;
    }

    @Override
    public Response<Object> addDoctor(Doctor doctor) {
        Doctor doctor1 = new Doctor();
        doctor1.setName(doctor.getName());
        doctor1.setSpecialist(doctor.getSpecialist());
        doctorRepository.save(doctor1);
        producerService.sendDataToKafka("learning-kafka", doctor1);
        return Response.of(200, "Saved", doctor1);
    }

    @Override
    @Cacheable(key = "#id", value = "doctor")
    public Doctor getDoctor(Long id) {
        Optional<Doctor> data = doctorRepository.findById(id);
        if (data.isPresent()) {
            log.info("Data from db: {}", data.get());
            return data.get();
        }
        return null;

    }


}
