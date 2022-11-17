package src;
import java.util.Scanner;

public class MeleeCombat implements FightStrategy{

    Scanner sc = new Scanner(System.in);
    String userChoice = "";
    Boolean run = false;

    @Override
    public void fight(Heroes hero, Monster monster){

        while(monster.getHealthPoints() > 0 || run){
            System.out.println("Make your move...\n1. Attack\n2. Run");
            userChoice = sc.nextLine();
            if(userChoice.equals("1")){

                monster.damageMonster(hero.attack());
                System.out.println("You attack the " + monster.getMonsterName() + " for " + hero.attack() + " HP!");
                hero.damageHero(monster.getDamage());
                System.out.println(monster.getMonsterName() + " has attacked you for " + monster.getDamage() + " HP!");
                
            }
            else if(userChoice.equals("2"))
            {
                run = true;
            }
            System.out.println("You have " + hero.getHealthPoints() + " HP");
            System.out.println("The " + monster.getMonsterName() + " has " + monster.getHealthPoints() + " HP");
        }
    }
    
}
