package demo.ColumnEncryption.Repository;

import demo.ColumnEncryption.Data.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
}
