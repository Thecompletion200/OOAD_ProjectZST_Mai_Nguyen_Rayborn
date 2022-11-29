package src;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class Command {

    public boolean login(String userInput) throws FileNotFoundException, IOException{

        try (BufferedReader br = new BufferedReader(new FileReader("src/userData/users.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                // process the line. If we find that the user has a valid user/pass, grant access
                if(userInput.equals(line)){
                    System.out.println("Login Attempt Successful!");
                    return true;
                }
            }
        }
        System.out.println("Login Attempt Unsuccessful!");
        return false;
    }

    public boolean createAccount(String userName, String password) throws FileNotFoundException, IOException{
        
        // Does the account already exist?
        try (BufferedReader br = new BufferedReader(new FileReader("src/userData/users.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                // process the line. If we find that the user has a valid user/pass, the user already has an account
                if(line.contains(userName)){
                    System.out.println("Oops! It looks like a user with this name already exist. Please choose a different username.");
                    return false;
                }
            }
        }

        // If the account doesn't exist, add it to the userList
        try {
            FileWriter fileWriter = new FileWriter("src/userData/users.txt", true);
            fileWriter.write("\n" + userName + password);
            fileWriter.close();
            System.out.print("Congradulations! Your account has been created!");
            return true;
        } catch (IOException e){
            System.out.println("Logger: An error has occured in writing your file");
        }
        
        return false;
    }
    
    public Heroes createCharacter(String characterTypeOption){
        switch(characterTypeOption){
            case "1":
                return new Knight();
            case "2":
                return new Archer();
            case "3":
                return new Rogue();
            case "4":
                return new Mage();
            case "5":
                return new Priest();
            default:
                return null;
        }
    }

    public Heroes loadData(String userInput, Heroes advHero) throws FileNotFoundException, IOException{

        Load load = new Load();

        try (BufferedReader br = new BufferedReader(new FileReader("src/userData/" + userInput + ".txt"))) {
            String line;
            int count = 0;
            while ((line = br.readLine()) != null) {
                count+=1;
                // process the line. If we find that the user has a valid user/pass, grant access
                switch(count){
                    case 1:
                        advHero = load.hero(line);
                    case 2:
                        // do something
                    case 3:
                        load.weapon(advHero, line);
                        System.out.println(advHero);
                    default:
                        //do nothing

                }

            }
            return advHero;
        }
    }
}
