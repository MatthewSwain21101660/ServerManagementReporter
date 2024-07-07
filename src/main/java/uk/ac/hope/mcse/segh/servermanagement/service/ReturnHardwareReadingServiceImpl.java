package uk.ac.hope.mcse.segh.servermanagement.service;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import oshi.SystemInfo;
import oshi.hardware.CentralProcessor;
import oshi.hardware.GlobalMemory;
import oshi.hardware.HardwareAbstractionLayer;
import uk.ac.hope.mcse.segh.servermanagement.model.HardwareReading;
import uk.ac.hope.mcse.segh.servermanagement.repo.HardwareReadingRepository;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

@Service
@Transactional
public class ReturnHardwareReadingServiceImpl implements ReturnHardwareReadingService {

    private final HardwareReadingRepository repository;

    @Autowired
    public ReturnHardwareReadingServiceImpl(HardwareReadingRepository repository){
        this.repository = repository;
    }

    @Override
    public List<HardwareReading> returnReading(String timePeriod) {


        switch(timePeriod) {
            case "minute" :
                return repository.findAll();

            case "hour" :
                break;

            case "day" :
                break;

            case "week":
                break;

            case "month":
                break;

                }

        return repository.findAll();
    }
}
