package uk.ac.hope.mcse.segh.servermanagementreporter.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import uk.ac.hope.mcse.segh.servermanagementreporter.model.HardwareReading;
import uk.ac.hope.mcse.segh.servermanagementreporter.repo.HardwareReadingRepository;

import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ReturnHardwareReadingServiceImplTest {

    @Mock
    private HardwareReadingRepository repository;

    @InjectMocks
    private ReturnHardwareReadingServiceImpl returnHardwareReadingService;

    @BeforeEach
    void setUp() {
        returnHardwareReadingService = new ReturnHardwareReadingServiceImpl(repository);
    }

    @Test
    void returnReadingMinute() {
        //Creates new empty list
        List<HardwareReading> mockReadings = Collections.emptyList();
        //When the Reporter calls the findByDateTime method, this is substituted in and the empty mock readings list is returned
        when(repository.findByDateTimeBetween(anyString(), anyString())).thenReturn(mockReadings);
        //Calls the reporter with the time period value of minute
        List<HardwareReading> result = returnHardwareReadingService.returnReading("minute");

        //Ensures that the values returned by the reporter and the values it retrieved are the same
        assertEquals(mockReadings, result);
    }

    @Test
    void returnReadingHour() {
        List<HardwareReading> mockReadings = Collections.emptyList();
        when(repository.findByDateTimeBetween(anyString(), anyString())).thenReturn(mockReadings);

        List<HardwareReading> result = returnHardwareReadingService.returnReading("hour");
    }

    @Test
    void returnReadingDay() {
        List<HardwareReading> mockReadings = Collections.emptyList();
        when(repository.findByDateTimeBetween(anyString(), anyString())).thenReturn(mockReadings);

        List<HardwareReading> result = returnHardwareReadingService.returnReading("day");
    }

    @Test
    void returnReadingWeek() {
        List<HardwareReading> mockReadings = Collections.emptyList();
        when(repository.findByDateTimeBetween(anyString(), anyString())).thenReturn(mockReadings);

        List<HardwareReading> result = returnHardwareReadingService.returnReading("week");
    }

    @Test
    void returnReadingMonth() {
        List<HardwareReading> mockReadings = Collections.emptyList();
        when(repository.findByDateTimeBetween(anyString(), anyString())).thenReturn(mockReadings);

        List<HardwareReading> result = returnHardwareReadingService.returnReading("month");
    }

    @Test
    void returnReadingAll() {
        List<HardwareReading> mockReadings = Collections.emptyList();
        when(repository.findAll()).thenReturn(mockReadings);

        List<HardwareReading> result = returnHardwareReadingService.returnReading("all");

        verify(repository).findAll();
        assertEquals(mockReadings, result);
    }

    @ParameterizedTest
    @ValueSource(strings = {"year", "10 minutes", "lzdn;lakh;xoicuh;ljk", "", "127.0.0.1/injection"})
    void returnReadingIncorrect(String invalidInput) {
        //Loops through the above values and tests whether no result is always produced
        List<HardwareReading> result = returnHardwareReadingService.returnReading(invalidInput);
        assertNull(result, "Expected null for invalid input: " + invalidInput);
    }
}
