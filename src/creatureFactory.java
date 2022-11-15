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

public class creatureFactory {
	
   //use getCreature method to get object of type creature 
   public creatureInterface getCreature(String creatureType){
      if(creatureType == null){
         return null;
      }		
      if(creatureType.equalsIgnoreCase("BANDIT")){
         return new Bandit();
      }
      else if(creatureType.equalsIgnoreCase("WOLF")){
         return new Wolf();
      }
      else if(creatureType.equalsIgnoreCase("DISEASEDCOW")){
         return new DiseasedCow();
      }
      else if(creatureType.equalsIgnoreCase("DRAGON")){
         return new Dragon();
      }
      else if(creatureType.equalsIgnoreCase("GIANT")){
         return new Giant();
      }
      else if(creatureType.equalsIgnoreCase("SKELETON")){
         return new Skeleton();
      }
      else if(creatureType.equalsIgnoreCase("TROLL")){
         return new Troll();
      }
      else if(creatureType.equalsIgnoreCase("VAMPIRE")){
         return new Vampire();
      }
      else if(creatureType.equalsIgnoreCase("WITCH")){
         return new Witch();
      }
      else if(creatureType.equalsIgnoreCase("ZOMBIE")){
         return new Zombie();
      }

      return null;
   }
}