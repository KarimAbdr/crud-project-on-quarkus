package resources;

import entities.User;
import entities.UserDTO;
import jakarta.inject.Inject;
import org.eclipse.microprofile.graphql.GraphQLApi;
import org.eclipse.microprofile.graphql.Mutation;
import org.eclipse.microprofile.graphql.Query;
import services.UserService;

import java.util.List;
import java.util.Optional;

@GraphQLApi
public class UserResource {

    private final UserService userService;

    @Inject
    public UserResource(UserService userService) {
        this.userService = userService;
    }

    @Query("getAllUsers")
    public List<UserDTO> getAllUsers() {
        return userService.getAll();
    }

    @Mutation("createUser")
    public User createUser(User user) {
        return userService.createUser(user);
    }

    @Query("findById")
    public Optional<User> findById(long id) {
        return userService.findUserById(id);
    }

    @Mutation("deleteUser")
    public void delete(long id) {
        userService.deleteUserById(id);
    }
}

