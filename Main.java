public class Main {
    public static void main(String[] args) {

        Box<Apple> appleBox = new Box<>();
        Box<Orange> orangeBox = new Box<>();
        Box<Apple> appleBox1 = new Box<>();
        for (int i = 0; i < 5; i++) {
            appleBox.addFruit(new Apple());
            appleBox1.addFruit(new Apple());
            orangeBox.addFruit(new Orange());
        }
        System.out.println("Вес коробки яблок: " + appleBox.getWeight());
        System.out.println("Вес коробки апельсинов: " + orangeBox.getWeight());
        System.out.println("Сравнение двух коробок с яблоками: "+appleBox.compare(appleBox1));
        System.out.println("Сравнение апельсинов с яблоками: "+ orangeBox.compare(appleBox));
        //Соединяем яблоки с яблоками
        appleBox.join(appleBox1);
        // пытаемся яблоки с апельсинами
        appleBox.join(orangeBox);
        // итоговый вес корзины с яблоками
        System.out.println(appleBox.getWeight());
    }
}
