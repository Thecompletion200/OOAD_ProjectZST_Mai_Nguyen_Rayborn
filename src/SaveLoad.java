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

        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public void loadHero(String userName){
        String fileName = "src/userData/usersData.bin";

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
                        // TESTING
                        System.out.println(obj.getClass());
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
    }
}
