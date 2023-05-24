import java.util.ArrayList;
import java.util.Scanner;
import models.*;
public class main
 {
    public static void main(String[] args) throws Exception {
        ArrayList<profile> profiles = new ArrayList<profile>();
        profile admin = new profile("admin1", "admin@admin.com", "123456");
        profiles.add(admin);
        Scanner leer = new Scanner(System.in);
        System.out.println("Hello");
        System.out.println("What you want to do?");
        System.out.println("1. Register");
        System.out.println("2. Login");
        System.out.println("3. Exit");
        int option = leer.nextInt();
        switch (option) {
            case 1:
                admin.register();
                break;
            case 2:
                profile logged = admin.login();
                System.out.println("Welcome " + logged.getName());
                System.out.println("This is all your information");
                logged.getName();
                logged.getEmail();
                logged.getPassword();
                break;
            case 3:
                System.out.println("Bye");
                break;
    }
}
}
