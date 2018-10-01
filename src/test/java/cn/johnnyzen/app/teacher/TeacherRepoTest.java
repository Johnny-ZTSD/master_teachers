package cn.johnnyzen.app.teacher;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @IDE: Created by IntelliJ IDEA.
 * @Author: 千千寰宇
 * @Date: 2018/9/30  20:41:38
 * @Description: ...
 */

public class TeacherRepoTest {
    @Autowired
    private TeacherRepository teacherRepository;

    public TeacherRepository getTeacherRepository() {
        return teacherRepository;
    }

    public void setTeacherRepository(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    @Test
    public void test01(){
        //System.out.println(teacherRepository.findByName("曾葆青"));
    }
}
