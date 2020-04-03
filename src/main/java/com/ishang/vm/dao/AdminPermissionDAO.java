package com.ishang.vm.dao;
import com.ishang.vm.pojo.AdminPermission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminPermissionDAO extends JpaRepository<AdminPermission, Integer> {
    AdminPermission findById(int id);
}
