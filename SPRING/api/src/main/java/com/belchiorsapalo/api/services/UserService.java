package com.belchiorsapalo.api.services;

import java.util.List;

import com.belchiorsapalo.api.domain.User;
import com.belchiorsapalo.api.domain.dto.UserDTO;

public interface UserService {
    User findById(Integer id);
    List<User> findAll();
    User create(UserDTO dto);
    User update(UserDTO dto);
    void delete(Integer id);
}
