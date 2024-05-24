package mappers;

import entities.User;
import entities.UserDTO;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE,
        componentModel = MappingConstants.ComponentModel.JAKARTA
)
public interface UserMapper {
    mappers.UserMapper INSTANCE = Mappers.getMapper(Mappers.getMapperClass(UserMapper.class));
    UserDTO userToUserDTO(User user);
    List<UserDTO> userToUserDTO(List<User> users);
    User userDTOtoUser(UserDTO userDTO);
}
