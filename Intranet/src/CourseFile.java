import java.io.Serializable;

public class CourseFile implements Serializable {
    private String title;
    private String text;
    private String owner;

    public CourseFile(String title, String text, String owner) {
        this.title = title;
        this.text = text;
        this.owner = owner;
    }

    public String getTitle() { return title; }

    public String getText() { return text; }

    @Override
    public String toString() {
        return "Course file\n" + title + "\n\n" + text + '\n';
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (!(obj instanceof CourseFile)) return false;
        CourseFile cf = (CourseFile) obj;
        return cf.title.equals(title) && cf.text.equals(text) && cf.owner.equals(owner);
    }

    @Override
    public int hashCode() { return title.hashCode(); }
}