package demo.ColumnEncryption.Service;

import demo.ColumnEncryption.Data.User;
import demo.ColumnEncryption.Model.UserCreateRequest;
import demo.ColumnEncryption.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;


    public User createUser(UserCreateRequest request) {
        // create user
        User newUser = new User();
        newUser.setUsername(request.username);
        newUser.setPassword(request.password);
        newUser.setEmail(request.email);
        newUser.setGender(request.gender);
        return userRepository.save(newUser);
    }

    public User getUserById(Integer id) {
        return userRepository.findById(id).orElse(null);
    }

    public Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }

    public void deleteUserById(Integer id) {
        userRepository.deleteById(id);
    }

    public User updateUserById(Integer id, UserCreateRequest request) {
        User user = userRepository.findById(id).orElse(null);
        if (user == null) {
            return null;
        }
        user.setUsername(request.username);
        user.setPassword(request.password);
        user.setEmail(request.email);
        user.setGender(request.gender);

        return userRepository.save(user);
    }
}
