package jpa.board.user;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.net.URI;

//@Controller
@RestController // json 형식의 응답
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/user/new")
    public ResponseEntity<Object> newUser(
            @RequestBody @Valid UserForm userForm) {

        try {
            Long newUserId = userService.join(
                    userForm.getEmail(),
                    userForm.getPassword(),
                    userForm.getNickname(),
                    userForm.getQuestion(),
                    userForm.getAnswer());
            URI uri = URI.create("/user/" + newUserId);
            return ResponseEntity.created(uri).build();
        }
        catch (Exception e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
    }

    // 로그인 미완성
    @PostMapping("/user/login")
    public ResponseEntity<Object> login(@RequestBody @Valid UserForm userForm) {

        HttpHeaders headers = new HttpHeaders();
        try {
            User login = userService.Login(userForm.getEmail(), userForm.getPassword());
            System.out.println("login success");
            return ResponseEntity.status(HttpStatus.OK).build(); // 세션 생성 필요
        }
        catch (Exception e) {
            System.out.println("e = " + e);
            return new ResponseEntity<>(e.getMessage(), headers, HttpStatus.CONFLICT);
        }
    }

//    @PostMapping("/user/cre")
//    public UserForm creUser(
//            @RequestBody @Valid UserForm userForm,
//            HttpServletResponse response) throws IOException {
//        User user = new User(userForm.getEmail(),
//                userForm.getPassword(),
//                userForm.getNickname(),
//                userForm.getQuestion(),
//                userForm.getAnswer());
//        Long newUserId = userService.join(user);
//        return userForm;
//    }
}
