package bai8;


class MyCustomException extends Exception {
    public MyCustomException(String message) {
        super(message);
    }
}
class CustomExceptionExample {
    public void performOperation(int value) throws MyCustomException {
        if (value < 0) {
            throw new MyCustomException("Giá trị không hợp lệ: " + value);
        } else {
            System.out.println("giá trị hợp lệ: " + value);
        }
    }
}
public class CustomException {
    public static void main(String[] args) {
        CustomExceptionExample example = new CustomExceptionExample();
        try {
            example.performOperation(-1);
            example.performOperation(10);
        } catch (MyCustomException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}

