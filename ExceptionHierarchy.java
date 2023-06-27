import java.util.Scanner;

class ApplicationException extends Exception {

    public ApplicationException(String message) {
        super(message);
    }
}

class NumberIsTooSmallException extends ApplicationException {

    public NumberIsTooSmallException(String message) {
        super(message);
    }
}

class NumberIsTooBigException extends ApplicationException {

    public NumberIsTooBigException(String message) {
        super(message);
    }
}

class NotANumberException extends ApplicationException {

    public NotANumberException(String message) {
        super(message);
    }
}

public class ExceptionHierarchy {

    public static void main(String[] args) throws NotANumberException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a number: ");
        String input = scanner.nextLine();

        try {
            int number = Integer.parseInt(input);

            if (number < 0) {
                throw new NumberIsTooSmallException("Number is too small.");
            } else if (number > 10) {
                throw new NumberIsTooBigException("Number is too big.");
            }

            System.out.println("The number is: " + number);
        } catch (NumberFormatException e) {
            throw new NotANumberException("Input is not a number.");
        } catch (ApplicationException e) {
            System.out.println(e.getMessage());
        }
    }
}

