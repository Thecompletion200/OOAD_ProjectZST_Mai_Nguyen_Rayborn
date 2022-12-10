package src;
import java.util.Scanner;

import java.util.*;

public class PriestCombat implements FightStrategy{

    Scanner sc = new Scanner(System.in);
    Random rand = new Random();
    String userChoice = "";

    @Override
    public void fight(Heroes hero, Monster monster){

        hero.ran = false;
        while((monster.getHealthPoints() > 0)){
            System.out.printf("%-40s %-10s\n", "\nHero", monster.getMonsterName());
            System.out.printf("%-40s %-10s\n", "--------------------", "--------------------");
            System.out.printf("%-40s %-10s\n", hero.getHealthPoints() + "/" + hero.getMaxHealthPoints() +  "HP", monster.getHealthPoints() + " HP");
            System.out.println("\n\nMake your move...\n1. Attack\n2. Heal\n3. Run\n");
            userChoice = sc.nextLine();
            // Attack
            if(userChoice.equals("1")){
                monster.damageMonster(hero.attack());
                System.out.println("You attack the " + monster.getMonsterName() + " with " + hero.getWeapon().getItemName() + " for " + hero.attack() + " HP!");
                if(monster.getHealthPoints() <= 0){
                    break;
                }
                else {
                    System.out.println(monster.getMonsterName() + " has attacked you for " + monster.getDamage() + " HP!");
                    hero.damageHero(monster.getDamage());
                    hero.checkIsDead();
                    if(hero.getIsDead()){
                        System.out.println("You have died!");
                        return;
                    }
                }
            }
            // Use heales
            else if(userChoice.equals("2"))
            {
                if(hero.getHealthPoints() < hero.getMaxHealthPoints()*(float)0.75){
                    hero.healHero(hero.getMaxHealthPoints()*(float)0.75);
                    System.out.println("You have been restored to 75% HP!");
                }
                else{
                    System.out.println("You don't need to heal!");
                }
            }
            // Run
            else if(userChoice.equals("3"))
            {
                hero.ran = true;
                return;
            }
        }
        hero.giveExp(monster.getExp());
        System.out.println("You have slain " + monster.getMonsterName() + "!");
        hero.getLocation().increaseMonstersDefeated();
        // Check for level up and death
        hero.checkIsDead();
        hero.levelUp();
    }
    
}
