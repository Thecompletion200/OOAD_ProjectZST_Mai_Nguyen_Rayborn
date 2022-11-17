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
        String userChoice;
        boolean access = false;
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

        // Login
        System.out.println("Please Login To Continue\nUsername:");
        userChoice = sc.nextLine();
        System.out.println("Password:");
        userChoice = userChoice + sc.nextLine();
        access = command.login(userChoice);

        if(!access){
            System.out.println("Oops! Looks like that account information wasn't correct or that user does not exist!");
        }
        else{
            advHero = command.loadData(userChoice, advHero);
            //System.out.println(advHero.getHeroType());
        }
        //sc.close();


        // Play Game
        while(access){
            System.out.println("\nWelcome to ZST, an Adventure RPG Game!\nPlease Choose Your Character:\n1. Knight\n2. Archer\n3. Rogue\n4. Mage\n5. Preist");
            userChoice = sc.nextLine();
            advHero = command.createCharacter(userChoice);
            System.out.println("You have selected your Hero to be a(n) " + advHero.getHeroType());
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