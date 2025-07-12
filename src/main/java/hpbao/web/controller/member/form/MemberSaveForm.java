package hpbao.web.controller.member.form;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class MemberSaveForm {


        @NotBlank()
        @Size(min = 2, max = 30)
        @Pattern(regexp = "^[가-힣]*$")
        private String userName;

        @NotBlank
        @Size(min = 8 , max = 12)
        @Pattern(regexp="^(?=.*[a-zA-Z]+)(?=.*\\d+)[a-zA-Z\\d]*$") // 영문자 숫자 필수 포함,8~12 길이 제한
        private String userId;


        @NotBlank
        @Size(min = 8 , max = 16)
        @Pattern(regexp = "^(?=.*[a-z]+)(?=.*[A-Z]+)(?=.*\\d+)(?=.*[@#$%^&+=!]).+$")
        private String password;


        @Email(regexp = "^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,4}$")
        private String userEmail;

        public MemberSaveForm(String userName, String userId, String password, String userEmail) {
                this.userName = userName;
                this.userId = userId;
                this.password = password;
                this.userEmail = userEmail;
        }
}


