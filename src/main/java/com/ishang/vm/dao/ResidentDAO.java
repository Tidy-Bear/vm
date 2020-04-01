package com.ishang.vm.dao;
import com.ishang.vm.pojo.Resident;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ResidentDAO extends JpaRepository<Resident,Integer> {
    List<Resident> findAllByNameLikeOrEmplaceLike(String keyword1, String keyword2);
}
