package exception;

public class ShowException {

    public static void showNotice(Exception e) {
        System.out.println("Exception message: " + e.getMessage());
        System.out.println("Exception stack trace: ");
        e.printStackTrace();
    }

}
