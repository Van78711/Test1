package schedule;

import couple.Couple;
import program.AcademicSubject;
import program.EducationalProgram;
import services.EducationService;
import teacher.Teacher;
import teacher.TeacherSchedule;

import java.time.DayOfWeek;
import java.util.*;

public class Generate {

    public static List<TeacherSchedule> getTeacherSchedule(List<EducationalProgram> programs, List<Teacher> teachers){
        List<TeacherSchedule> schedule = new ArrayList<>();
        while (!isEmpty(programs)){
            for (int j = 0; j < programs.size(); j++) {
                EducationalProgram p = programs.get(j);
                if(p.getSubjects().isEmpty())
                    continue;
                for (int i = 1; i <= 6; i++) {
                    TeacherSchedule ts = getCouple(p, DayOfWeek.of(i), schedule, teachers);
                    if (ts == null)
                        continue;
                    schedule.add(ts);
                }
            }
        }

        return schedule;
    }

    public static TeacherSchedule getCouple(EducationalProgram p,  DayOfWeek d, List<TeacherSchedule> schedule, List<Teacher> teachers){
        for (AcademicSubject as:p.getSubjects()) {
            List<Integer> notFiledCouple = getNotFiledCouple(7);
            System.out.println(schedule);

            for (TeacherSchedule ts:schedule) {
                if(ts.getDay().equals(d) && ts.getCouple().getGroup() == p.getGroup() && ts.getCouple().getCourse() == p.getCourse()){

                    notFiledCouple.remove((Object)ts.getCount());
                }
            }
            //System.out.println(notFiledCouple);
            if(!notFiledCouple.isEmpty()){
                for (Integer i:notFiledCouple) {
                    //System.out.println(as.getTitle());
                    List<Teacher> freeTeachers = getFreeTeacher(getBusyTeacher(schedule, as.getTitle(), d, i), teachers, as.getTitle());
                    //System.out.println(freeTeachers);
                    if(freeTeachers.isEmpty())
                        continue;

                    TeacherSchedule ts = new TeacherSchedule(d, new Couple(as.getTitle(), p.getCourse(), p.getGroup()), freeTeachers.get(0), i);
                    EducationService.changeHours(p, as.getTitle(), -1);
                    return ts;
                }
            }
        }
        return null;

    }

    private static List<Integer> getNotFiledCouple(int n){
        List<Integer> notFiled = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            notFiled.add(i);
        }
        return notFiled;
    }

    private static List<Teacher> getNotFiledTeacher(List<TeacherSchedule> schedule, List<Teacher> teachers, List<Integer> count){
        List<Teacher> l = new ArrayList<>();
        for (Teacher t:teachers) {
            l.add(new Teacher(t.getName(), t.getTitle()));
        }
        return l;
    }
    private static List<Teacher> getTeacherByTitle(List<Teacher> teachers, String title){
        List<Teacher> ts = new ArrayList<>();
        for (Teacher t:teachers) {
            if(t.getTitle().equals(title))
                ts.add(t);
        }
        return ts;
    }

    private static List<Teacher> getBusyTeacher(List<TeacherSchedule> schedule, String title, DayOfWeek d, int count){
        List<Teacher> t = new ArrayList<>();
        for (TeacherSchedule ts:schedule) {
            if(ts.getCount() == count && ts.getDay().equals(d) && ts.getCouple().getTitle().equals(title) && !t.contains(ts.getTeacher()))
                t.add(ts.getTeacher());
        }
        return t;
    }

    private static List<Teacher> getFreeTeacher(List<Teacher> busy, List<Teacher> full, String title){
        List<Teacher> l = new ArrayList<>();

        for (Teacher t:full) {
            if(!busy.contains(t) && t.getTitle().equals(title))
                l.add(t);
        }
        return l;
    }

    /*public static List<Teacher> getFreeTeachers(List<TeacherSchedule> schedule, DayOfWeek d, AcademicSubject s, int count){
        for (TeacherSchedule ts:schedule) {
            if(ts.getD() == d){


            }
        }
    }*/

    public static boolean isEmpty(List<EducationalProgram> programs){

        for (EducationalProgram p:programs) {
            if(!p.getSubjects().isEmpty())
                return false;
        }
        return true;
    }
}
