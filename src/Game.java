package src;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Container;
import java.io.IOException;
import java.awt.Color;

import java.util.Scanner;
import java.util.Set;

public class Game {

    JFrame window;
    Container con;
    JPanel titleNamePanel;

    public void fightCombat(FightStrategy fStrategy, Heroes h, Monster m){
        System.out.println("yo");
        fStrategy.fight(h, m);
        System.out.println("yo");
    }

    public static void main(String[] args) throws IOException {
        
        // Initialize Game
        Game game = new Game();
        monsterFactory MonsterFac = new monsterFactory();
        Command command = new Command();
        Scanner sc = new Scanner(System.in);
        Maps Elden = new Elden();
        Maps Fiji = new Fiji();
        String userChoice;
        String newUsername;
        String newPassword;
        boolean access = false;
        boolean hasAccount = false;
        Monster currMonster;
        Heroes advHero = null;


        // // TESTING
        // Heroes testHero = new Knight();
        // Items sword = new Sword();
        // Items armor = new Armor();
        // Monster testMonster = MonsterFac.spawnBandit();
        // System.out.print(testMonster.getMonsterName());
        // FightStrategy melee = new MeleeCombat();
        // //game.fightCombat(melee, testHero, testMonster);
        // // Give the adventurer a sword
        // testHero.equipWeapon(sword);

        // melee.fight(testHero, testMonster);
        // testMonster.getMonsterName();

        // Login or Create Account
        System.out.println("Please Login To Continue\n1) Login\n2) Create an Account");
        userChoice = sc.nextLine();
        //Login
        if(userChoice.equals("1")){
            System.out.println("Username:");
            userChoice = sc.nextLine();
            System.out.println("Password:");
            userChoice = userChoice + sc.nextLine();
            access = command.login(userChoice);
        }
        else if(userChoice.equals("2")){
            System.out.println("Please enter your new username:");
            newUsername= sc.nextLine();
            System.out.println("Please enter a safe and secure password:");
            newPassword = sc.nextLine();
            System.out.println("Creating account. Please wait...");
            hasAccount = command.createAccount(newUsername, newPassword);
        }

        if(!access){
            System.out.println("Oops! Looks like that account information wasn't correct or that user does not exist!");
        }
        else{
            hasAccount = true;
            // NOT WORKING YET
            advHero = command.loadData(userChoice, advHero);
            System.out.println(advHero.getHeroType());
        }
        //sc.close();


        // Play Game
        // Create character
        while(!hasAccount){
            System.out.println("\nWelcome to ZST, an Adventure RPG Game!\nPlease Choose Your Character:\n1. Knight\n2. Archer\n3. Rogue\n4. Mage\n5. Preist");
            userChoice = sc.nextLine();
            advHero = command.createCharacter(userChoice);
            System.out.println("You have selected your Hero to be a(n) " + advHero.getHeroType());
            advHero.move(Elden);
            hasAccount = true;
        }

        while(hasAccount){

        }

        // new Game();
        sc.close();
        return;

    }

    // public Game(){
    //     window = new JFrame();
    //     window.setSize(800, 600);
    //     window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    //     window.getContentPane().setBackground(Color.black);
    //     window.setLayout(null);
    //     window.setVisible(true);
    //     con = window.getContentPane();

    //     titleNamePanel = new JPanel();
    //     titleNamePanel.setBounds(100, 100, 600, 150);

    // }
}