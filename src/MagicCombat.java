package src;
import java.util.Scanner;

import java.util.*;

public class MagicCombat implements FightStrategy{

    Scanner sc = new Scanner(System.in);
    Random rand = new Random();
    String userChoice = "";

    @Override
    public void fight(Heroes hero, Monster monster){
        Boolean isFrozen = false;
        Boolean isDebuffed = false;
        int frozenTurnCount = 0;
        while((monster.getHealthPoints() > 0)){
            System.out.println("Make your move...\n1. Attack\n2. Use Magic\n3. Run\n");
            userChoice = sc.nextLine();
            // Attack
            if(userChoice.equals("1")){
                monster.damageMonster(hero.attack());
                System.out.println("You attack the " + monster.getMonsterName() + " with " + hero.getWeapon().getItemName() + " for " + hero.attack() + " HP!");
                if(frozenTurnCount == 2){
                    frozenTurnCount = 0;
                    isFrozen = false;
                    System.out.println("The freeze effect has worn off!");
                }
                if(monster.getHealthPoints() <= 0){
                    break;
                }
                else if(!isFrozen){
                    // 15% debuff
                    if(isDebuffed){
                        System.out.println(monster.getMonsterName() + " has attacked you for " + (monster.getDamage()* (float)0.85) + " HP!");
                        hero.damageHero(monster.getDamage() * (float)0.85);
                    }
                    else {
                        System.out.println(monster.getMonsterName() + " has attacked you for " + monster.getDamage() + " HP!");
                        hero.damageHero(monster.getDamage());
                    }
                }
                // If the monster is frozen...
                else {
                    frozenTurnCount++;
                    System.out.println(monster.getMonsterName() + " is frozen and cannot attack.");
                }
            }
            // Use Magic
            else if(userChoice.equals("2"))
            {
                System.out.println("1) Burn\n2) Freeze\n3) Debuff");
                userChoice = sc.nextLine();
                switch(userChoice){
                    case "1":
                    System.out.println("You've inflicted burn to " + monster.getMonsterName() + ". " + monster.getMonsterName() + " has been burned for " + monster.getHealthPoints()*.16 + " HP!");
                        monster.damageMonster(monster.getHealthPoints()*(float).16);
                    case "2":
                        isFrozen = true;
                        System.out.println("You've frozen " + monster.getMonsterName());
                    case "3":
                        isDebuffed = true;
                        System.out.println("You've debuffed " + monster.getMonsterName() + ". They now do less damage");
                    default:
                }
            }

            // Run
            else if(userChoice.equals("3"))
            {
                return;
            }
            System.out.println("You have " + hero.getHealthPoints() + " HP");
            System.out.println("The " + monster.getMonsterName() + " has " + monster.getHealthPoints() + " HP");
        }
        
        System.out.println("You have slain " + monster.getMonsterName() + "!");
        // Check for level up and death
        hero.checkIsDead();
        hero.levelUp();
    }
    
}
