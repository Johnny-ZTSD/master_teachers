package cn.johnnyzen.app.teacher;

import javax.persistence.*;
import java.util.Calendar;
import java.util.Date;

/**
 * @IDE: Created by IntelliJ IDEA.
 * @Author: 千千寰宇
 * @Date: 2018/9/29  21:59:15
 * @Description: ...
 */

@Entity
@Table(name = "tb_teacher", schema = "master_teachers", catalog = "")
public class Teacher {
    @Id
    @Column(name = "pk_teacher_id", nullable = false)
    @GeneratedValue
    private int id;

    @Basic
    @Column(name = "teacher_url", nullable = false, length = 255)
    private String teacherUrl;

    @Basic
    @Column(name="isVisited", nullable = false, length = 1)
    private Integer isVisited;

    @Basic
    @Column(name = "teacher_code", nullable = true, length = 255)
    private String teacherCode;

    @Basic
    @Column(name = "name", nullable = true, length = 255)
    private String name;

    @Basic
    @Column(name = "school", nullable = true, length = 255)
    private String school;

    @Basic
    @Column(name = "department", nullable = true, length = 255)
    private String department;

    @Basic
    @Column(name = "sex", nullable = false, columnDefinition = "char(1) default 'U' ",length = 1)
    private Character sex;

    @Basic
    @Column(name = "birthday", nullable = true)
    @Temporal(value=TemporalType.DATE)
    private Calendar birthday = null;

    @Basic
    @Column(name = "special_title", length=255)
    private String specialTitle;

    @Basic
    @Column(name = "profession_title", nullable = true, length = 255,  columnDefinition = "varchar(255) comment '特称'")
    private String professionTitle;

    @Basic
    @Column(name = "academic_degree", nullable = true, length = 255)
    private String academicDegree;

    @Basic
    @Column(name = "position_property", nullable = true, length = 255)
    private String positionProperty;

    @Basic
    @Column(name = "email", nullable = true, length = 255)
    private String email;

    @Basic
    @Column(name = "academic_experience", columnDefinition = "text comment '学术经历'", nullable = true)
    private String academicExperience;

    @Basic
    @Column(name = "personal_profile", columnDefinition = "text comment '个人简介'", nullable = true)
    private String personalProfile;


    @Basic
    @Column(name = "research_project", columnDefinition = "text comment '科研项目'", nullable = true)
    private String researchProject;

    @Basic
    @Column(name = "papers", columnDefinition = "text comment '论文/发表文章'", nullable = true)
    private String papers;

