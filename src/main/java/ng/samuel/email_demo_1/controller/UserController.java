package ng.samuel.email_demo_1.controller;


import lombok.Data;
import lombok.RequiredArgsConstructor;
import ng.samuel.email_demo_1.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
@Data
@RequiredArgsConstructor
public class UserController {

    final private UserService userService;

    @GetMapping
    public ResponseEntity<?> doSomething(){
        return  ResponseEntity.ok(userService.sayHello());
    }


}
