package src;

import src.monsters.Bandit;
import src.monsters.DiseasedCow;
import src.monsters.Dragon;
import src.monsters.Giant;
import src.monsters.Skeleton;
import src.monsters.Troll;
import src.monsters.Vampire;
import src.monsters.Witch;
import src.monsters.Wolf;
import src.monsters.Zombie;

public class monsterFactory {
	 
   public Monster spawnBandit(){
      return new Bandit();
   }
   public Monster spawnDiseasedCow(){
      return new DiseasedCow();
   }
   public Monster spawnDragon(){
      return new Dragon();
   }
   public Monster spawnGiant(){
      return new Giant();
   }
   public Monster spawnSkeleton(){
      return new Skeleton();
   }
   public Monster spawnTroll(){
      return new Troll();
   }
   public Monster spawnVampire(){
      return new Vampire();
   }
   public Monster spawnWitch(){
      return new Witch();
   }
   public Monster spawnZombie(){
      return new Zombie();
   }
}