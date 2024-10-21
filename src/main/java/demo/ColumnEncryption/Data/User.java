package demo.ColumnEncryption.Data;

import demo.ColumnEncryption.Enums.UserEnums;
import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Setter
@Getter
@Table(name = "tbl_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String username;
    private String password;

    @Column(unique = true)
    private String email;

    private UserEnums.Gender gender;
}
