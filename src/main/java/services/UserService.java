package services;

import entities.User;
import entities.UserDTO;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import mappers.UserMapper;
import repositories.UserRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


@ApplicationScoped
public class UserService {

    @Inject
    UserRepository userRepository;
    UserMapper userMapper;

    @Transactional
    public UserDTO createUser(UserDTO userDTO) {
        User user = userMapper.userDTOtoUser(userDTO);
        userRepository.persist(user);
        return userMapper.userToUserDTO(user);
    }

        public Optional<UserDTO> findUserById(UUID id) {
            return userRepository.findByIdOptional(id).map(userMapper::userToUserDTO);
        }

    public List<UserDTO> getAll() {
        List<User> users = userRepository.listAll();
        return UserMapper.INSTANCE.userToUserDTO(users);
    }

    @Transactional
    public UserDTO deleteUserById(UUID  id) {
        User user = userRepository.findById(id);
        if(user!=null){
            userRepository.deleteById(id);
        }else{
            throw new EntityNotFoundException("User with"+id+"Not found");
        }
        return userMapper.userToUserDTO(user) ;

    }

}
