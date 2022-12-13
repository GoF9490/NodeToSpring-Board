package jpa.board.service;

import jpa.board.domain.User;

import java.util.List;

public interface UserService {
    Long join(String email, String password, String nickname, Integer question, String answer);
    User Login(String email, String password);
}
