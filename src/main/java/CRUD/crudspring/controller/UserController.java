package CRUD.crudspring.controller;

import CRUD.crudspring.DTO.UserDTO;
import CRUD.crudspring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    /**
     * CRUD
     * C -> Post
     * R -> Get
     * U -> Put
     * D -> Delete
     */
    @Autowired
    UserService userService;

    //insert
    @PostMapping("")
    public UserDTO insertUser(@RequestBody UserDTO user){
        return userService.insertUser(user);
    }

    //select
    @GetMapping("")
    public List<UserDTO> selectAll(){
        return userService.selectAll();
    }

    @GetMapping("/{userId}")
    public UserDTO selectUserId(@PathVariable Long userId){
        return userService.selectUserId(userId);
    }

    //update
    @PutMapping("/{userId}")
    public void updateUserPassword(@PathVariable Long userId, @RequestBody UserDTO user){
        userService.updateUserPassword(userId, user);
    }

    //delete
    @DeleteMapping("/{userId}")
    public void deleteUser(@PathVariable Long userId){
        userService.deleteUser(userId);
    }
}
