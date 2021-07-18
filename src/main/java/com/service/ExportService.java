package com.service;

import com.entity.User;

import java.util.List;

/**
 * @ClassName ExportService
 * @Description TODO
 * @Author YHT
 * @Date 2021/7/17 21:45
 */
public interface ExportService {
    List<User> findAll();
}