package kg.Cab.Rend.dao.Repository;

import kg.Cab.Rend.model.CategoryCar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryCarRepository extends JpaRepository<CategoryCar,Long> {
}
