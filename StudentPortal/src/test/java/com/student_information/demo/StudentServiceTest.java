package com.student_information.demo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.student_information.demo.model.Student;
import com.student_information.demo.repository.StudentRepository;
import com.student_information.demo.service.StudentService;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StudentServiceTest {

    @Autowired
    private StudentService studentService;

    @MockBean
    private StudentRepository studentRepository;

    private Student student1;
    private Student student2;

    private final Long student1StudentNumber = 23L;
    private final Long student2StudentNumber = 91L;
    private final String student1Email = "student1@rg.com";
    private final String student2Email = "student2@ygt.com";
    private final List<Student> students = new ArrayList<>();

    @Before
    public void setup() {
        student1 = new Student();
        student1.setId("aBc123");
        student1.setName("student1");
        student1.setEmail(student1Email);
        student1.setStudentNumber(student1StudentNumber);
        student1.setCourseList(Arrays.asList("Math", "Science"));
        student1.setGpa(3.37f);

        student2 = new Student();
        student2.setId("dEf345");
        student2.setName("student2");
        student2.setEmail(student2Email);
        student2.setStudentNumber(student2StudentNumber);
        student2.setCourseList(Arrays.asList("Turkish", "German"));
        student2.setGpa(3.58f);

        students.add(student1);
        students.add(student2);

        Mockito.when(studentRepository.findAll()).thenReturn(students);

        Mockito.when(studentRepository.findByStudentNumber(student1StudentNumber))
                .thenReturn(student1);

        Mockito.when(studentRepository.findByEmail(student2Email))
                .thenReturn(student2);

        /*Mockito.when(studentRepository.findAllByOrderByGpaDesc())
                .thenReturn(students.stream().sorted(
                        Comparator.comparing(Student::getGpa).reversed()).collect(Collectors.toList()));*/

        Mockito.when(studentRepository.save(student1)).thenReturn(student1);
    }


    @Test
    public void testFindAll_thenStudentListShouldBeReturned() {
        List<Student> foundStudents = studentService.findAll();

        assertNotNull(foundStudents);
        assertEquals(2, foundStudents.size());
    }

    @Test
    public void testFindByStudentNumber23_thenstudent1ShouldBeReturned() {
        Student found = studentService.findByStudentNumber(student1StudentNumber);

        assertNotNull(found);
        assertEquals(student1.getName(), found.getName());
        assertEquals(student1.getId(), found.getId());
    }

    @Test
    public void testFindByEmail_thenYigitShouldBeReturned() {
        Student found = studentService.findByEmail(student2Email);

        assertNotNull(found);
        assertEquals(student2.getName(), found.getName());
        assertEquals(student2.getId(), found.getId());
    }
    
    
}