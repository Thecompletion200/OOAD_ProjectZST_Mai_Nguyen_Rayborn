package src.monsters;

import src.Monster;

public class Giant implements Monster {
   
   public Integer damage = 100;
   public String creatureName = "Giant";
   public Integer exp = 5;
   public Integer healthPoints = 250;
   public String monsterType = "Melee";

   @Override
   public void creature() {
      System.out.println("Creating Giant");
   }

   @Override
   public void callout() {
      System.out.println("You've encountered a " + creatureName);
   }

   @Override
   public void die() {
      System.out.println(creatureName + "has fallen!");
      
   }

   @Override
   public Integer attack() {
      return damage;
   }
   
}