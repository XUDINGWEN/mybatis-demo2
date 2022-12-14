package com.xdw;

import com.xdw.Mapper.BrandMapper;
import com.xdw.pojo.Brand;
import com.xdw.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author XDW
 * @Version 1.0
 * @date 18/10/2022 下午8:21
 */
public class test1 {
    @Test
    public void BrandUse_selectAll() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        List<Brand> users = mapper.selectAll2();
        System.out.println(users);
    }


    @Test
    public void BrandUse_selectBy_() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        Brand huawei = mapper.selectAllByBrandNameUser("华为");

        System.out.println(huawei);


    }
    @Test
    public void BrandUse_selectBy_condition() throws IOException {
        //接收参数
        int status = 1;
        String companyName = "华为";
        String brandName = "华为";

        // 处理参数
        companyName = "%" + companyName + "%";
        brandName = "%" + brandName + "%";

        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);

        Map map = new HashMap();
        map.put("status",status);
        map.put("companyName",companyName);
        map.put("brandName",brandName);

        List<Brand> brands = mapper.selectByCondition(map);
        System.out.println(brands);



    }

    @Test
    public void UpdateBy_id() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);

        Brand brand = new Brand();
        brand.setId(4);
        brand.setDescription("58同城带你找工作");

        mapper.update(brand);

        sqlSession.close();
    }

    @Test
    public void add() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);

        Brand brand = new Brand("同城4", "58同城4", 96, "帮助所有人找到工作4", 1);
        mapper.add(brand);
        Brand TongCheng = mapper.selectAllByBrandNameUser("同城2");
        System.out.println(TongCheng);
        System.out.println(brand.getId());

        System.out.println(mapper.selectAll2());

        sqlSession.close();
    }

    @Test
    public void delete_By_id() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);


        mapper.deleteById(7);
        System.out.println(mapper.selectAll2());
        sqlSession.close();

    }

    @Test
    public void delete_By_ids() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);

        int[] ids = {8};
        mapper.deleteByIds(ids);


        sqlSession.close();
    }
}
