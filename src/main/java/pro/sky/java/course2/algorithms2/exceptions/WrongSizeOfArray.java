package pro.sky.java.course2.algorithms2.exceptions;

public class WrongSizeOfArray extends RuntimeException {
    public WrongSizeOfArray() {
        super("Неверный размер массива");
    }
}
