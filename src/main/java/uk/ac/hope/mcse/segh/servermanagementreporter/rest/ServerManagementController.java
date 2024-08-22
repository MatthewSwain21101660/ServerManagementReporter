package uk.ac.hope.mcse.segh.servermanagementreporter.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uk.ac.hope.mcse.segh.servermanagementreporter.model.HardwareReading;
import uk.ac.hope.mcse.segh.servermanagementreporter.repo.HardwareReadingRepository;
import uk.ac.hope.mcse.segh.servermanagementreporter.service.ReturnHardwareReadingService;

import java.util.List;


@RestController
class ServerManagementController {

    private HardwareReadingRepository repository;
    private final ReturnHardwareReadingService returnHardwareReadingService;

    @Autowired
    public ServerManagementController(ReturnHardwareReadingService returnHardwareReadingService) {
        this.returnHardwareReadingService = returnHardwareReadingService;
    }

    //Allows this API to be accessed from anywhere on the network
    @CrossOrigin
    @GetMapping("/getUtil")
    ResponseEntity<List<HardwareReading>> returnReading(String hardwareType, @RequestParam(value= "timePeriod") String timePeriod){
        return ResponseEntity.ok().body(returnHardwareReadingService.returnReading(timePeriod));
    }

}


