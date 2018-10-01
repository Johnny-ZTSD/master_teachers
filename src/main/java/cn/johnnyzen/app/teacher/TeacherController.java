package cn.johnnyzen.app.teacher;

import cn.johnnyzen.util.reuslt.Result;
import cn.johnnyzen.util.reuslt.ResultCode;
import cn.johnnyzen.util.reuslt.ResultUtil;
import com.sun.org.apache.regexp.internal.RE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @IDE: Created by IntelliJ IDEA.
 * @Author: 千千寰宇
 * @Date: 2018/9/30  18:51:23
 * @Description: ...
 */

@RestController
@RequestMapping("/teachers")
public class TeacherController {
    @Autowired
    private TeacherService teacherService;

    /**
     * 内容：返回数据库内所有教师信息
     * 格式：json
     */
    @RequestMapping("listAll.json")
    public Result list(){
        return ResultUtil.success(teacherService.findAll());
    }

    @RequestMapping("findByUrl.json")
    public Result findByUrl(@RequestParam("url") String url){
        return ResultUtil.success(teacherService.findByTeacherUrl(url));
    }

}
