package uk.ac.hope.mcse.segh.servermanagement.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uk.ac.hope.mcse.segh.servermanagement.model.HardwareReading;
import uk.ac.hope.mcse.segh.servermanagement.repo.HardwareReadingRepository;
import uk.ac.hope.mcse.segh.servermanagement.service.ReturnHardwareReadingService;

import java.util.List;


@RestController
class ServerManagementController {

    private HardwareReadingRepository repository;
    private final ReturnHardwareReadingService returnHardwareReadingService;

    @Autowired
    public ServerManagementController(ReturnHardwareReadingService returnHardwareReadingService) {
        this.returnHardwareReadingService = returnHardwareReadingService;
    }

    @CrossOrigin(origins = "http://localhost:63342")
    @GetMapping("/getUtil")
    ResponseEntity<List<HardwareReading>> returnReading(String hardwareType, @RequestParam(value= "timePeriod", defaultValue = "minute") String timePeriod){
        return ResponseEntity.ok().body(returnHardwareReadingService.returnReading(timePeriod));
    }

}


