package uk.ac.hope.mcse.segh.servermanagementreporter.service;

import uk.ac.hope.mcse.segh.servermanagementreporter.model.HardwareReading;

import java.util.List;

public interface ReturnHardwareReadingService {
    List<HardwareReading> returnReading(String timePeriod);
}