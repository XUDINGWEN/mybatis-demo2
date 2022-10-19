package com.xdw.Mapper;

import com.xdw.pojo.Brand;
import com.xdw.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @Author XDW
 * @Version 1.0
 * @date 19/10/2022 下午7:26
 */
public interface BrandMapper {
    List<User> selectAll();

    Brand selectAllByBrandNameUser(@Param("brandName") String brandName);

    List<Brand> selectByCondition( Map map);

    int update(Brand brand);

    void add(Brand brand);

    void deleteById(int id);

    void deleteByIds(int[] ids);
}
