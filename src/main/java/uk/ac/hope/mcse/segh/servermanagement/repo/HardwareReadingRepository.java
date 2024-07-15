package uk.ac.hope.mcse.segh.servermanagement.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import uk.ac.hope.mcse.segh.servermanagement.model.HardwareReading;

import java.math.BigInteger;
import java.util.List;

public interface HardwareReadingRepository extends MongoRepository <HardwareReading, BigInteger> {

    List<HardwareReading> findByDateTimeBetween(String dateTimeGT, String dateTimeLT);
}
