package com.study.demoProject.domain.user;

import com.study.demoProject.domain.BaseTimeEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Builder // 어느 필드에 어떤 값을 채워야하는지 명확하게 알 수 있기 때문에
@AllArgsConstructor
@NoArgsConstructor // Lombok - 빈 생성자를 만듬
@Entity //JPA로 관리되는 엔티티 객체 (테이블)
public class User extends BaseTimeEntity {

    @Id // 테이블의 Primary Key(PK)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long code; //sequence, auto_increment

    //@Override
    @Column(nullable = false, length = 20, name = "user_id")
    // 아이디
    // user_id 라고 명명하면 read 불가 DB에 들어가는 컬럼명만 user_id로 설정
    //
    private String username;

    //@Override
    @Column(nullable = false, length = 100)
    private String password; // 비밀번호

    @Column(nullable = false, length = 30)
    // 이름
    // 컬럼명은 user_name으로 설정
    private String user_name;

    @Column(nullable = false, length = 20)
    private String user_nickname; //닉네임

    @Column(nullable = false, length = 100)
    private String user_birth; //생년월일

    @Column(nullable = false, length = 100)
    private String user_phone; // 휴대폰 번호

    @Column(nullable = false, length = 50)
    private String user_email; // 이메일

    @Column(nullable = false, length = 100)
    private String user_address; //주소

//    이미 존재
//    @Column(nullable = false, length = 100)
//    private String user_date; //회원가입일자


    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;

    /**
     * 비밀번호 암호화 메소드
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 권한 메소드
     */
    public String getRoleKey() {
        return this.role.getKey();
    }

    /**
     * 회원수정 메소드
     */
    public void update(String user_pw, String user_nickname) {
        this.password = password;
        this.user_nickname = user_nickname;
    }
}