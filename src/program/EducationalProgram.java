package program;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class EducationalProgram {

    private int course;
    private int group;
    private List<AcademicSubject> subjects;

    public EducationalProgram(int course, int group, List<AcademicSubject> subjects) {
        this.course = course;
        this.group = group;
        this.subjects = subjects;
    }

    public EducationalProgram(int course, int group) {
        this.course = course;
        this.group = group;
        this.subjects = new ArrayList<>();
    }

    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    public int getGroup() {
        return group;
    }

    public void setGroup(int group) {
        this.group = group;
    }

    public List<AcademicSubject> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<AcademicSubject> subjects) {
        this.subjects = subjects;
    }

    public int avgCoutClasses(int days){
        int c = 0;
        for (AcademicSubject s:subjects) {
            c+=s.getCount();
        }
        return (int) Math.ceil(c/days);
    }
}
