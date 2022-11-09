package GenericsLesson;

public class Box <T>{

    private T content;

    public T getContent() {
        return content;
    }

    public void setContent(T content) {
        this.content = content;
    }

    public static void main(String[] args) {
        Box<String> stringBox = new Box<>();
        stringBox.setContent("hej");

        Box<Integer> intBox = new Box<>();
        intBox.setContent(5);

        Box<Box<Integer>> metaBox = new Box<>();
        metaBox.setContent(intBox);

    }
}
