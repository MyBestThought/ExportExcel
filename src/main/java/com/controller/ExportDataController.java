package com.controller;

import cn.hutool.core.io.IoUtil;
import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.ExcelWriter;
import com.entity.User;
import com.mysql.jdbc.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.service.ExportService;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @ClassName ExportDataController
 * @Description TODO
 * @Author YHT
 * @Date 2021/7/17 20:33
 */
@Controller
public class ExportDataController {
    @Autowired
    private ExportService exportService;

    @RequestMapping("/toExport")
    public ModelAndView toExport(){
        ModelAndView mv = new ModelAndView();
        List<User> userList = exportService.findAll();
        mv.addObject("userList", userList);
        mv.setViewName("export");
        return mv;
    }
    @RequestMapping("/export")
    public void export(HttpServletResponse response) throws UnsupportedEncodingException {
        //从数据库中查询到数据
        List<User> userList = exportService.findAll();
        // 通过工具类创建writer，默认创建xls格式
        ExcelWriter writer = ExcelUtil.getWriter();
        //自定义标题别名
        writer.addHeaderAlias("id", "序号");
        writer.addHeaderAlias("username", "姓名");
        writer.addHeaderAlias("address", "地址");
        writer.addHeaderAlias("age", "年龄");
        // 合并单元格后的标题行，使用默认标题样式
        writer.merge(3, "人员信息");
        // 一次性写出内容，使用默认样式，强制输出标题
        writer.write(userList, true);
        //out为OutputStream，需要写出到的目标流
        //response为HttpServletResponse对象
        response.setContentType("application/vnd.ms-excel;charset=utf-8");
        //dateString.xls是弹出下载对话框的文件名，用日期作为文件名称
        Date currentTime = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString = formatter.format(currentTime);
        response.setHeader("Content-Disposition","attachment;filename="+dateString+".xls");
        ServletOutputStream out= null;
        try {
            out = response.getOutputStream();
            writer.flush(out, true);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            // 关闭writer，释放内存
            writer.close();
        }
        //此处记得关闭输出Servlet流
        IoUtil.close(out);
    }
}