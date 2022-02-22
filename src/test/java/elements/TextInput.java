package elements;

public interface TextInput extends Element {

    void clear();

    void write(String text);

    void clearAndWrite(String text);
}
