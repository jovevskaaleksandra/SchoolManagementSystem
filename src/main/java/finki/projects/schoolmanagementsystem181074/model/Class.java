package finki.projects.schoolmanagementsystem181074.model;


import lombok.Data;

import javax.persistence.*;
import java.util.List;
import javax.persistence.Id;

@Data
@Entity
public class Class {

    @Id
    private Integer id;

    private String name;

    @ManyToOne
    private School school;

    @ManyToOne
    private Level level;

    @ManyToOne
    private SchoolYear schoolYear;

    @OneToMany(cascade = CascadeType.ALL, mappedBy="c")
    private List<Registration> registrations;

    public Class() {
    }

    public Class(Integer id, String name, School school, Level level, SchoolYear schoolYear) {
        this.id = id;
        this.name = name;
        this.school = school;
        this.level = level;
        this.schoolYear = schoolYear;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    public SchoolYear getSchoolYear() {
        return schoolYear;
    }

    public void setSchoolYear(SchoolYear schoolYear) {
        this.schoolYear = schoolYear;
    }
}
