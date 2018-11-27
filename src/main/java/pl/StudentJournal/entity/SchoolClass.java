package pl.StudentJournal.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "Klasy")
public class SchoolClass {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "ID")
    private Long id;

    @Column(name = "Klasa")
    private String nameClass;

    @Transient
    private String ignoreData;

    public SchoolClass() {
    }

    public SchoolClass(String nameClass) {
        this.nameClass = nameClass;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameClass() {
        return nameClass;
    }

    public void setNameClass(String nameClass) {
        this.nameClass = nameClass;
    }

    public String getIgnoreData() {
        return ignoreData;
    }

    public void setIgnoreData(String ignoreData) {
        this.ignoreData = ignoreData;
    }
}
