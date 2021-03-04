package gui;

public class ItemData {
    private String text;
    private Object value;

    public ItemData(String text, String value) {
        this.text = text;
        this.value = value;
    }

    public Object getValue() {
        return value;
    }

    @Override
    public String toString() {
        return text;
    }
}
