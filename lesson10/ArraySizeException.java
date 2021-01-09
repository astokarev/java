package lesson10;

public class ArraySizeException extends Throwable {
    public ArraySizeException(){
        super("Array is out of range!");
    }
}
