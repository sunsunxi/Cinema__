import java.io.*;
public class room implements Serializable{
    int room_number=-1;
    int price=-100;
String film_name;
Film film;
String begin_time;
char[][] seat=new char[8][13];
boolean whether_is_empty=true;
room(){}
public void clear_room(){//初始化场次信息
for(int i=1;i<=12;i++)
    {
    seat[0][i]= (char) (i+64);
    }
for(int i=1;i<=7;i++)
    {
        seat[i][0]= (char) (i+48);
    }
for(int i=1;i<=7;i++)
    {
        for(int j=1;j<=12;j++)
        {seat[i][j]= 'O';}
    }
}
public void show_room(){//展示场次座位信息
    for(int i=0;i<=7;i++)
    {
        for(int j=0;j<=12;j++)
        {System.out.print(" "+seat[i][j]);}
        System.out.println("");
    }

}
public void  show_film_and_room(){//展示场次和电影信息
    System.out.println(room_number+"号厅 "+"开始时间 "+begin_time+" 票价 "+price+"元");
    this.film.show();
}

public void set_room(String film_name,int room_number,String begin_time,int price){//设定场次信息
    this.film=Save.films.get(film_name);
this.film_name=film_name;
this.room_number=room_number;
this.begin_time=begin_time;
this.price=price;
    }



}
