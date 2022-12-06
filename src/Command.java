package src;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.Scanner;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.TitlePaneLayout;

public class Command {

    Scanner sc = new Scanner(System.in);

    public boolean login(String userInput) throws FileNotFoundException, IOException{

        try (BufferedReader br = new BufferedReader(new FileReader("src/userData/users.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                // process the line. If we find that the user has a valid user/pass, grant access
                if(userInput.equals(line)){
                    System.out.println("Login Attempt Successful!\n");
                    return true;
                }
            }
        }
        System.out.println("Login Attempt Unsuccessful!\n");
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
            System.out.print("Congratulations! Your account has been created!");
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

    public void viewHeroInventory(Heroes advHero){
        System.out.println("Hero: " + advHero.getHeroName());
        System.out.println("---------------------------------");
        System.out.println("Loaction: " + advHero.getLocationName());
        System.out.println("Level: " + advHero.getHeroLevel());
        System.out.println("Exp: " + advHero.getExp() + "/" + advHero.getHeroLevel()*10);
        System.out.println("Gold: " + advHero.getGold());
        System.out.println("Equiped Weapon: " + advHero.getWeapon());
        System.out.println("Equiped Armor: " + advHero.getArmor());
        advHero.getHeroInventory();

    }
    
    public void healHero(Heroes advHero){
        System.out.println("Would you like to heal your hero for " + advHero.getHeroLevel()*15 + " gold?\n1) Yes\n2) No");
        String userChoice;
        userChoice = sc.nextLine();
        if(userChoice.equals("1")){
            boolean p = advHero.purchase(advHero.getHeroLevel()*15);
            if(p){
                advHero.healHero();
            }
        }
        else{
            // do nothing
        }
    }
    
    public void loadShopFresh(Shop s){
        // Add potions
        // Add Weapons
        // Melee
        WoodenSword wSword = new WoodenSword();
        s.addToInventory(wSword);
        SteelSword sSword = new SteelSword();
        s.addToInventory(sSword);
        TitaniumSword tSword = new TitaniumSword();
        s.addToInventory(tSword);
        TungstenSword tungSword = new TungstenSword();
        s.addToInventory(tungSword);
        Knives knives = new Knives();
        s.addToInventory(knives);
        Kyokestu kyokestu = new Kyokestu();
        s.addToInventory(kyokestu);
        DualKatanas dKatanas = new DualKatanas();
        s.addToInventory(dKatanas);
        DragonsBlade dBlade = new DragonsBlade();
        s.addToInventory(dBlade);
        // Range
        WoodenBow wBow = new WoodenBow();
        s.addToInventory(wBow);
        LongBow lBow = new LongBow();
        s.addToInventory(lBow);
        JaguarStrike jaguarStrike = new JaguarStrike();
        s.addToInventory(jaguarStrike);
        Yumi yumi = new Yumi();
        s.addToInventory(yumi);
        // Magic
        WoodenStaff wStaff = new WoodenStaff();
        s.addToInventory(wStaff);
        SteelScepter steelScepter = new SteelScepter();
        s.addToInventory(steelScepter);
        GoldenScepter goldenScepter = new GoldenScepter();
        s.addToInventory(goldenScepter);
        BookofOmniscience bO = new BookofOmniscience();
        s.addToInventory(bO);
    }

    public void enterShop(Heroes advHero, Shop shop){
        String userChoice;
        boolean stay = true;
        System.out.println("Welcome to " + shop.getStoreName());
        while(stay){
            System.out.println("\n1) View Store Inventory\n2) Purchase Items\n3) Exit Shop");
            userChoice = sc.nextLine();
            switch(userChoice){
                case "1":
                    shop.getStoreInventory();
                    break;
                case "2":
                    System.out.println("What item would you like to purchase?");
                    userChoice = sc.nextLine();
                    Items bought = shop.getItemFromShelf(userChoice);
                    // If the item isn't found
                    if(bought == null){
                        System.out.println("Sorry that item is out of stock.");
                        break;
                    }
                    else{
                        Boolean p = advHero.purchase(bought.getItemCost());
                        // If the adv has enough money
                        if(p){
                            // Remove item from store
                            shop.removeFromInventory(bought);
                            // Add to adv inventory
                            advHero.addToHeroInventory(bought);
                            System.out.println("Item Bought Successfully!");
                        }
                        //advHeroes.purchase(null)
                    }
                    break;
                case "3":
                    System.out.println("Leaving...");
                    stay = false;
                default:
                    System.out.println("Sorry that was an invalid option.");
                    break;
            }
        }
        return;

    }
    public void displayOthersMapsMenu(){
        String userChoice;
        System.out.println("Approach Boss\nFight Monsters\nMove");
        userChoice = sc.nextLine();
        switch(userChoice){
            case "1":
                // do something
            case "2":
                // heal
            case "3":
                // move
            case "4":
            default:
                // do something;
        }
        // if("Approach Boss")
    }
}
