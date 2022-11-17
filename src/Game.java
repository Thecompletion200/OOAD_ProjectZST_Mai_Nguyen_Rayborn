package src;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Container;
import java.awt.Color;

public class Game {

    JFrame window;
    Container con;
    JPanel titleNamePanel;

    public static void fightCombat(FightStrategy fStrategy, Heroes h, Monster m){
        System.out.println("yo");
        fStrategy.fight(h, m);
        System.out.println("yo");
    }

    public static void main(String[] args) {
        
        monsterFactory creatureFac = new monsterFactory();
        Monster currMonster = creatureFac.spawnBandit();
        System.out.println(currMonster.getHealthPoints());
        Heroes advHero = new Knight();
        Items sword = new Sword();
        Items armor = new Armor();
        FightStrategy melee = new MeleeCombat();

        //Give the adventurer a sword
        advHero.equipWeapon(sword);

        melee.fight(advHero, currMonster);
        //Monster creatureTest = creatureFac.spawnBandit();
        //creatureTest.getMonsterName();
        // new Game();

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