package finki.projects.schoolmanagementsystem181074.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Grade {

    @Id
    @GeneratedValue
    private Long id;

    //koj student za koj predmet ima koja ocena
}
