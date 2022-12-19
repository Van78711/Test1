package show.input_data;

import program.AcademicSubject;
import program.EducationalProgram;
import teacher.Teacher;

import java.util.ArrayList;
import java.util.List;

public class Data {

    private List<Teacher> teachers;

    private List<EducationalProgram> programs;

    public Data() {
        this.teachers = new ArrayList<>();
        this.programs = new ArrayList<>();
    }

    public void addTeacher(String[][] table){
        for (String[] t:table) {
            if(t[0].trim().length() == 0 || t[1].trim().length() == 0)
                continue;
            Teacher teacher = new Teacher(t[0].trim(), t[1].trim());
            boolean f = true;
            for (Teacher tea:teachers) {
                if(tea.equals(teacher)){
                    f = false;
                    break;
                }
            }
            if(f){
                teachers.add(teacher);
            }
        }
    }

    public void addProgram(String[][] table, int course, int group){
        if(course < 1 || group < 1)
            return;

        for (String[] t:table) {
            if(t[0].trim().length() == 0 || t[1].trim().length() == 0)
                continue;

            int indexProgram = -1;
            for (int i = 0; i < programs.size(); i++) {
                EducationalProgram ep = programs.get(i);
                if(ep.getCourse() == course && ep.getGroup() == group){
                    indexProgram = i;
                    break;
                }
            }
            if(indexProgram == -1){
                programs.add(new EducationalProgram(course, group));
                indexProgram = programs.size() - 1;
            }
            EducationalProgram ep = programs.get(indexProgram);

            int indexAS = -1;

            for (int i = 0; i < ep.getSubjects().size(); i++) {
                AcademicSubject as = ep.getSubjects().get(i);
                if(as.getTitle().equals(t[0].trim())){
                    indexAS = i;
                    break;
                }
            }

            if(indexAS == -1){
                programs.get(indexProgram).getSubjects().add(new AcademicSubject(t[0].trim(), Integer.parseInt(t[1].trim())));
            }else {
                programs.get(indexProgram).getSubjects().get(indexAS).setCount(
                        programs.get(indexProgram).getSubjects().get(indexAS).getCount()+
                        Integer.parseInt(t[1].trim()));
            }

        }
    }
    public void show() {
        System.out.println("TEACHER");
        System.out.println(teachers);
        System.out.println();
        System.out.println("EDUCATION");

        for (EducationalProgram ep : programs) {
            System.out.println(ep.getCourse() + " - " + ep.getGroup());

            System.out.println(ep.getSubjects());
            System.out.println("____________________________________");
        }
    }

    public List<Teacher> getTeachers() {
        return teachers;
    }

    public String[][] getTableTeachers(){
        String[][] s = new String[teachers.size()][2];

        for (int i = 0; i < teachers.size(); i++) {
            s[i][0] = teachers.get(i).getName();
            s[i][1] = teachers.get(i).getTitle();
        }
        return s;
    }

    public void setTeachers(List<Teacher> teachers) {
        this.teachers = teachers;
    }

    public List<EducationalProgram> getPrograms() {
        return programs;
    }

    public void setPrograms(List<EducationalProgram> programs) {
        this.programs = programs;
    }
}
