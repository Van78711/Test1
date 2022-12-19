package program;

import java.util.Objects;

public class AcademicSubject {
    private String title;
    private int count;


    public AcademicSubject(String title, int count) {
        this.title = title;
        this.count = count;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AcademicSubject that = (AcademicSubject) o;
        return count == that.count && Objects.equals(title, that.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, count);
    }

    @Override
    public String toString() {
        return "AcademicSubject{" +
                "title='" + title + '\'' +
                ", count=" + count +
                '}'+"\n";
    }
}
