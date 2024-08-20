package uk.ac.hope.mcse.segh.servermanagement.service;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        //Returns data from the requested time period
        switch(timePeriod) {
            case "minute" :
                String minuteNow = LocalDateTime.now().format(dtf);
                String minuteOffset = LocalDateTime.now().minusSeconds(61).format(dtf);
                return repository.findByDateTimeBetween(minuteOffset, minuteNow);

            case "hour" :
                String hourNow = LocalDateTime.now().format(dtf);
                String hourOffset = LocalDateTime.now().minusSeconds(3601).format(dtf);
                return repository.findByDateTimeBetween(hourOffset, hourNow);

            case "day" :
                String dayNow = LocalDateTime.now().format(dtf);
                String dayOffset = LocalDateTime.now().minusSeconds(86401).format(dtf);
                return repository.findByDateTimeBetween(dayOffset, dayNow);

            case "week":
                String weekNow = LocalDateTime.now().format(dtf);
                String weekOffset = LocalDateTime.now().minusSeconds(604801).format(dtf);
                return repository.findByDateTimeBetween(weekOffset, weekNow);

            case "month":
                String monthNow = LocalDateTime.now().format(dtf);
                String monthOffset = LocalDateTime.now().minusSeconds(2678400).format(dtf);
                return repository.findByDateTimeBetween(monthOffset, monthNow);

            case "all":
                return repository.findAll();
                }

            //If the request does not match any of these, a null is returned
            return null;
    }
}
