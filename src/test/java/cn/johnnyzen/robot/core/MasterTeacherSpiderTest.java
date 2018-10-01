package cn.johnnyzen.robot.core;

import cn.johnnyzen.util.request.RequestProperties;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

/**
 * @IDE: Created by IntelliJ IDEA.
 * @Author: 千千寰宇
 * @Date: 2018/9/30  22:24:40
 * @Description: ...
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MasterTeacherSpiderTest {
    @Autowired
    private RequestProperties requestproperties;

    @Autowired
    private MasterTeacherSpider masterTeacherSpider;

    //@Test
    public void parseTeacher() throws IOException {
        String url = "http://222.197.183.99/TutorDetails.aspx?id=2497";
        System.out.println(masterTeacherSpider.parseTeacher(url));
    }

    //@Test
    public void requestpropertiesTest(){
        System.out.println(requestproperties.toString());
    }

    @Test
    public void allTeachersUrlsTest() throws IOException, URISyntaxException {
        System.out.println(masterTeacherSpider.getRequestUtil().toString());
        List<String> urls = masterTeacherSpider.getAllTeacherUrls(masterTeacherSpider.getIndexUrl());
        for(String item : urls){
            System.out.println(item);
        }
    }
}
