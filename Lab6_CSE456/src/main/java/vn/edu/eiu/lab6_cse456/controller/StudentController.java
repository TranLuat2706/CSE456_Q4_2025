package vn.edu.eiu.lab6_cse456.controller;

import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import vn.edu.eiu.lab6_cse456.config.InitStudent;
import vn.edu.eiu.lab6_cse456.entity.Student;

import java.util.Iterator;
import java.util.List;

@Controller  //xử lý và trả về 1 trang web html vs tính năng tương ứng
public class StudentController {
    private final InitStudent initStudent;

    @Autowired
    public StudentController(InitStudent initStudent) {
        this.initStudent = initStudent;
    }

//    @GetMapping("/")
//    public String index() {
//        return "index";
//    }

    //show all students with url localhost:8080/student-list
    @GetMapping("/students")
    public String showStudents(Model model) {
        List<Student> students = initStudent.getStudents();
        model.addAttribute("students", students);
        return "student-list";
    }

    @GetMapping("students/edit/{id}")
    public String editStudentForm(@PathVariable int id, Model model) {
        for(Student foundStudent : initStudent.getStudents()) {
            if(foundStudent.getId()==id){
                model.addAttribute("student", foundStudent);
                break;
            }
        }
        return "student-form";
    }

//    @PostMapping("/students/edit/result")
//    public String saveStudent(@RequestParam("id") int id, @RequestParam("name")  String name, @RequestParam("yob") int yob
//    , @RequestParam("gpa") double gpa, Model model) {
//        model.addAttribute("msg", "The student has been saved successfully!");
//        model.addAttribute("id", id);
//        model.addAttribute("name", name);
//        model.addAttribute("yob", yob);
//        model.addAttribute("gpa", gpa);
//        return "result";
//    }

//    // dùng redỉect để tránh lỗi (version 2)
//    @PostMapping("/students/edit")
//    public String saveStudent(@RequestParam("id") int id, @RequestParam("name")  String name, @RequestParam("yob") int yob
//    , @RequestParam("gpa") double gpa, RedirectAttributes redirectAtt) {
//        redirectAtt.addFlashAttribute("msg", "The student has been saved successfully!");
//        redirectAtt.addFlashAttribute("id", id);
//        redirectAtt.addFlashAttribute("name", name);
//        redirectAtt.addFlashAttribute("yob", yob);
//        redirectAtt.addFlashAttribute("gpa", gpa);
//        return "redirect:/students/edit/result";
//    }
//
//    @GetMapping("/students/edit/result")
//    public String showResult(Model model) {
//        return "result";
//    }

    // version 3
    @PostMapping("/students/edit")
    public String updateStudent(@RequestParam("id") int id, @RequestParam("name")  String name, @RequestParam("yob") int yob
    , @RequestParam("gpa") double gpa, RedirectAttributes redirectAtt) {
        redirectAtt.addFlashAttribute("pmsg", "The student has been saved successfully!");
        redirectAtt.addFlashAttribute("pid", id);
        redirectAtt.addFlashAttribute("pname", name);
        redirectAtt.addFlashAttribute("pyob", yob);
        redirectAtt.addFlashAttribute("pgpa", gpa);
        return "redirect:/students";
    }

    @GetMapping("/students/new")
    public String createStudentForm(Model model) {
        model.addAttribute("student", new Student());
        return "student-form";
    }

    @PostMapping("/students/new")
    public String saveStudent(@ModelAttribute Student student, RedirectAttributes redirectAtt) {
        initStudent.save(student);
        redirectAtt.addFlashAttribute("pmsg", "A student has been created successfully!");
        return "redirect:/students";
    }

    @GetMapping("/students/delete/{id}")
    public String deleteStudent(@PathVariable int id, RedirectAttributes redirectAtt) {
        Iterator<Student> iterator = initStudent.getStudents().iterator();
        while (iterator.hasNext()) {
            if (iterator.next().getId() == id) {
                iterator.remove();
                redirectAtt.addFlashAttribute("pmsg", "Student deleted successfully!");
                break;
            }
        }
        return "redirect:/students";
    }
}
