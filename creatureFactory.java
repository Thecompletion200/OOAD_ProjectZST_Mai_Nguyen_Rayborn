public class creatureFactory {
	
   //use getCreature method to get object of type creature 
   public creatureInterface getCreature(String creatureType){
      if(creatureType == null){
         return null;
      }		
      if(creatureType.equalsIgnoreCase("creature1")){
         return new Circle();
         
      } else if(creatureType.equalsIgnoreCase("RECTANGLE")){
         return new Rectangle();
         
      } else if(creatureType.equalsIgnoreCase("SQUARE")){
         return new Square();
      }
      
      return null;
   }
}