package com.ishang.vm.service;
import com.ishang.vm.dao.UserDAO;
import com.ishang.vm.dto.UserDTO;
import com.ishang.vm.pojo.AdminRole;
import com.ishang.vm.pojo.User;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.util.HtmlUtils;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {
    @Autowired
    UserDAO userDAO;
    @Autowired
    AdminRoleService adminRoleService;
    @Autowired
    AdminUserRoleService adminUserRoleService;

    public List<UserDTO> list() {
        List<User> users =  userDAO.findAll();
        List<AdminRole> roles;

        List<UserDTO> userDTOS = users.stream().map(user -> (UserDTO) new UserDTO().convertFrom(user)).collect(Collectors.toList());

        for (UserDTO userDTO : userDTOS) {
            roles = adminRoleService.listRolesByUser(userDTO.getUsername());
            userDTO.setRoles(roles);
        }

        return userDTOS;
    }

    public boolean isExist(String username) {
        User user = userDAO.findByUsername(username);
        return null!=user;
    }

    public User findByUsername(String username) {
        return userDAO.findByUsername(username);
    }

    public User get(String username, String password){
        return userDAO.getByUsernameAndPassword(username, password);
    }

    public void addOrUpdate(User user) {
        userDAO.save(user);
    }

    public int register(User user) {
        String username = user.getUsername();
        String name = user.getName();
        String phone = user.getPhone();
        String email = user.getEmail();
        String password = user.getPassword();

        username = HtmlUtils.htmlEscape(username);
        user.setUsername(username);
        name = HtmlUtils.htmlEscape(name);
        user.setName(name);
        phone = HtmlUtils.htmlEscape(phone);
        user.setPhone(phone);
        email = HtmlUtils.htmlEscape(email);
        user.setEmail(email);
        user.setEnabled(true);

        if (username.equals("") || password.equals("")) {
            return 0;
        }

        boolean exist = isExist(username);

        if (exist) {
            return 2;
        }

        // 默认生成 16 位盐
        String salt = new SecureRandomNumberGenerator().nextBytes().toString();
        int times = 2;
        String encodedPassword = new SimpleHash("md5", password, salt, times).toString();

        user.setSalt(salt);
        user.setPassword(encodedPassword);
        userDAO.save(user);

        return 1;
    }

    public boolean updateUserStatus(User user) {
        User userInDB = userDAO.findByUsername(user.getUsername());
        userInDB.setEnabled(user.isEnabled());
        try {
            userDAO.save(userInDB);
        } catch (IllegalArgumentException e) {
            return false;
        } return true;
    }

    public boolean resetPassword(User user) {
        User userInDB = userDAO.findByUsername(user.getUsername());
        String salt = new SecureRandomNumberGenerator().nextBytes().toString();
        int times = 2;
        userInDB.setSalt(salt);
        String encodedPassword = new SimpleHash("md5", "123", salt, times).toString();
        userInDB.setPassword(encodedPassword);
        try {
            userDAO.save(userInDB);
        } catch (IllegalArgumentException e) {
            return false;
        }
        return true;
    }

    public boolean editUser(User user) {
        User userInDB = userDAO.findByUsername(user.getUsername());
        userInDB.setName(user.getName());
        userInDB.setPhone(user.getPhone());
        userInDB.setEmail(user.getEmail());
        try {
            userDAO.save(userInDB);
            adminUserRoleService.saveRoleChanges(userInDB.getId(), user.getRoles());
        } catch (IllegalArgumentException e) {
            return false;
        }
        return true;
    }
}
