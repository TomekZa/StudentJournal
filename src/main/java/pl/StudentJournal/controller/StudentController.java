package pl.StudentJournal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pl.StudentJournal.entity.Student;
import pl.StudentJournal.service.StudentJournalService;


import java.util.ArrayList;
import java.util.Optional;


@Controller
public class StudentController {

    @Autowired
    private StudentJournalService studentJournalService;


    @RequestMapping(value = "/add-student", method = RequestMethod.GET)
    public String showForm(Model model) {
        model.addAttribute("student", new Student());

        return "add-student";
    }


    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String addStudentToJournalDataBase(Student student) throws Exception {
        studentJournalService.addUpdateStudentToDataBase(student);

        return "redirect:/add-student";
    }

    @RequestMapping(value = "/edit-student", method = RequestMethod.GET)
    public String showFormStudent(@ModelAttribute(value = "student") Student student) throws Exception {

        return "edit-student";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String updateStudentToJournalDataBase(@PathVariable(value = "id") Long id, Model model) throws Exception {
        Optional<Student> student = studentJournalService.getStudent(id);
        model.addAttribute("student", student);

        return "edit-student";
    }

    @RequestMapping(value = "/edit-save-student", method = RequestMethod.POST)
    public String updateStudentToJournalDataBase(@ModelAttribute(value = "student") Student student) throws Exception {
        studentJournalService.addUpdateStudentToDataBase(student);

        return "redirect:/edit-student";

    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteStudentFromJournalDataBase(@PathVariable(value = "id") Long id) throws Exception {
        studentJournalService.deleteStudentFromDataBase(id);

        return "redirect:/students";
    }

    @RequestMapping(value = "/students", method = RequestMethod.GET)
    public String showAllStudentFromDataBase(@ModelAttribute("student") ArrayList<Student> list, Model model) throws Exception {
        model.addAttribute("allStudents", studentJournalService.showAllStudentsFromDataBase());

        return "students";
    }
}
