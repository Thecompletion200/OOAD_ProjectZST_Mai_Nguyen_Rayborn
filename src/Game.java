package src;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Container;
import java.io.IOException;
// import java.security.spec.EdDSAParameterSpec;
// import java.awt.Color;
import java.util.ArrayList;
import java.util.Scanner;
// import java.util.Set;

public class Game {

    JFrame window;
    Container con;
    JPanel titleNamePanel;

    public static void main(String[] args) throws IOException, InterruptedException {
        
        // Initialize Game
        // Objects
        Game game = new Game();
        monsterFactory MonsterFac = new monsterFactory();
        Command command = new Command();
        Scanner sc = new Scanner(System.in);
        SaveLoad saveLoad = new SaveLoad();

        // Maps
        Maps elden = new Elden();
        Maps fiji = new Fiji();
        // Maps redsea = new RedSea();
        // Maps firelinkshrine = new FireLinkShrine();
        // Maps indicapower = new Indicapower();
        // Maps sativatoff = new Sativatoff();
        Shop eldenShop = new Shop();

        // // Add maps to all maps list
        ArrayList<Maps> allMaps = new ArrayList<Maps>();
        allMaps.add(elden);
        allMaps.add(fiji);
        // allMaps.add(redsea);
        // allMaps.add(firelinkshrine);
        // allMaps.add(indicapower);
        // allMaps.add(sativatoff);

        // Game class variables
        String userChoice;
        String userName;
        String loginInfo;
        String newUsername = "";
        String newPassword;
        boolean access = false;
        boolean hasAccount = false;
        Monster currMonster = null;
        Heroes advHero = null;


        // // TESTING
        // Heroes testHero = new Knight();
        // Items sword = new Sword();
        // Items armor = new Armor();
        // Monster testMonster = MonsterFac.spawnBandit();
        // System.out.print(testMonster.getMonsterName());
        // //game.fightCombat(melee, testHero, testMonster);
        // // Give the adventurer a sword
        // testHero.equipWeapon(sword);

        // Login or Create Account
        System.out.println("Please Login To Continue\n1) Login\n2) Create an Account");
        userChoice = sc.nextLine();

        // Login
        if(userChoice.equals("1")){
            // Username and Password
            System.out.println("Username:");
            userName = sc.nextLine();
            loginInfo = userName;
            System.out.println("Password:");
            loginInfo = loginInfo + sc.nextLine();
            // Run Login Command and set 'hasAccount' to true
            access = command.login(loginInfo);
            hasAccount = true;
            // If the user doesn't have an account...
            if(!access){
                System.out.println("Oops! Looks like that account information wasn't correct, that user does not exist, or another error has occured!");
                return;
            }
            // Load the Hero, Maps, and Shop
            System.out.println("Welcome back to ZST, " + userName + "!");
            advHero = saveLoad.loadHero(userName);
            eldenShop = saveLoad.loadShop(userName);

        }
        // Create an Account
        else if(userChoice.equals("2")){
            // Creating New Account
            System.out.println("Please enter your new username:");
            newUsername= sc.nextLine();
            System.out.println("Please enter a safe and secure password:");
            newPassword = sc.nextLine();
            System.out.println("Creating account. Please wait...");
            access = command.createAccount(newUsername, newPassword);
            // If an account with that username already exist...
            // If the user doesn't have an account...
            if(!access){
                System.out.println("Returning...");
                return;
            }
            // New user does not have an account
            hasAccount = false;
        }
        else{
            System.err.println("That is an invalid option. Please try again!");
            return;
        }

        // Create character
        while(!hasAccount){
            System.out.println("\n\nWelcome to ZST, an Adventure RPG Game!\nPlease Choose Your Character:\n1. Knight\n2. Archer\n3. Rogue\n4. Mage\n5. Preist");
            userChoice = sc.nextLine();
            advHero = command.createCharacter(userChoice);
            System.out.println("You have selected your Hero to be a(n) " + advHero.getHeroType());
            // Add First Map
            advHero.availMaps.add(elden);
            advHero.availMaps.add(fiji);
            // Start in Map Elden
            advHero.move("Elden");
            // Load Shop with goodies
            command.loadShopFresh(eldenShop);
            // Set userName
            advHero.setName(newUsername);
            // User now has an account
            hasAccount = true;
            if(newUsername.equalsIgnoreCase("admin")){
                // ADMIN CHEATS
                command.adminLogin(advHero);
            }
            else{
                // Give base gear...
                Fist fist = new Fist();
                advHero.addToHeroInventory(fist);
                advHero.equipWeapon(fist);
                Clothes clothes = new Clothes();
                advHero.addToHeroInventory(clothes);
                advHero.equipArmor(clothes);
            }
            // Save the new Hero!
            saveLoad.saveHero(advHero);
            saveLoad.saveShop(advHero, eldenShop);
        }

        // When account already exists
        // Play the Game

        while(hasAccount && !advHero.getIsDead()){
            System.out.println("\n\nYou are currently in " + advHero.getLocationName() + ". What would you like to do?\n");

            // Display Elden Menu
            if(advHero.getLocationName().equalsIgnoreCase("Elden")){
                //command.displayEldenMenu(advHero);
                System.out.println("0) View Hero Inventory\n1) Visit the shop\n2) Heal\n3) Move\n4) Save Game\n5) Quit");
                userChoice = sc.nextLine();
                switch(userChoice){
                    case "0":
                        command.viewHeroInventory(advHero);
                        break;
                    case "1":
                        // Vist the Shop
                        command.enterShop(advHero, eldenShop);
                        break;
                    case "2":
                        // Heal Hero for Gold
                        command.healHero(advHero);
                        break;
                    case "3":
                        System.out.println("Where would you like to move?");
                        advHero.getAvailMoves();
                        userChoice = sc.nextLine();
                        advHero.move(userChoice);
                        break;
                    case "4":
                        saveLoad.saveHero(advHero);
                        saveLoad.saveShop(advHero, eldenShop);
                        break;
                    case "5":
                        System.out.println("Are you sure you want to quit? Have you saved your game?\n1) Yes, I want to quit\n2) No, take me back to the game!");
                        userChoice = sc.nextLine();
                        if(userChoice.equals("1")){
                            System.out.println("Quitting Game... bye!");
                            hasAccount = false;
                        }
                        else if(userChoice.equals("2")){
                            // Do nothing
                        }
                        else{
                            System.out.println("Oops! That was an invalid input. Returning back to the game.");
                        }
                        break;
                    default:
                    System.out.println("Sorry that seems to be an invalid option. Please try again");
                        break;
                }

            }
            // Other map menus
            else{
                System.out.println("0) View Hero Inventory\n1) Search for loot\n2) Fight Creatures\n3) Move\n4) Challenge Boss\n5) Save Game\n6) Quit");
                userChoice = sc.nextLine();
                switch(userChoice){
                    case "0":
                        command.viewHeroInventory(advHero);
                        break;
                    case "1":
                        // Search
                        break;
                    case "2":
                        // Fight Creatures
                        // Spawn random creature
                        currMonster = command.spawnMonster(advHero.getLocation());
                        System.out.println("You have run into a " + currMonster.getMonsterName() + "!");
                        command.fight(advHero, currMonster);
                        break;
                    case "3":
                        System.out.println("Where would you like to move?");
                        advHero.getAvailMoves();
                        userChoice = sc.nextLine();
                        advHero.move(userChoice);
                        break;
                    case "4":
                        // Fight the Boss
                        // Player must have defeated at least 15 monsters to fight the boss
                        if(advHero.getLocation().getMonstersDefeated() > 10){
                            System.out.println("Are you sure you want to fight the boss?\n1) Yes\n2) No");
                            userChoice = sc.nextLine();
                            // Fight the Boss
                            if(userChoice.equals("1")){
                                currMonster = command.spawnBoss(advHero.getLocation());
                                command.fight(advHero, currMonster);
                                // If the hero dies, this text wont pop up. We wont have to deal with that check...
                                // We need to check for, if the hero ran
                                if(!advHero.ran){
                                    advHero.getLocation().setBossDefeated(true);
                                    System.out.println(advHero.getLocationName() + advHero.getLocation().getBossDefeated());
                                    System.out.println(allMaps.get(1).getLocationName() + allMaps.get(1).getBossDefeated());
                                    advHero.addMap(advHero.getLocation());
                                }

                            }
                            else{
                                System.out.println("Returning to map...");
                            }
                        }
                        else{
                            System.out.println("Sorry you have to defeat 10 monsters here before you approach the boss! You have defeated " + advHero.getLocation().getMonstersDefeated());
                        }
                        break;
                    case "5":
                        //Save
                        saveLoad.saveHero(advHero);
                        saveLoad.saveShop(advHero, eldenShop);
                        break;
                    case "6":
                        System.out.println("Are you sure you want to quit? Have you saved your game?\n1) Yes, I want to quit\n2) No, take me back to the game!");
                        userChoice = sc.nextLine();
                        if(userChoice.equals("1")){
                            System.out.println("Quitting Game... bye!");
                            hasAccount = false;
                        }
                        else if(userChoice.equals("2")){
                            break;
                        }
                        else{
                            System.out.println("Oops! That was an invalid input. Returning back to the game.");
                        }
                        break;
                    default:
                    System.out.println("Sorry that seems to be an invalid option. Please try again");
                        break;
                }
            }
            //userChoice = sc.nextLine();
        }
        sc.close();
        return;
    }
}