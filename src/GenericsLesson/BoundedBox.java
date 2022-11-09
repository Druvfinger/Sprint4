package GenericsLesson;

public class BoundedBox <T extends  String> {

    private T content;

    public T getContent() {
        return content;
    }

    public void setContent(T content) {
        this.content = content;
    }

    public static void main(String[] args) {
        BoundedBox<String> stringBox = new BoundedBox<>();
        stringBox.setContent("hej");


    }
}
