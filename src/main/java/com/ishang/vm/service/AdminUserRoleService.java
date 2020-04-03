package com.ishang.vm.service;

import com.ishang.vm.dao.AdminUserRoleDAO;
import com.ishang.vm.pojo.AdminRole;
import com.ishang.vm.pojo.AdminUserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AdminUserRoleService {
    @Autowired
    AdminUserRoleDAO adminUserRoleDAO;
    public List<AdminUserRole> listAllByUid(int uid) {
        return adminUserRoleDAO.findAllByUid(uid);
    }

    @Transactional
    public void saveRoleChanges(int uid, List<AdminRole> roles) {
        adminUserRoleDAO.deleteAllByUid(uid);
        roles.forEach(r -> {
            AdminUserRole ur = new AdminUserRole();
            ur.setUid(uid);
            ur.setRid(r.getId());
            adminUserRoleDAO.save(ur);
        });
    }
}
