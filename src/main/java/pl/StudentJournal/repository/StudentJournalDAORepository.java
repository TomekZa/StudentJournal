package pl.StudentJournal.repository;

import org.springframework.data.repository.CrudRepository;
import pl.StudentJournal.entity.Student;


public interface StudentJournalDAORepository extends CrudRepository<Student, Long> {
}
