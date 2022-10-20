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
    List<Brand> selectAll2();

    Brand selectAllByBrandNameUser(@Param("brandName") String brandName);

    List<Brand> selectByCondition(Map map);

    int update(Brand brand);

    //虽然可以自己识别为
    void add(@Param("brand") Brand brand);

    void deleteById(@Param("id")int id);

    void deleteByIds(@Param("ids")int[] ids);
}
