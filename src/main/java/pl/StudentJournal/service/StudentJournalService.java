package pl.StudentJournal.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.StudentJournal.sorting.SortStudent;
import pl.StudentJournal.entity.Student;
import pl.StudentJournal.repository.StudentJournalDAORepository;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class StudentJournalService {


    private final StudentJournalDAORepository studentJournalDAORepository;


    public StudentJournalService(StudentJournalDAORepository studentJournalDAORepository) {
        this.studentJournalDAORepository = studentJournalDAORepository;
    }


    public void addUpdateStudentToDataBase(Student student) {
        studentJournalDAORepository.save(student);
    }

    public Optional<Student> getStudent(Long id) {

        return studentJournalDAORepository.findById(id);
    }

    public void deleteStudentFromDataBase(Long id) {
        studentJournalDAORepository.deleteById(id);
    }


    public List<Student> showAllStudentsFromDataBase() {
        List<Student> studentList = (List<Student>) studentJournalDAORepository.findAll();
        //studentList.sort(new SortStudent());
        studentList.sort(Comparator.comparing(Student::getSurname));
        return studentList;
    }
}