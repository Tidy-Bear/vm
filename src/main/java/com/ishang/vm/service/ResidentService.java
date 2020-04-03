package com.ishang.vm.service;

import com.ishang.vm.dao.ResidentDAO;
import com.ishang.vm.pojo.Resident;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResidentService {
    @Autowired
    ResidentDAO residentDAO;

    public List<Resident> list() {
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        return residentDAO.findAll(sort);
    }

    public boolean addOrUpdate(Resident resident) {
        try {
            residentDAO.save(resident);
        }catch (IllegalArgumentException e){
            return false;
        }
        return true;
    }

    public boolean deleteById(int id) {
        try{
            residentDAO.deleteById(id);
        }catch (IllegalArgumentException e){
            return false;
        }
        return true;
    }

    public List<Resident> Search(String keywords){
        return residentDAO.findAllByNameLikeOrEmplaceLike('%' + keywords + '%', '%' + keywords + '%');
    }

}
