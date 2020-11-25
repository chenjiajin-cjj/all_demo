package chenjiajin.springs.domain;

public class Video {

    private int id;
    private String title;

    public Video( String title) {
        System.out.println("入参构造");
        this.title = title;
    }
    public Video() {
        System.out.println("无参构造");
    }

    @Override
    public String toString() {
        return "Video{" +
                "id=" + id +
                ", title='" + title + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(final int id) {
        System.out.println("id setter");
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(final String title) {
        System.out.println("title setter");
        this.title = title;
    }
}
