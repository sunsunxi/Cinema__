
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//            Save.ID_password.put(30001,"admin");//默认管理员ID和密码
//           Save.ID_password.put(20001,"recep");//默认前台ID和密码
//         Save.ID_password.put(40001,"manage");//默认经理ID和密码
//          Save.ID_password.put(50001,"123456");//默认一位用户ID和密码
//          Save.customers.put(50001,new Customer());
//           Save.account.put(50001,100000.0);//默认一位用户初始金钱为100000
//            Save.films.put("QQQ",new Film("QQQ","AAA","BBB","CCC","DDD",90,true));
//          Save.write_in();
            Save.read();
            Scanner in=new Scanner(System.in);
            while(true){
                    System.out.println("请输入ID");
                    int ID=in.nextInt();
                    if(ID==-1)
                    {break;}
                    if(Save.ID_password.containsKey(ID))
                    {
                            System.out.println("请输入密码");
                            String password=in.next();
                            if(password.equals(Save.ID_password.get(ID)))
                            {
                                    Log log=new Log();
                                    //将ID分了类，50000以上是用户，40000到50000是经理，30000到40000是管理员，20000到30000是前台
                            if(ID>=50000){
                                    log.customer_log_in(ID);//跳转到用户界面
                                    }
                            else if(ID>=40000){
                                    log.manager_log_in();//跳转到经理界面
                            }
                            else if(ID>=30000){
                                    log.administrator_log_in(ID);//跳转到管理员界面
                            }
                            else if (ID>=20000) {
                                    log.receptionist_log_in();//跳转到前台界面
                            }
                            }
                     else if(!password.equals(Save.ID_password.get(ID))){//密码错误
                                    System.out.println("密码错误，请重试");
                            }
                    }
                    else if(!Save.ID_password.containsKey(ID)&&ID>=50000){//自动注册用户
                    System.out.println("未查询到该用户，输入密码将自动帮您注册");
                    String password;
                    String regex="^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{9,}$";
                    while(true)//判断密码合不合规，不合规循环执行
                    {System.out.println("密码长度大于8个字符，必须是大小写字母、数字的组合");
                    password=in.next();
                    if(password.matches(regex))
                    break;
                    }
                    Save.ID_password.put(ID,password);
                    Save.customers.put(ID,new Customer());
                    Save.account.put(ID,100000.0);
                    System.out.println("注册成功,注册时间为"+Save.customers.get(ID).set_register_time());

                    }
                    else if(!Save.ID_password.containsKey(ID)&&ID<50000){
                            System.out.println("系统错误，请重试");
                    }

            }
            Save.write_in();
    }

}

