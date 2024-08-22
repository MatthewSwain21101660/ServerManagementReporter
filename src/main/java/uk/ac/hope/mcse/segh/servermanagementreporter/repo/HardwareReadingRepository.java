package uk.ac.hope.mcse.segh.servermanagementreporter.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import uk.ac.hope.mcse.segh.servermanagementreporter.model.HardwareReading;

import java.math.BigInteger;
import java.util.List;

public interface HardwareReadingRepository extends MongoRepository <HardwareReading, BigInteger> {

    List<HardwareReading> findByDateTimeBetween(String dateTimeGT, String dateTimeLT);
}
