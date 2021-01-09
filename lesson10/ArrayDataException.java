package lesson10;

public class ArrayDataException extends Throwable {
    public ArrayDataException(int i, int j){
        super("Can not convert to integer! Position: ["+i+"]["+j+"]");
    }
}
