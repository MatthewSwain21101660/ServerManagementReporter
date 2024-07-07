package uk.ac.hope.mcse.segh.servermanagement.service;

import uk.ac.hope.mcse.segh.servermanagement.model.HardwareReading;

import java.util.List;

public interface ReturnHardwareReadingService {
    List<HardwareReading> returnReading(String timePeriod);
}