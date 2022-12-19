package teacher;

import couple.Couple;

import java.time.DayOfWeek;
import java.util.Arrays;
import java.util.List;

public class TeacherSchedule {

    private DayOfWeek day;

    private Couple couple;

    private Teacher teacher;

    private int count;

    public TeacherSchedule(DayOfWeek day, Couple couple, Teacher teacher, int count) {
        this.day = day;
        this.couple = couple;
        this.teacher = teacher;
        this.count = count;
    }

    public DayOfWeek getDay() {
        return day;
    }

    public void setDay(DayOfWeek day) {
        this.day = day;
    }

    public Couple getCouple() {
        return couple;
    }

    public void setCouple(Couple couple) {
        this.couple = couple;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "count=" + count ;
    }
}
