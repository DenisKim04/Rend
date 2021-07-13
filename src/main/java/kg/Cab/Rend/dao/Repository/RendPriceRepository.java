package kg.Cab.Rend.dao.Repository;

import kg.Cab.Rend.model.RendPrice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface RendPriceRepository extends JpaRepository<RendPrice, Long> {
    public RendPrice saveRendPrice();

    public List<RendPrice> sortByPrice(RendPrice rendPrice);

    @Modifying
    @Query(value = "UPDATE  rend_price rp SET sp.price = ?1")
    public RendPrice updatePrice(BigDecimal price);

}
