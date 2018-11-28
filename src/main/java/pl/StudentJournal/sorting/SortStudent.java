package pl.StudentJournal.sorting;

import pl.StudentJournal.entity.Student;

import java.util.Comparator;

public class SortStudent implements Comparator<Student> {
    @Override
    public int compare(Student student1, Student student2) {

        return student1.getSurname().compareTo(student2.getSurname());
    }
}
