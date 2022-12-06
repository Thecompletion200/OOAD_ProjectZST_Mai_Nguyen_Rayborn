package src;

import java.io.Serializable;
import java.util.ArrayList;

public class Shop implements Serializable{

    private final String storeName = "Eldens Edge";
    private ArrayList<Items> storeInventory = new ArrayList<Items>();

    public String getStoreName(){
        return storeName;
    }
    public void addToInventory(Items i){
        this.storeInventory.add(i);
    }
    public void getStoreInventory(){
        System.out.println("Store Inventory");
        System.out.println("---------------------------------");
        for(int i = 0; i < this.storeInventory.size(); i++){
            System.out.println(this.storeInventory.get(i).getItemName() + " - " + this.storeInventory.get(i).getItemCost() + " Gold");
        }
    }

    public Items getItemFromShelf(String itemName){
        Items purchasedItem = null;
        for(int i = 0; i < this.storeInventory.size(); i++){
            if(this.storeInventory.get(i).getItemName().equalsIgnoreCase(itemName)){
                // Grab Item
                purchasedItem = this.storeInventory.get(i);
                // Remove from store inventory
                // this.storeInventory.remove(this.storeInventory.get(i));
            }
        }
        return purchasedItem;
    }

    public void removeFromInventory(Items item){
        for(int i = 0; i < this.storeInventory.size(); i++){
            if(this.storeInventory.get(i).equals(item)){
                // Remove from store inventory
                this.storeInventory.remove(this.storeInventory.get(i));
                return;
            }
        }
        return;
    }
    
}
