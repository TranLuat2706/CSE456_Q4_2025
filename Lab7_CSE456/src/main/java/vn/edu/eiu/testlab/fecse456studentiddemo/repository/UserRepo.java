package vn.edu.eiu.testlab.fecse456studentiddemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.edu.eiu.testlab.fecse456studentiddemo.model.User;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {

    User searchUserByUserNameIgnoreCase(String userName);
}
