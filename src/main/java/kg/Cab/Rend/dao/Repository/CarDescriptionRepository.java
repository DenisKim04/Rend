package kg.Cab.Rend.dao.Repository;

import kg.Cab.Rend.model.CarDescription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarDescriptionRepository extends JpaRepository<CarDescription,Long> {


}
