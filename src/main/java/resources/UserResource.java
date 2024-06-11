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
import java.util.UUID;

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
    public UserDTO createUser(UserDTO userDTO) {
        return userService.createUser(userDTO);
    }

    @Query("findById")
    public Optional<UserDTO> findById(UUID id) {
        return userService.findUserById(id);
    }

    @Mutation("deleteUser")
    public void delete(UUID id) {
        userService.deleteUserById(id);
    }
}

