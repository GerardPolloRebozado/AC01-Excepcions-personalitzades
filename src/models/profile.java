package models;

import java.util.ArrayList;
import java.util.Scanner;

import javax.naming.InvalidNameException;

public class profile {
    private String name;
    private String email;
    private String password;
    ArrayList<profile> profiles = new ArrayList<profile>();
    public profile(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }
    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    //Este metodo creara una excepcion cuando haya mail nombre o contraseña no validos

    public void register() throws invalidEmailException, invalidPasswordException, InvalidNameException {
        Scanner leer = new Scanner(System.in);
        System.out.println("Type your Name");
        String name = leer.nextLine();
        boolean error=false;
        do{
        try{
        if (name.length() < 3) {
            throw new invalidNameException("El nombre debe ser de mas de 3 caracteres");

        }else if (name.length() > 20) {
            throw new invalidNameException("El nombre debe ser de menos de 20 caracteres");
        }else if (name=="tuputamadre") {
            throw new invalidNameException("La tuya mas barata ponte otro nombre");
        }
        System.out.println("Type your Email");
        String email = leer.nextLine();
        if (email.contains("@")) {
        }else {
            throw new invalidEmailException("El email es invalido no tiene un @");
        }
        System.out.println("Type your Password");
        String password = leer.nextLine();
        if (password.length() < 8) {
            throw new invalidPasswordException("La contraseña debe ser de mas de 8 caracteres");
        }
        profile newProfile = new profile(name, email, password);
        profiles.add(newProfile);
    }catch (invalidEmailException e){
        System.out.println(e.getMessage());
    }catch (invalidPasswordException e){
        System.out.println(e.getMessage());
    }catch (invalidNameException e){
        System.out.println(e.getMessage());
    }catch(Exception e){
        System.out.println("Algo no ha ido como deberia");
    }
}while (error);
    }

    public profile login() throws invalidEmailException, invalidPasswordException {
        Scanner leer = new Scanner(System.in);
        System.out.println("Type your Email");
        String email = leer.nextLine();
        System.out.println("Type your Password");
        String password = leer.nextLine();
        for (int i = 0; i < profiles.size(); i++) {
            if (profiles.get(i).getEmail().equals(email)) {
                if (profiles.get(i).getPassword().equals(password)) {
                    System.out.println("Welcome " + profiles.get(i).getName());
                    return profiles.get(i);
                }else {
                    throw new invalidPasswordException("Contraseña incorrecta");
                }
            }else {
                throw new invalidEmailException("Email incorrecto");
            }
        }
        return null;
    }
}
