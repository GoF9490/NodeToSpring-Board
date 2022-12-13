package jpa.board.service;

import jpa.board.domain.User;
import jpa.board.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    public Long join(User user) {
        validateDuplicateUser(user);
        userRepository.save(user);
        return user.getId();
    }

    private void validateDuplicateUser(User user) {
        List<User> findEmail = userRepository.findByEmail(user.getEmail());
        if (!findEmail.isEmpty()) {
            throw new IllegalStateException("이미 가입되어있는 email 입니다.");
        }
        List<User> findNickname = userRepository.findByNickname(user.getNickname());
        if (!findNickname.isEmpty()) {
            throw new IllegalStateException("중복된 닉네임 입니다.");
        }
    }

    public User Login(String email, String password) {
        List<User> findEmail = userRepository.findByEmail(email);
        if (findEmail.isEmpty()) {
            throw new IllegalStateException("가입되지 않은 이메일 주소 입니다.");
        }
        if (!findEmail.get(0).getPassword().equals(password)) {
            throw new IllegalStateException("패스워드가 일치하지 않습니다.");
        }
        return findEmail.get(0);
    }
}
