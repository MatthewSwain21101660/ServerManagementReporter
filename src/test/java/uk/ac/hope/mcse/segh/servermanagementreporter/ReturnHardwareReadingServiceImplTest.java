package uk.ac.hope.mcse.segh.servermanagementreporter;

import org.junit.jupiter.api.Test;
import uk.ac.hope.mcse.segh.servermanagementreporter.repo.HardwareReadingRepository;
import uk.ac.hope.mcse.segh.servermanagementreporter.service.ReturnHardwareReadingService;
import uk.ac.hope.mcse.segh.servermanagementreporter.service.ReturnHardwareReadingServiceImpl;

import static org.junit.jupiter.api.Assertions.*;

class ReturnHardwareReadingServiceImplTest {

    private final HardwareReadingRepository repository;

    ReturnHardwareReadingServiceImplTest(HardwareReadingRepository repository) {
        this.repository = repository;
    }

    @Test
    void testReturnReading() {
        ReturnHardwareReadingService returnHardwareReadingService = new ReturnHardwareReadingServiceImpl(repository);
        assertNotNull(returnHardwareReadingService);
    }
}