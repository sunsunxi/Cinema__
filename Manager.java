import java.util.*;
public class Manager implements film_management,film_arrangement{
    Manager(){}
    @Override
    public void list_all_films() {//列出所有电影信息
        Collection<Film> value=Save.films.values();
        for( Film film_listed:value)
        {
            film_listed.show();
        }

    }



    public void add_film(String film_name,String director,String main_actor,String type,String introduction,int film_time,boolean on_or_not){//添加电影信息
       Save.films.put(film_name,new Film(film_name,director,main_actor,type,introduction,film_time,on_or_not));
    }
    public void modify_film(String film_name,String director,String main_actor,String type,String introduction,int film_time,boolean on_or_not){//修改电影信息
        Save.films.remove(film_name);
        Save.films.put(film_name,new Film(film_name,director,main_actor,type,introduction,film_time,on_or_not));
    }
    public void delete_film(String film_name){//删除指定电影及其信息
        Save.films.remove(film_name);
    }
    public void add_room(String film_name,int room_number,String begin_time,int price) {//添加场次
        room room_to_be_added=new room();
        room_to_be_added.set_room(film_name,room_number,begin_time,price);
        room_to_be_added.clear_room();
        room_to_be_added.whether_is_empty=false;
        Save.rooms.put(film_name,room_to_be_added);
    }
    public void delete_room(String film_name){//删除场次
        Save.rooms.get(film_name).whether_is_empty=true;
        Save.rooms.get(film_name).clear_room();
        Save.rooms.remove(film_name);
    }
    public void modify_room(String film_name,int room_number,String begin_time,int price)//修改场次信息
    {
        Save.rooms.get(film_name).room_number=room_number;
        Save.rooms.get(film_name).begin_time=begin_time;
        Save.rooms.get(film_name).price=price;
    }
    public void show_specific_film_and_room(String film_name){//展示特定场次信息
        room room_specific=Save.rooms.get(film_name);
       room_specific.show_film_and_room();
       room_specific.show_room();
    }

    public void list_all_room_information(){//展示所有场次信息
        Collection<room> value=Save.rooms.values();
        for(room room_listed:value)
        {
            room_listed.show_film_and_room();
            room_listed.show_room();
        }
    }

}
