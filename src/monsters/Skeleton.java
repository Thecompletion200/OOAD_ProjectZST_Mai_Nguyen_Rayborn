package src.monsters;

import src.Monster;

public class Skeleton implements Monster {
   
   public Integer damage = 10;
   public String creatureName = "Skeleton";
   public Integer exp = 5;
   public Integer healthPoints = 25;
   public String monsterType = "Range";


   @Override
   public void creature() {
      System.out.println("Creating Skeleton");
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