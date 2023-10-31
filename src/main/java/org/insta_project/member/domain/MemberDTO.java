package org.insta_project.member.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberDTO {

    private String userName;
    private String userId;
    private String password;
    private String userPhone;
    private String gender;
    private String birthDay;
    private String address;
    private String email;
}
