package ColumnEncrypt.Model;

import ColumnEncrypt.Enums.UserEnums;

public class UserCreateRequest {
    public String username;
    public String password;
    public String email;
    public UserEnums.Gender gender;
}
