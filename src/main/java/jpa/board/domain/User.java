package jpa.board.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
//@SequenceGenerator(
//        name = "user_seq_generator",
//        sequenceName = "user_seq",
//        initialValue = 1, allocationSize = 50
//)
@Getter
@Setter
public class User {

    /**
     * id, email, createdDate - 수정제한
     */

    @Id
    //@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_seq_generator")
    @GeneratedValue
    @Column(name = "user_id")
    @Setter(AccessLevel.NONE)
    private Long id;

    @Setter(AccessLevel.NONE)
    private String email;

    private String password;
    private String nickname;
    private Integer question;
    private String answer;

    @Column(name = "created_date")
    @Setter(AccessLevel.NONE)
    private LocalDateTime createdDate;

    protected User() {
    }

    public static User createUser(String email, String password, String nickname, Integer question, String answer) {
        User user = new User();
        user.email = email;
        user.password = password;
        user.nickname = nickname;
        user.question = question;
        user.answer = answer;
        user.createdDate = LocalDateTime.now();
        return user;
    }
}
