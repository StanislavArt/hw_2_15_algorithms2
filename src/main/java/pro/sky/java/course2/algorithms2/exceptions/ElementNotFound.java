package pro.sky.java.course2.algorithms2.exceptions;

public class ElementNotFound extends RuntimeException {
    public ElementNotFound() {
        super("Элемнт не найден");
    }
}
