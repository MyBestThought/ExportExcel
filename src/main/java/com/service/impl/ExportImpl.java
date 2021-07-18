package com.service.impl;

import com.dao.IExportDao;
import com.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.service.ExportService;

import java.util.List;

/**
 * @ClassName ExportImpl
 * @Description TODO
 * @Author YHT
 * @Date 2021/7/17 21:56
 */
@Service
public class ExportImpl implements ExportService {
    @Autowired
    private IExportDao exportDao;
    @Override
    public List<User> findAll() {
        return exportDao.findAll();
    }
}