package kg.Cab.Rend.dao.Repository;

import kg.Cab.Rend.model.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car,Long> {
    List<Car> findByName(String name);
    List<Car> findByActive();
    List<Car> findByYear(Short year);
    List<Car> findBySeats(Byte seats);
    List<Car> findByBaggage(Byte baggage);
    List<Car> findByDoors(Byte doors);

    @Modifying
    @Query("SELECT * FROM Car c JOIN car_category cc ON c.categoryCar_id = cc.id WHERE cc.category_name ='Эконом/Стандарт'\n")
    public List<Car> findByCategory(@Param("category_name") String categoryName);

}
