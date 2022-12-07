package src;
import java.util.Scanner;
import java.util.*;

public class MeleeCombat implements FightStrategy{

    Scanner sc = new Scanner(System.in);
    Random rand = new Random();
    String userChoice = "";

    @Override
    public void fight(Heroes hero, Monster monster){

        while((monster.getHealthPoints() > 0)){
            System.out.println("Make your move...\n1. Attack\n2. Run");
            userChoice = sc.nextLine();
            if(userChoice.equals("1")){

                // MELEE COMBAT SPECIFIC
                // 5% chance we will amputate
                if(rand.nextInt(100) < 5){
                    // Special Attack
                    System.out.println("You have aputated you enemy! You inflicted " + monster.getHealthPoints()*(float).25 + " damage!");
                    monster.damageMonster(monster.getHealthPoints()*(float).25);
                    // Enemy Attack
                    System.out.println(monster.getMonsterName() + " has attacked you for " + monster.getDamage() + " HP!");
                    hero.damageHero(monster.getDamage());
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
            System.out.println("\nYou have " + hero.getHealthPoints() + " HP");
            System.out.println("The " + monster.getMonsterName() + " has " + monster.getHealthPoints() + " HP");
        }
        hero.giveExp(monster.getExp());
        System.out.println("You have slain " + monster.getMonsterName() + "!");
        // Check for level up and death
        hero.checkIsDead();
        hero.levelUp();
    }
    
}
