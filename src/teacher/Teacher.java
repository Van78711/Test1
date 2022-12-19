package teacher;

import java.time.DayOfWeek;
import java.util.Objects;

public class Teacher {
    private String name;
    private String title;

    public Teacher(String name, String title) {
        this.name = name;
        this.title = title;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Teacher teacher = (Teacher) o;
        return Objects.equals(name, teacher.name) && Objects.equals(title, teacher.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, title);
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "name='" + name + '\'' +
                ", title='" + title + '\'' +
                '}'+"\n";
    }
}
