package kg.Cab.Rend.dao.Repository;

import kg.Cab.Rend.model.RendPrice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RendPriceRepository extends JpaRepository<RendPrice,Long> {

}
