package ApiDocs.Model;

import ApiDocs.Enums.UserEnums;
import io.swagger.v3.oas.annotations.media.Schema;

public class UserCreateRequest {
    public String username;
    public String password;
    public String email;

    @Schema(implementation = UserEnums.DocumentationGender.class)
    public UserEnums.Gender gender;
}
