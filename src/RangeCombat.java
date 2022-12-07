package src;
import java.util.Scanner;
import java.util.*;

public class RangeCombat implements FightStrategy{

    Scanner sc = new Scanner(System.in);
    Random rand = new Random();
    String userChoice = "";

    @Override
    public void fight(Heroes hero, Monster monster){

        while((monster.getHealthPoints() > 0)){
            System.out.println("Make your move...\n1. Attack\n2. Run");
            userChoice = sc.nextLine();
            if(userChoice.equals("1")){

                // RANGE COMBAT SPECIFIC
                // 1% chance we will headshot
                if(rand.nextInt(100) < 1){
                    // Special Attack
                    System.out.println("Your arrow pierces the enemy! You have headshotted " + monster.getMonsterName() + " and have killed them!");
                    monster.damageMonster(monster.getHealthPoints());
                    // Enemy Cannot Attack
                }
                else{
                    monster.damageMonster(hero.attack());
                    System.out.println("You attack the " + monster.getMonsterName() + " with " + hero.getWeapon().getItemName() + " for " + hero.attack() + " HP!");
                    if(monster.getHealthPoints() <= 0){
                        break;
                    }
                    else{
                        hero.damageHero(monster.getDamage());
                        System.out.println(monster.getMonsterName() + " has attacked you for " + monster.getDamage() + " HP!");
                    }
                }
                
            }
            else if(userChoice.equals("2"))
            {
                return;
            }
            System.out.println("You have " + hero.getHealthPoints() + " HP");
            System.out.println("The " + monster.getMonsterName() + " has " + monster.getHealthPoints() + " HP");
        }
    }
    
}