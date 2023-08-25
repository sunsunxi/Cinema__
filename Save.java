
import java.io.*;
import java.util.HashMap;
import java.io.IOException;
import java.util.Map;

public class Save implements Serializable {

    static HashMap<Integer,Customer> customers=new HashMap();//存储用户信息
    static HashMap<String,Film> films=new HashMap();//存储电影信息
    static HashMap<String,room> rooms=new HashMap();//存储场次信息
    static HashMap<Integer,Double> account=new HashMap<>();//存储用户金额等信息
    static HashMap<Integer,String> tickets=new HashMap<>();//存储用户的票务信息
    static HashMap<Integer,String> ID_password=new HashMap<>();//存储所有人员密码信息
    public static void write_in() {
         try{FileOutputStream fileOutputStream1 = new FileOutputStream("many.txt");
         ObjectOutputStream objectOutputStream1 = new ObjectOutputStream(fileOutputStream1);
         objectOutputStream1.writeObject(customers);
          objectOutputStream1.writeObject(films);
          objectOutputStream1.writeObject(rooms);
             objectOutputStream1.writeObject(account);
             objectOutputStream1.writeObject(tickets);
         objectOutputStream1.close();
         fileOutputStream1.close();
             FileOutputStream fileOutputStream2 = new FileOutputStream("other.txt");
             ObjectOutputStream objectOutputStream2 = new ObjectOutputStream(fileOutputStream2);
             objectOutputStream2.writeObject(ID_password);
             objectOutputStream2.close();
             fileOutputStream2.close();
         }
         catch (IOException e) {
             e.printStackTrace();
         }
     }
    public static void read(){
         try {
             FileInputStream fileInputStream1 = new FileInputStream("many.txt");
             ObjectInputStream objectInputStream1 = new ObjectInputStream(fileInputStream1);
             customers = (HashMap<Integer,Customer>) objectInputStream1.readObject();
             films=(HashMap<String,Film>) objectInputStream1.readObject();
             rooms=(HashMap<String,room>) objectInputStream1.readObject();
             account=(HashMap<Integer, Double>) objectInputStream1.readObject();
             tickets=(HashMap<Integer,String>) objectInputStream1.readObject();
             objectInputStream1.close();
             fileInputStream1.close();
             FileInputStream fileInputStream2 = new FileInputStream("other.txt");
             ObjectInputStream objectInputStream2 = new ObjectInputStream(fileInputStream2);
             ID_password=(HashMap<Integer,String>) objectInputStream2.readObject();
             objectInputStream2.close();
             fileInputStream2.close();
         } catch (IOException | ClassNotFoundException e) {
             e.printStackTrace();
         }
     }

}
