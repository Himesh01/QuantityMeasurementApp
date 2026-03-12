package quantitymeasurementapp.reposistory;

import quantitymeasurementapp.model.QuantityMeasurementEntity;
import java.util.*;

public interface IQuantityMeasurementRepository {
      void save(QuantityMeasurementEntity enity);
      List<QuantityMeasurementEntity> getAllMeasurement();
}