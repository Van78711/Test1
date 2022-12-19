package couple;

import teacher.Teacher;

public class Couple {
    private String title;
    private int group;
    private int course;

    public Couple(String title, int course, int group) {
        this.title = title;
        this.group = group;
        this.course = course;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getGroup() {
        return group;
    }

    public void setGroup(int group) {
        this.group = group;
    }

    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    @Override
    public String toString() {
        return "Couple{" +
                "title='" + title + '\'' +
                ", group=" + group +
                ", course=" + course +
                '}';
    }
}
