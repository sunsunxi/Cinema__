import java.util.Collection;

public class Receptionist implements sell_ticket{

    @Override
    public void list_all_films() {//列出所有电影信息
        Collection<Film> value=Save.films.values();
        for( Film film_listed:value)
        {
            film_listed.show();
        }

    }
    public void list_all_room_information(){//列出所有场次信息
        Collection<room> value=Save.rooms.values();
        for(room room_listed:value)
        {
            room_listed.show_film_and_room();
        }
    }

    public void list_specific_room_information(String film_name) {//列出特定场次座位信息
        room room_to_show=Save.rooms.get(film_name);
        room_to_show.show_film_and_room();
        room_to_show.show_room();
    }
    public void sell_a_ticket(String film_name,int row,char col_char){//售票
        int col=col_char-64;
        Save.rooms.get(film_name).seat[row][col]='X';
    }

}
