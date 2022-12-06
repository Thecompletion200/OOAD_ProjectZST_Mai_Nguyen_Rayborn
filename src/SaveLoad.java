package src;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.*;

public class SaveLoad {
    
    public void saveHero(Heroes advHero){
        String fileName = "src/userData/" + advHero.getHeroName() + "Data.bin";

        try{
            FileOutputStream fos = new FileOutputStream(fileName);
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            oos.writeObject(advHero);

            oos.close();
            System.out.println("Hero Successfully Saved!");

        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public Heroes loadHero(String userName){
        String fileName = "src/userData/" + userName + "Data.bin";

        try{
            FileInputStream fin = new FileInputStream(fileName);
            ObjectInputStream ois = new ObjectInputStream(fin);

            Object obj;
            while(true){
                // checking whether the line is in fact an object
                try{
                    obj = ois.readObject();

                    // if the object is indeed a Hero object
                    if(obj instanceof Heroes){
                        // return the obj
                        return (Heroes)obj;
                    }
                    else{
                        System.err.println("unexpected object in file.");
                    }
                } catch(EOFException ex){
                    break;
                }
            }
            ois.close();
        } catch (IOException | ClassNotFoundException e){
            e.printStackTrace();
        }
        
        return null;
    }

    public void saveShop(Heroes advHero, Shop shop){
        String fileName = "src/userData/" + advHero.getHeroName() + "ShopData.bin";

        try{
            FileOutputStream fos = new FileOutputStream(fileName);
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            oos.writeObject(shop);

            oos.close();
            System.out.println("Shop Successfully Saved!");

        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public Shop loadShop(String userName){
        String fileName = "src/userData/" + userName + "ShopData.bin";

        try{
            FileInputStream fin = new FileInputStream(fileName);
            ObjectInputStream ois = new ObjectInputStream(fin);

            Object obj;
            while(true){
                // checking whether the line is in fact an object
                try{
                    obj = ois.readObject();

                    // if the object is indeed a Hero object
                    if(obj instanceof Shop){
                        // return the obj
                        return (Shop)obj;
                    }
                    else{
                        System.err.println("unexpected object in file.");
                    }
                } catch(EOFException ex){
                    break;
                }
            }
            ois.close();
        } catch (IOException | ClassNotFoundException e){
            e.printStackTrace();
        }
        
        return null;
    }
}
