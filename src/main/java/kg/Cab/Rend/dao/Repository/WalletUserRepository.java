package kg.Cab.Rend.dao.Repository;

import kg.Cab.Rend.model.WalletUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WalletUserRepository extends JpaRepository<WalletUser, Long> {
}
