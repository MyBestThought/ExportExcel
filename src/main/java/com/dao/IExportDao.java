package com.dao;

import com.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @ClassName IExportDao
 * @Description TODO
 * @Author YHT
 * @Date 2021/7/17 21:45
 */
@Repository
public interface IExportDao {
    List<User> findAll();
}