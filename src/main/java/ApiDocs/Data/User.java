package ApiDocs.Data;

import ApiDocs.Enums.UserEnums;
import ApiDocs.config.AesEncrypter;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@Entity
@Getter
@Setter
@Table(name = "tbl_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String username;

    @Convert(converter = AesEncrypter.class)
    private String password;

    @Column(unique = true)
    private String email;

    private UserEnums.Gender gender;
}
