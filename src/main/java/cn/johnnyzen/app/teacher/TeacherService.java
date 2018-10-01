package cn.johnnyzen.app.teacher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.logging.Logger;

/**
 * @IDE: Created by IntelliJ IDEA.
 * @Author: 千千寰宇
 * @Date: 2018/9/30  19:36:40
 * @Description: ...
 */
@Service
public class TeacherService {
    private static final Logger logger = Logger.getLogger(TeacherService.class.getName());

    @Autowired
    private TeacherRepository teacherRepository;

    public List<Teacher> findByTeacherUrl(String teacherUrl){
        return teacherRepository.findByTeacherUrl(teacherUrl);
    }

    public List<Teacher> findAll(){
        return teacherRepository.findAll();
    }

    @Transactional
    public boolean exists(String teachearUrl){
        List<Teacher> list = teacherRepository.findByTeacherUrl(teachearUrl);
        if(list.size() != 0){
            logger.info("This teacher has existed! | url:" + teachearUrl);
            return true;
        } else {
            logger.info("This teacher has not existed! | url:" + teachearUrl);
            return false;
        }
    }

    /*
     * update or add a teacher
     **/
    @Transactional
    public void save(Teacher teacher){
        teacherRepository.save(teacher);
    }

    /*
     * batch save
     */
    @Transactional
    public void saveAll(Iterable<Teacher> collection){
        teacherRepository.saveAll(collection);
    }
}
