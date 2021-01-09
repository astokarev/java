package lesson10;

public class Main {
    private static final int SIZE_LIMIT = 4;
    public static void main(String[] args) {
        try {
            arraySum(new String[][]{{"0","0","0","0"},{"0","0","0","0"},{"0","0","0","0"},{"0","0","0","0"}});
        } catch (ArraySizeException | ArrayDataException e){
            System.out.println(e);
        }
        try {
            arraySum(new String[][]{{"0","0","0","0"},{"0","0","0","0"},{"0","0","0","0"},{}});
        } catch (ArraySizeException | ArrayDataException e){
            System.out.println(e);
        }
        try {
            arraySum(new String[][]{{"1","1","1","azaz"},{"1","qwe","0","0"},{"0","asf","0","0"},{"0","0","dfg","0"}});
        } catch (ArraySizeException | ArrayDataException e){
            System.out.println(e);
        }
    }

    public static int arraySum(String[][] array) throws ArraySizeException, ArrayDataException{
        if(array.length != SIZE_LIMIT){
            throw new ArraySizeException();
        }
        for (String[] strings : array){
            if (strings.length != SIZE_LIMIT){
                throw new ArraySizeException();
            }
        }
        int resultArray = 0;
        for (int i = 0; i < SIZE_LIMIT; i++){
            for (int j=0; j< SIZE_LIMIT; j++){
                try{
                    resultArray += Integer.parseInt(array[i][j]);
                } catch (NumberFormatException e){
                    throw new ArrayDataException(i,j);
                }
            }
        }
        return resultArray;
    }
}
