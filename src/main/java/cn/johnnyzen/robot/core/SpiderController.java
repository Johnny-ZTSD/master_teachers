package cn.johnnyzen.robot.core;

import cn.johnnyzen.app.teacher.Teacher;
import cn.johnnyzen.util.reuslt.Result;
import cn.johnnyzen.util.reuslt.ResultCode;
import cn.johnnyzen.util.reuslt.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 * @IDE: Created by IntelliJ IDEA.
 * @Author: 千千寰宇
 * @Date: 2018/10/1  09:51:26
 * @Description: ...
 */
@RestController
public class SpiderController {
    private static final Logger logger = Logger.getLogger(SpiderController.class.getName());

    @Autowired
    private MasterTeacherSpider masterTeacherSpider;

    @RequestMapping("/execute")
    /*
     * step1. 获取所有导师的主页Url
     * step2. 依次遍历所有导师的Url(爬取导师数据)
     * step3.     if(数据库查询该链接是否已被爬取 == false){
     * step4.         爬取并解析该导师数据，置该链接为已解析状态
     * step5.         存储导师数据到数据库中
     *            }
     * step6. 返回执行结果：success or fail
     */
    public Result execute() {
        Result result = new Result();
        Teacher[] teachers = null;
//        System.out.println(masterTeacherSpider.getRequestUtil().toString());
        try {
            teachers = (Teacher[]) masterTeacherSpider.parseAllTeachers(
                    masterTeacherSpider.getIndexUrl(),
                    masterTeacherSpider.getAllTeacherUrls(
                            masterTeacherSpider.getIndexUrl()
                    )
            ).values().toArray();
        } catch (IOException e) {
            logger.warning(e.getMessage());
            return ResultUtil.error(ResultCode.INTERNAL_SERVER_ERROR, e.getMessage());
        } catch (URISyntaxException e) {
            logger.warning(e.getMessage());
            return ResultUtil.error(ResultCode.INTERNAL_SERVER_ERROR, e.getMessage());
        }
        return ResultUtil.success(teachers);
    }
}
