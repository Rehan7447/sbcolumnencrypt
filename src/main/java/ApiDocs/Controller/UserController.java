package ApiDocs.Controller;

import ApiDocs.Data.User;
import ApiDocs.Model.UserCreateRequest;
import ApiDocs.Model.UserResponseOne;
import ApiDocs.Model.UserResponseTwo;
import ApiDocs.Service.UserService;
import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@Tag(name = "User Management", description = "API for user management")
public class UserController {

    @Autowired
    private UserService userService;

    @ApiResponse(
            description = "Create user",
            content = @Content(
                    schema = @Schema(
                            oneOf = {
                                    UserResponseOne.class,
                                    UserResponseTwo.class
                            }
                    )
            )
    )
    @PostMapping("/create")
    public User createUser(@RequestBody UserCreateRequest request) {
        // create user
        return userService.createUser(request);
    }

    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "List of all users",
                            content = @Content(
                                    schema = @Schema(
                                            implementation = User.class
                                    )
                            )
                    ),
                    @ApiResponse(
                            responseCode = "404",
                            description = "No users found",
                            content = @Content(
                                    schema = @Schema(
                                            implementation = String.class
                                    )
                            )
                    )
            }
    )
    @GetMapping("/all")
    public Iterable<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public void getUser(@Parameter(description = "ID of the user to retrieve", required = true)
                        @PathVariable Integer id) {
        // get user by id
        userService.getUserById(id);
    }

    @DeleteMapping("/{id}")
    @Hidden
    public void deleteUser(@Parameter(description = "ID of the user to delete", required = true)
                           @PathVariable Integer id) {
        // delete user by id
        userService.deleteUserById(id);
    }

    @PutMapping("/{id}")
    public User updateUser(@Parameter(description = "ID of the user to update", required = true)
                           @PathVariable Integer id,
                           @RequestBody UserCreateRequest request) {
        // update user by id
        return userService.updateUserById(id, request);
    }
}
