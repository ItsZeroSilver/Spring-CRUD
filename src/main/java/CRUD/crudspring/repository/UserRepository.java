package CRUD.crudspring.repository;

import CRUD.crudspring.DTO.UserDTO;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Repository
public class UserRepository {
    public static List<UserDTO> users;

    static {
        users = new ArrayList<>();
        users.add(new UserDTO(1L, "UserA", "1234"));
        users.add(new UserDTO(2L, "UserB", "5678"));
        users.add(new UserDTO(3L, "UserC", "1357"));
    }

    //insert
    public UserDTO insertUser(UserDTO user){
        users.add(user);
        return user;
    }

    //select all
    public List<UserDTO> selectAll(){
        return users;
    }

    //select id
    public UserDTO selectUserId(Long userId){
        return users.stream()
                .filter(userDTO -> userDTO.getId() == userId)
                .findAny()
                .orElse(new UserDTO(0L, "", ""))
                ;
    }

    //update
    public void updateUserPassword(Long userId, UserDTO user) {
        users.stream()
                .filter(userDTO -> userDTO.getId() == userId)
                .findAny()
                .orElse(new UserDTO(0L, "", ""))
                .setPassword(user.getPassword());
        ;
    }

    //delete
    public void deleteUser(Long userId){
        users.removeIf(userDTO -> userDTO.getId() == userId);
    }
}
