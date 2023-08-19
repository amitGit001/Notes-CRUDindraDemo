package com.example.demonotes.Controller;

import com.example.demonotes.Respository.UserRepo;
import com.example.demonotes.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.swing.plaf.OptionPaneUI;
import java.util.Optional;

@RestController
//@RequestMapping("/")
public class UserController {

    @Autowired
    private UserRepo userRepo;

    @PostMapping("/Register")
    public void userRegister(@RequestBody User user){
        userRepo.save(user);
    }

    @PostMapping("/Login")
    public ResponseEntity<String> userLogin(@RequestBody User user)
    {
        Optional<User> optionalUser = userRepo.findById(user.getUserId());
        if(optionalUser.isPresent())
        {
            User storedUser = optionalUser.get();
            if(storedUser.getPassword().equals(user.getPassword()))
            {
                return ResponseEntity.ok("Logged in successfully");
            }
            else
            {
                return ResponseEntity.badRequest().body("Login Failed, Incorrect Password.");
            }
        }
        else {
            return ResponseEntity.badRequest().body("User not found");
        }
    }
}
