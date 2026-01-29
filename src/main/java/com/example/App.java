package main.java.com.example;

public class App {

    public static void main(String[] args) {
        Calculator calc = new Calculator();

        try {
            // Use a valid operation
            int result = calc.calculate(10, 5, "add");
            System.out.println(result);

            UserService service = new UserService();

            // Check user exists before operations
            if (service.findUser("admin") != null) {

                // Prevent deletion of critical users
                if (!"admin".equalsIgnoreCase("admin")) {
                    service.deleteUser("admin");
                } else {
                    System.out.println("Admin user cannot be deleted.");
                }
            } else {
                System.out.println("User not found.");
            }

        } catch (IllegalArgumentException e) {
            System.err.println("Invalid calculation operation: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Unexpected error: " + e.getMessage());
        }
    }
}


