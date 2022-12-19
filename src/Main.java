import program.AcademicSubject;
import program.EducationalProgram;
import schedule.Generate;
import selection.Selection;
import show.Frame;
import show.util.SwingUtils;
import teacher.Teacher;
import teacher.TeacherSchedule;

import java.time.DayOfWeek;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        /*List<AcademicSubject> as1 = new ArrayList<>();
        as1.add(new AcademicSubject("math", 2));
        as1.add(new AcademicSubject("rus", 2));
        as1.add(new AcademicSubject("phy", 10));
        as1.add(new AcademicSubject("eng", 2));

        List<AcademicSubject> as2 = new ArrayList<>();
        as2.add(new AcademicSubject("math", 2));
        as2.add(new AcademicSubject("rus", 2));
        as2.add(new AcademicSubject("phy", 10));
        as2.add(new AcademicSubject("eng", 2));


        EducationalProgram ep1 = new EducationalProgram(1, 1, as1);
        EducationalProgram ep2 = new EducationalProgram(1, 2, as2);

        List<EducationalProgram> programs = new ArrayList<>();
        programs.add(ep1);
        programs.add(ep2);

        List<Teacher> teachers = List.of(
                new Teacher("p1", "math"),
                new Teacher("p2", "rus"),
                new Teacher("p3", "phy"),
                new Teacher("p4", "eng"),
                new Teacher("p5", "math"),
                new Teacher("p6", "rus"),
                new Teacher("p7", "phy"),
                new Teacher("p8", "eng")
        );
        List<TeacherSchedule> l = Generate.getTeacherSchedule(programs, teachers);
        System.out.println(l.size());

        Collections.sort(l, new Comparator<TeacherSchedule>() {
            @Override
            public int compare(TeacherSchedule o1, TeacherSchedule o2) {
                return o1.getDay().compareTo(o2.getDay());
            }
        });


        System.out.println("g = 1    k = 1");
        List<TeacherSchedule> r = Selection.byGroupCourse(l, 1, 1);

        for (int i = 1; i < 7; i++) {
            System.out.println(DayOfWeek.of(i));
            List<TeacherSchedule> w = Selection.byDay(r, DayOfWeek.of(i));
            for (TeacherSchedule t:w) {
                System.out.println("    "+t.getCount()+" : "+t.getCouple().getTitle() +" -> "+t.getTeacher().getName());
            }
            System.out.println();

        }
        System.out.println("____________________________");
        System.out.println("g = 2    k = 1");
        r = Selection.byGroupCourse(l, 1, 2);

        for (int i = 1; i < 7; i++) {
            System.out.println(DayOfWeek.of(i));
            List<TeacherSchedule> w = Selection.byDay(r, DayOfWeek.of(i));
            for (TeacherSchedule t:w) {
                System.out.println("    "+t.getCount()+" : "+t.getCouple().getTitle() +" -> "+t.getTeacher().getName());
            }
            System.out.println();

        }*/

        Locale.setDefault(Locale.ROOT);
        //UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        SwingUtils.setDefaultFont("Microsoft Sans Serif", 18);

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Frame().setVisible(true);
            }
        });
    }
}
