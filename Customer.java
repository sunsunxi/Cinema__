import java.io.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Collection;
//创建用户类
public class Customer implements  Serializable,customer_password_management,buy_ticket{
 String customer_name;//用户名
 String customer_level="铜牌客户";//用户等级
String register_time;//注册时间
 double sum_consumption=0;//消费总额
 int consumption_times=0;//消费次数
 String telephone_number;//手机号
 String email_address;//邮箱地址
    Customer(){}
    public String set_register_time(){//设定注册时间
        LocalDateTime time= LocalDateTime.now();

        register_time=time.toString();
        return time.toString();
    }

    public void set_information(String customer_name,String telephone_number,String email_address){//设定用户信息
        this.customer_name=customer_name;
        this.telephone_number=telephone_number;
        this.email_address=email_address;

    }

    @Override
    public void change_myself_password(int customer_ID,String password) {//改密码

        Save.ID_password.replace(customer_ID,password);

    }

    public void show(){//展示用户信息
        System.out.println(" 用户名 "+customer_name+" 用户就别 "+customer_level+" 用户注册时间 "+register_time+" 用户消费总金额 "+sum_consumption+" 用户累计消费次数 "+consumption_times+" 用户手机号 "+telephone_number+" 用户邮箱地址 "+email_address);
    }
    public void list_all_films(){//展示所有电影信息
        Collection<Film> value=Save.films.values();
        for( Film film_listed:value)
        {
            film_listed.show();
        }
    }
    public void list_specific_film(String film_name){//展示电影名相关电影信息和场次信息以及座位信息
        room room_to_show=Save.rooms.get(film_name);
        room_to_show.show_film_and_room();//展示电影名相关电影信息和场次信息
        room_to_show.show_room();//展示电影名相关场次座位信息
    }
    public void choose_seat(String film_name,int row,char col_char){//输入座位号（行，列）选取座位
        int col=col_char-64;
        Save.rooms.get(film_name).seat[row][col]='X';//选好的座位替换为'X'
    }

    public double pay(String film_name,int customer_ID,int row,char col_char) {//输入座位号（行，列）选取座位，并使用用户余额进行支付返回用户扣款后余额

        int col=col_char-64;
        Customer customer=Save.customers.get(customer_ID);
        room room1=Save.rooms.get(film_name);//得到电影名响应场次信息
        room1.seat[row][col]='X';
        //打印票据
        System.out.print("您已经成功购买");
        System.out.print(room1.room_number+"号厅  "+"开始时间"+room1.begin_time+"的票");
        String to_save_ticket="票号"+room1.room_number+"号厅  "+"开始时间"+room1.begin_time+"的票";
        System.out.println("座位"+row+"排"+col_char+"座");
        Save.tickets.put(customer_ID,to_save_ticket);//将票据信息储存
        //判断客户等级给予相应优惠，返回不同的扣款后余额
        customer.consumption_times++;

        if(customer.customer_level.equals("金牌客户"))
        {
            double account_left=Save.account.get(customer_ID)-room1.price*0.88;
            Save.account.replace(customer_ID,account_left);
            customer.sum_consumption+=room1.price*0.88;
            return account_left;

        }
        else if (customer.customer_level.equals("银牌客户"))
        {
            double account_left=Save.account.get(customer_ID)-room1.price*0.95;
            Save.account.replace(customer_ID,account_left);
            customer.sum_consumption+=room1.price*0.95;
            customer.customer_level="金牌客户";
            return account_left;

        }
        else if (customer.customer_level.equals("铜牌客户"))
        {
            double account_left=Save.account.get(customer_ID)-room1.price;
            Save.account.replace(customer_ID,account_left);
            customer.sum_consumption+=room1.price;
            customer.customer_level="银牌客户";
            return  account_left;

        }
        return 0;

    }


    public void check_history(int customer_ID) {//通过用户ID查找相应票据信息
        System.out.println(Save.tickets.get(customer_ID));
    }
}

