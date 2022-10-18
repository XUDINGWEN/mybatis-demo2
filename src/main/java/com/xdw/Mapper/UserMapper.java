package com.xdw.Mapper;

import com.xdw.pojo.User;

import java.util.List;

/**
 * @Author XDW
 * @Version 1.0
 * @date 18/10/2022 下午2:29
 */
public interface UserMapper {


    List<User> selectAll();

    User selectById(int id);
}
