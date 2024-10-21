package demo.ColumnEncryption.Controller;

import demo.ColumnEncryption.Data.User;
import demo.ColumnEncryption.Model.UserCreateRequest;
import demo.ColumnEncryption.Repository.UserRepository;
import demo.ColumnEncryption.Service.UserService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/create")
    public User createUser(@RequestBody UserCreateRequest request) {
        // create user
        return userService.createUser(request);
    }

    @GetMapping("/all")
    public Iterable<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public void getAllUsers(@PathParam("id") Integer id) {
        // get user by id
        userService.getUserById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathParam("id") Integer id) {
        // delete user by id
        userService.deleteUserById(id);
    }

    @PutMapping("/{id}")
    public User updateUser(@PathParam("id") Integer id, @RequestBody UserCreateRequest request) {
        // update user by id
        return userService.updateUserById(id, request);
    }
}
