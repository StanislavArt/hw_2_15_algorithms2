package pro.sky.java.course2.algorithms2.exceptions;

public class InvalidArgument extends RuntimeException {
    public InvalidArgument() {
        super("Указан неверный аргумент");
    }
}
