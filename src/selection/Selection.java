package selection;

import teacher.TeacherSchedule;

import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.List;

public class Selection {

    public static List<TeacherSchedule> byGroupCourse(List<TeacherSchedule> l, int course, int group){
        List<TeacherSchedule> r = new ArrayList<>();

        for (TeacherSchedule ts:l) {
            if(ts.getCouple().getCourse() == course && ts.getCouple().getGroup() == group)
                r.add(ts);
        }
        return r;
    }
    public static List<TeacherSchedule> byDay(List<TeacherSchedule> l, DayOfWeek d){
        List<TeacherSchedule> r = new ArrayList<>();
        for (TeacherSchedule ts:l) {
            if(ts.getDay() == d)
                r.add(ts);
        }
        return r;
    }
}
