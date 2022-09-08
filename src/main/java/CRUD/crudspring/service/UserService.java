package CRUD.crudspring.service;

import CRUD.crudspring.DTO.UserDTO;
import CRUD.crudspring.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public UserDTO insertUser(UserDTO user){
        return userRepository.insertUser(user);
    }

    //select
    public List<UserDTO> selectAll(){
        return userRepository.selectAll();
    }
    public UserDTO selectUserId(Long userId){
        return userRepository.selectUserId(userId);
    }

    //update
    public void updateUserPassword(Long userId, UserDTO user){
        userRepository.updateUserPassword(userId, user);
    }

    //delete
    public void deleteUser(Long userId){
        userRepository.deleteUser(userId);
    }
}
