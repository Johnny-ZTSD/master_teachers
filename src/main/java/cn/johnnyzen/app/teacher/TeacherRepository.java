package cn.johnnyzen.app.teacher;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @IDE: Created by IntelliJ IDEA.
 * @Author: 千千寰宇
 * @Date: 2018/9/30  19:35:00
 * @Description: ...
 */
//业务抽象DAO，继承此接口即可

public interface TeacherRepository extends JpaRepository<Teacher, Integer>{
    //新添方法:命名一定得规范
    public List<Teacher> findByTeacherUrl(String teacherUrl);

    public List<Teacher> findByDepartment(String department);

    @Query("select t from Teacher t where t.name like CONCAT('%',:name,'%')")
    public List<Teacher> findByName(@Param(value="name") String name);

    @Query("select t from Teacher t where t.name like CONCAT('%',:name,'%')")
    public Page<Teacher> findPageByName(@Param("name") String name, Pageable pageable);
}
