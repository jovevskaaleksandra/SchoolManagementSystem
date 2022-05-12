package finki.projects.schoolmanagementsystem181074.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Teaching {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    @ManyToOne
    private Class c;

    @ManyToOne
    private Subject subject;

    @ManyToOne
    private Teacher teacher;

    public Teaching() {
        super();
    }

    public Teaching(Integer id, Class c, Subject subject, Teacher teacher) {
        super();
        this.id = id;
        this.c = c;
        this.subject = subject;
        this.teacher = teacher;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Class getC() {
        return c;
    }

    public void setC(Class c) {
        this.c = c;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }
}
