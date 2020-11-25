package chenjiajin.springs.domain;


public class VideoOrder {

    private int id;
    private Video video;

    public VideoOrder() {
    }

    public VideoOrder(final int id, final Video video) {
        this.id = id;
        this.video = video;
    }

    @Override
    public String toString() {
        return "VideoOrder{" +
                "id=" + id +
                ", video=" + video +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(final int id) {
        this.id = id;
    }

    public Video getVideo() {
        return video;
    }

    public void setVideo(final Video video) {
        this.video = video;
    }
}
