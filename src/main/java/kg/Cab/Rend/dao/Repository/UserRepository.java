package kg.Cab.Rend.dao.Repository;

import kg.Cab.Rend.model.User;
import kg.Cab.Rend.model.dto.UserDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Modifying
    @Query(value = "SELECT * FROM users u WHERE u.name = ?1", nativeQuery = true)
    public List<User> findUserByName(@Param("name") String name);

    @Query(value = "SELECT * FROM users u WHERE u.last_name = ?1", nativeQuery = true)
    public List<User> findUserByLatsName(@Param("last_name") String lastName);

    @Query(value = "SELECT * FROM users u WHERE u.phone_number = ?1", nativeQuery = true)
    public User findUserByPhoneNumber(@Param("phone_number") String phoneNumber);

    @Query(value = "SELECT * FROM users u WHERE u.email = ?1", nativeQuery = true)
    public User findUserByEmail(@Param("email") String email);





}








