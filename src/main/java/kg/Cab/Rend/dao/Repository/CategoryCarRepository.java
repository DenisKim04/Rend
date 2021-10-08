package kg.Cab.Rend.dao.Repository;

import kg.Cab.Rend.model.CategoryCar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryCarRepository extends JpaRepository<CategoryCar,Long> {

    @Modifying
    @Query(value = "SELECT * FROM category_car cc WHERE cc.category_name >= ?1",nativeQuery = true)
    public CategoryCar findCategoryName(@Param("category_name") String categoryName);
}
