package src.monsters;

import src.creatureInterface;

public class Giant implements creatureInterface {
   
   public Integer damage = 10;
   public String creatureName = "Giant";
   public Integer exp = 5;
   public Integer healthPoints = 25;

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