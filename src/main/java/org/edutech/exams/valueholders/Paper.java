package org.edutech.exams.valueholders;


import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Table(name = "paper")
public class Paper {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "abrev")
    private String abrev;
    @Column(name = "paper_name")
    private String paperName;
    @ManyToOne
    @JoinColumn(name = "exam_student_id")
    private ExamStudent examStudent;
    @OneToMany(mappedBy = "paper", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Marks> marks;
  
    
     public Paper(){}

     public int getId() {
         return id;
     }

     public void setId(int id) {
         this.id = id;
     }



     public String getPaperName() {
         return paperName;
     }

     public void setPaperName(String paperName) {
         this.paperName = paperName;
     }

     public ExamStudent getExamStudent() {
         return examStudent;
     }

     public void setExamStudent(ExamStudent examStudent) {
         this.examStudent = examStudent;
     }

     public   Set<Marks> getMarks() {
         return marks;
     }

     public void setMarks(Set<Marks> marks) {
         this.marks = marks;
     }


     public String getAbrev() {
         return abrev;
     }

     public void setAbrev(String abrev) {
         this.abrev = abrev;
     }

     

 

     


    
}
