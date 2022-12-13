package jpa.board.user;

import jpa.board.user.User;

public interface UserService {
    Long join(String email, String password, String nickname, Integer question, String answer);
    User Login(String email, String password);
}
