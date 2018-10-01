package cn.johnnyzen.robot.core;

import cn.johnnyzen.app.teacher.Teacher;
import cn.johnnyzen.app.teacher.TeacherRepository;
import cn.johnnyzen.app.teacher.TeacherService;
import cn.johnnyzen.util.request.RequestUtil;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.*;

import static com.sun.activation.registries.LogSupport.log;

/**
 * @IDE: Created by IntelliJ IDEA.
 * @Author: 千千寰宇
 * @Date: 2018/9/29  20:40:02
 * @Description: ...
 */
@Component("masterTeacherSpider")
@ConfigurationProperties(prefix="masterteacherspider")
public class MasterTeacherSpider {
    private String indexUrl = null;
    private List<String> colleges;//二级学院名
    private List<String> allTeacherUrls;//导师链接
    private Map<String, Teacher> teachers= null;//String:teacherUrl

    @Autowired //从Spring容器取值使用【前提：Component生效】
    private RequestUtil requestUtil;
    @Autowired
    private TeacherService teacherService;

    private MasterTeacherSpider() {
        colleges = new ArrayList<String>();
        teachers = new HashMap<String, Teacher>();
    }

    public MasterTeacherSpider(String indexUrl) {
        this();
        this.indexUrl = indexUrl;
    }

    /*
     * 爬取index页的所有教师主页链接(原始链接，未必为绝对Url)
     **/
    public List<String> getAllTeacherUrls(String indexUrl) throws IOException, URISyntaxException {
        URI base= new URI(indexUrl);//基本网页URI
        Document document = requestUtil.getDocument(indexUrl);
        Elements elements =  document.select(".NewsDetails table a");
        allTeacherUrls = elements.eachAttr("href");
        for(int i=0,len = elements.size();i<len;i++){
            URI abs = base.resolve(allTeacherUrls.get(i));//解析于上述网页的相对URL，得到绝对URI
            allTeacherUrls.remove(i);
            allTeacherUrls.add(i,abs.toURL().toString());
//            System.out.println(allTeacherUrls.get(i));
        }
        return allTeacherUrls;
    }

    /*
     * 解析所有教师主页html数据
     * @return all Teacher Objects
     * */
    public Map<String, Teacher> parseAllTeachers(String indexUrl, List<String> allTeacherUrls) throws IOException {
        Map<String, Teacher> teachers = new HashMap<String, Teacher>();
        for(int i=0,size = allTeacherUrls.size();i<size;i++){
            String url = allTeacherUrls.get(i);
            if(!teacherService.exists(url)){//该导师链接未被解析
                Teacher teacher = parseTeacher(allTeacherUrls.get(i));
                teachers.put(allTeacherUrls.get(i),teacher);
                teacherService.save(teacher); //存储至数据库中
                System.out.println(teacher.toString());//测试：打印导师数据
            }
            //System.out.println(url);
        }
        return teachers;
    }

    /*
     * 解析所有教师主页html数据
     * @return a Teacher Object
     **/
    public Teacher parseTeacher(String url) throws IOException {

        Document document = null;
        while(document == null) {
            document = requestUtil.getDocument(url);
        }

        //System.out.println("[导师代码] " + document.getElementById("Labeldsdm").text().trim().toString());
        //System.out.print(document.getElementById("Labeldsdm").text());

        Teacher teacher = new Teacher();
        teacher.setIsVisited(1); //已被解析
        teacher.setTeachearUrl(url);

        teacher.setDepartment(
                document.getElementById("Labelxydm").text().trim() + " " +
                        document.getElementById("Labelxymc").text().trim());
        teacher.setTeachearUrl(url);
        teacher.setTeacherCode(document.getElementById("Labeldsdm").text().trim());
        teacher.setName(document.getElementById("Labeldsxm").text().trim());

        String sex = document.getElementById("Labelxb").text().trim();
        if(sex.equals("男")){
            teacher.setSex('M');
        } else if(sex.equals("女")){
            teacher.setSex('F');
        } else {
            log("性别解析错误！");
        }


        String dateStr = document.getElementById("Labelcsny").text().trim();
        if(dateStr.length() > 0){
            if(dateStr.contains("年")){//含19xx年xx月xx日 的才解析，其他格式不解析（防止解析异常，导致程序崩溃）
                String[] dateArr = dateStr.split("年");
                Calendar date = Calendar.getInstance();
                date.set(Calendar.YEAR, Integer.parseInt(dateArr[0]));
                //Calendar 的 month 从 0 开始，也就是全年 12 个月由 0 ~ 11 进行表示
                date.set(Calendar.MONTH, Integer.parseInt(dateArr[1].split("月")[0]) - 1);
                date.set(Calendar.DATE, 1);
                teacher.setBirthday(date);
            }
        }

        teacher.setSpecialTitle(document.getElementById("Labeltc").text().trim());
        teacher.setProfessionTitle(document.getElementById("Labelzc").text().trim());
        teacher.setAcademicDegree(document.getElementById("Labelxw").text().trim());
        teacher.setPositionProperty(document.getElementById("Labelsx").text().trim());
        teacher.setEmail(document.getElementById("Labelemail").text().trim());
        teacher.setAcademicExperience(document.getElementById("Labelxsjl").text().trim());
        teacher.setPersonalProfile(document.getElementById("Labelgrjj").text().trim());
        teacher.setResearchProject(document.getElementById("lblKyxm").text().trim());
        teacher.setPapers(document.getElementById("lblFbwz").text().trim());

        //System.out.println(teacher.toString());

        return teacher;
    }

    public String getIndexUrl() {
        return indexUrl;
    }

    public void setIndexUrl(String indexUrl) {
        this.indexUrl = indexUrl;
    }

    public List<String> getColleges() {
        return colleges;
    }

    public void setColleges(List<String> colleges) {
        this.colleges = colleges;
    }

    public void setAllTeacherUrls(List<String> allTeacherUrls) {
        this.allTeacherUrls = allTeacherUrls;
    }

    public Map<String, Teacher> getTeachers() {
        return teachers;
    }

    public void setTeachers(Map<String, Teacher> teachers) {
        this.teachers = teachers;
    }

    public RequestUtil getRequestUtil() {
        return requestUtil;
    }

    public void setRequestUtil(RequestUtil requestUtil) {
        this.requestUtil = requestUtil;
    }
}