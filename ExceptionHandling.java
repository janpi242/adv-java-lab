import java.util.Scanner;

class MyException extends Exception {

    private int number;

    public MyException(int number) {
        super("Number is even: " + number);
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}

public class ExceptionHandling {

    public static void main(String[] args) {

        String str = null;

        try {
            System.out.println(str.length());
        } catch (NullPointerException e) {
            System.out.println("Exception: " + e.getMessage());
            System.out.println("Stacktrace: ");
            e.printStackTrace();
        }



        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a number: ");
        int number = scanner.nextInt();

        try {
            if (number % 2 == 0) {
                throw new MyException(number);
            }

            System.out.println("The number is: " + number);
        } catch (MyException e) {
            System.out.println("Exception: " + e.getMessage());
            System.out.println("The number is: " + e.getNumber());
        } finally {
            System.out.println("And I always get called");
        }
    }
}
