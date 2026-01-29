package main.java.com.example;

public class App {

    public static void main(String[] args) throws Exception {
    Calculator calc = new Calculator();
    // Use a valid operation
    System.out.println(calc.calculate(10, 5, "add"));

    UserService service = new UserService();
    service.findUser("admin");

    String usernameToDelete = "user1"; // avoid hardcoding admin
    if (!usernameToDelete.equals("admin")) {
        service.deleteUser(usernameToDelete);
    } else {
        System.out.println("Cannot delete admin user!");
    }
}

}

