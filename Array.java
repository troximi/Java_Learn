public class Array {
    public static void main(String[] args) throws Exception {

        System.out.println("hi coders this is my array ");
        int[] numbers = {5,10,15,20,25 ,30,35,40,45,50,};

        System.out.println("elemments in array");

        for (int i = 0; i < numbers.length; i++) {
            System.out.println("elemment at index_" + i + ": " + numbers[i]);
        }

        int sum = 0;

        for (int i = 0; i < numbers.length; i++) {
            sum += numbers[i];
        }
        System.out.println("Sum of all elements in array is :" + sum );

    }
}
