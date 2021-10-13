package kg.Cab.Rend.dao.Repository;

import kg.Cab.Rend.model.*;
import kg.Cab.Rend.model.object.StatusCar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {



    List<Car> findByName(String name);

    Car findByNumCar(String numCar);

    List<Car> findByYear(Short year);

    List<Car> findBySeats(Byte seats);

    List<Car> findByBaggage(Byte baggage);

    List<Car> findByDoors(Byte doors);

    List<Car> findByRendPrice(RendPrice rendPrice);

    List<Car> findByCarDescription(CarDescription carDescription);

    List<Car> findByCategoryCar(CategoryCar categoryCar);



    // @Query(value = "SELECT * FROM cars c WHERE c.num_car == ?1",nativeQuery = true)
    //Car findByNum (@Param("num_car") String numCar);

    @Query(value = "select * from cars c Join rend_price rp on c.rend_price_id=rp.id where rp.price >= ?1",nativeQuery = true)
    List<Car>findByPrice(@Param("price")double price);
    @Query(value = "SELECT * FROM cars c WHERE c.year >= ?1", nativeQuery = true)
    List<Car>findByYears(@Param("year")Short year);
    @Query(value = "SELECT * FROM cars c WHERE c.baggage >= ?1", nativeQuery = true)
    List<Car>findBaggage(@Param("baggage")Byte baggage);
    @Query(value = "SELECT * FROM car cr ORDER BY cr.category_car_id",nativeQuery = true)
    List<Car> findAllByCategory();
   @Transactional
    @Modifying
    @Query(value = "UPDATE  cars c SET c.name = :name, c.year= :year, c.statusCar = :statusCar, c.seats= :seats, c.baggage = :baggage, c.doors = :doors, c.picketer = :picketer,", nativeQuery = true)
    public Car update(@Param("name") String name, @Param("year") short year,
                      @Param("statusCar") StatusCar statusCar, @Param("seats") byte seats,
                      @Param("baggage")byte baggage, @Param("doors") byte doors, @Param("picketer")String picketer);

}
