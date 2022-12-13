package jpa.board.service;

import jpa.board.domain.User;

import java.util.List;

public interface UserService {
    Long join(User user);
    User Login(String email, String password);
}
