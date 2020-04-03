package com.ishang.vm.dto;

import com.ishang.vm.dto.base.OutputConverter;
import com.ishang.vm.pojo.AdminRole;
import com.ishang.vm.pojo.User;
import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
@ToString
public class UserDTO implements OutputConverter<UserDTO, User> {

    private int id;

    private String username;

    private String name;

    private String phone;

    private String email;

    private boolean enabled;

    private List<AdminRole> roles;

}

