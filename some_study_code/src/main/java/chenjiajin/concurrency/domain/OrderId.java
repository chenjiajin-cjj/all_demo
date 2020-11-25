package chenjiajin.concurrency.domain;

import java.util.Map;
import java.util.concurrent.CompletableFuture;

public class OrderId {

    private String id;

    CompletableFuture<Map<String, Object>> future;

    public CompletableFuture<Map<String, Object>> getFuture() {
        return future;
    }

    public void setFuture(CompletableFuture<Map<String, Object>> future) {
        this.future = future;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                ", future=" + future +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}
