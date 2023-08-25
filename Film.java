import java.io.Serializable;

public class Film implements Serializable {
    String film_name;
    String director;
    String main_actor;
    String type;
    String introduction;
    int film_time;
    boolean on_or_not;
   Film(String film_name,String director,String main_actor,String type,String introduction,int film_time,boolean on_or_not) {
       this.film_name = film_name;
       this.director = director;
       this.main_actor = main_actor;
       this.type = type;
       this.introduction = introduction;
       this.film_time = film_time;
       this.on_or_not=on_or_not;
   }
   public void show(){//展示电影信息
        System.out.println("片名 "+film_name+" 导演 "+director+" 主演 "+main_actor+" 类型 "+type+" 剧情简介 "+introduction+" 时长 "+film_time+"分钟");
   }
}
