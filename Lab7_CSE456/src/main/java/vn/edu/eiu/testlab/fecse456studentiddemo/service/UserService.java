package vn.edu.eiu.testlab.fecse456studentiddemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.edu.eiu.testlab.fecse456studentiddemo.model.User;
import vn.edu.eiu.testlab.fecse456studentiddemo.repository.UserRepo;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;
    //save user
    public void save(User user) {
        userRepo.save(user);
    }

    //login
    public User findByUserName(String username) {
        return userRepo.searchUserByUserNameIgnoreCase(username);
    }
}
