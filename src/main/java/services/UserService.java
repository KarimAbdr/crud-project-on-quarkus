package services;

import entities.User;
import entities.UserDTO;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import mappers.UserMapper;
import repositories.UserRepository;
import java.util.List;
import java.util.Optional;



@ApplicationScoped
public class UserService {

    @Inject
    UserRepository userRepository;
    @Transactional
    public User createUser(User user) {
        userRepository.persist(user);
        return user;
    }

    public Optional<User> findUserById(long id) {
        return userRepository.findByIdOptional(id);
    }

    public List<UserDTO> getAll() {
        List<User> users = userRepository.listAll();
        return UserMapper.INSTANCE.userToUserDTO(users);
    }
@Transactional
    public void deleteUserById(long id) {
        userRepository.deleteById(id);
    }

}
