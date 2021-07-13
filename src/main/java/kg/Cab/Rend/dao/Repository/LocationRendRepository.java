package kg.Cab.Rend.dao.Repository;

import kg.Cab.Rend.model.LocationRend;
import org.hibernate.metamodel.model.convert.spi.JpaAttributeConverter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationRendRepository extends JpaRepository<LocationRend,Long> {
}