    public Teacher() {
        this.birthday = Calendar.getInstance();
        birthday.set(Calendar.YEAR, 1900); //default year
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTeachearUrl() {
        return teacherUrl;
    }

    public void setTeachearUrl(String teachearUrl) {
        this.teacherUrl = teachearUrl;
    }

    public String getTeacherCode() {
        return teacherCode;
    }

    public void setTeacherCode(String teacherCode) {
        this.teacherCode = teacherCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Character getSex() {
        return sex;
    }

    public void setSex(Character sex) {
        this.sex = sex;
    }

    public Calendar getBirthday() {
        return birthday;
    }

    public void setBirthday(Calendar birthday) {
        this.birthday = birthday;
    }

    public String getTeacherUrl() {
        return teacherUrl;
    }

    public void setTeacherUrl(String teacherUrl) {
        this.teacherUrl = teacherUrl;
    }

    public String getSpecialTitle() {
        return specialTitle;
    }

    public void setSpecialTitle(String specialTitle) {
        this.specialTitle = specialTitle;
    }

    public String getProfessionTitle() {
        return professionTitle;
    }

    public void setProfessionTitle(String professionTitle) {
        this.professionTitle = professionTitle;
    }

    public String getAcademicDegree() {
        return academicDegree;
    }

    public void setAcademicDegree(String academicDegree) {
        this.academicDegree = academicDegree;
    }

    public String getPositionProperty() {
        return positionProperty;
    }

    public void setPositionProperty(String positionProperty) {
        this.positionProperty = positionProperty;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAcademicExperience() {
        return academicExperience;
    }

    public void setAcademicExperience(String academicExperience) {
        this.academicExperience = academicExperience;
    }

    public String getPersonalProfile() {
        return personalProfile;
    }

    public void setPersonalProfile(String personalProfile) {
        this.personalProfile = personalProfile;
    }

    public String getResearchProject() {
        return researchProject;
    }

    public void setResearchProject(String researchProject) {
        this.researchProject = researchProject;
    }

    public String getPapers() {
        return papers;
    }

    public void setPapers(String papers) {
        this.papers = papers;
    }

    public Integer getIsVisited() {
        return isVisited;
    }

    public void setIsVisited(Integer isVisited) {
        this.isVisited = isVisited;
    }

    @Override
    public String toString() {
        return "Teacher{\n" +
                "\tid=" + id +
                ",\n\t teachearUrl='" + teacherUrl + '\'' +
                ",\n\t isVisited = '" + isVisited + '\'' +
                ",\n\t teacherCode='" + teacherCode + '\'' +
                ",\n\t name='" + name + '\'' +
                ",\n\t school='" + school + '\'' +
                ",\n\t department='" + department + '\'' +
                ",\n\t sex='" + sex + '\'' +
                ",\n\t birthday=" + birthday.get(Calendar.YEAR) + "-" + (birthday.get(Calendar.MONTH) + 1) + '\'' +
                ",\n\t specialTitle='" + specialTitle + '\'' +
                ",\n\t professionTitle='" + professionTitle + '\'' +
                ",\n\t academicDegree='" + academicDegree + '\'' +
                ",\n\t positionProperty='" + positionProperty + '\'' +
                ",\n\t email='" + email + '\'' +
                ",\n\t academicExperience='" + academicExperience + '\'' +
                ",\n\t personalProfile='" + personalProfile + '\'' +
                ",\n\t researchProject='" + researchProject + '\'' +
                ",\n\t papers='" + papers + '\'' +
                "\n}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Teacher tbTeacher = (Teacher) o;

        if (id != tbTeacher.id) return false;
        if (teacherUrl != null ? !teacherUrl.equals(tbTeacher.teacherUrl) : tbTeacher.teacherUrl != null)
            return false;
        if (isVisited != null ? !teacherCode.equals(tbTeacher.isVisited) : tbTeacher.isVisited != null)
            return false;
        if (teacherCode != null ? !teacherCode.equals(tbTeacher.teacherCode) : tbTeacher.teacherCode != null)
            return false;
        if (name != null ? !name.equals(tbTeacher.name) : tbTeacher.name != null) return false;
        if (school != null ? !school.equals(tbTeacher.school) : tbTeacher.school != null) return false;
        if (department != null ? !department.equals(tbTeacher.department) : tbTeacher.department != null) return false;
        if (sex != null ? !sex.equals(tbTeacher.sex) : tbTeacher.sex != null) return false;
        if (birthday != null ? !birthday.equals(tbTeacher.birthday) : tbTeacher.birthday != null) return false;
        if (specialTitle != null ? !specialTitle.equals(tbTeacher.specialTitle) : tbTeacher.specialTitle != null)
            return false;
        if (professionTitle != null ? !professionTitle.equals(tbTeacher.professionTitle) : tbTeacher.professionTitle != null)
            return false;
        if (academicDegree != null ? !academicDegree.equals(tbTeacher.academicDegree) : tbTeacher.academicDegree != null)
            return false;
        if (positionProperty != null ? !positionProperty.equals(tbTeacher.positionProperty) : tbTeacher.positionProperty != null)
            return false;
        if (email != null ? !email.equals(tbTeacher.email) : tbTeacher.email != null) return false;
        if (academicExperience != null ? !academicExperience.equals(tbTeacher.academicExperience) : tbTeacher.academicExperience != null)
            return false;
        if (personalProfile != null ? !personalProfile.equals(tbTeacher.personalProfile) : tbTeacher.personalProfile != null)
            return false;
        if (researchProject != null ? !researchProject.equals(tbTeacher.researchProject) : tbTeacher.researchProject != null)
            return false;
        if (papers != null ? !papers.equals(tbTeacher.papers) : tbTeacher.papers != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (teacherUrl != null ? teacherUrl.hashCode() : 0);
        result = 31 * result + (isVisited != null ? isVisited.hashCode() : 0);
        result = 31 * result + (teacherCode != null ? teacherCode.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (school != null ? school.hashCode() : 0);
        result = 31 * result + (department != null ? department.hashCode() : 0);
        result = 31 * result + (sex != null ? sex.hashCode() : 0);
        result = 31 * result + (birthday != null ? birthday.hashCode() : 0);
        result = 31 * result + (specialTitle != null ? specialTitle.hashCode() : 0);
        result = 31 * result + (professionTitle != null ? professionTitle.hashCode() : 0);
        result = 31 * result + (academicDegree != null ? academicDegree.hashCode() : 0);
        result = 31 * result + (positionProperty != null ? positionProperty.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (academicExperience != null ? academicExperience.hashCode() : 0);
        result = 31 * result + (personalProfile != null ? personalProfile.hashCode() : 0);
        result = 31 * result + (researchProject != null ? researchProject.hashCode() : 0);
        result = 31 * result + (papers != null ? papers.hashCode() : 0);
        return result;
    }
}
