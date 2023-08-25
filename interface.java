
interface administrator_password_management{
void reset_customer_password(int i);
}
interface customer_management{
void list_customer_information();
void  delete_customer_information(int t);
void   find_customer_information(int t);}

interface film_management{
void list_all_films();
void add_film(String film_name,String director,String main_actor,String type,String introduction,int film_time,boolean on_or_not);
void modify_film(String film_name,String director,String main_actor,String type,String introduction,int film_time,boolean on_or_not);
  void delete_film(String s);
}
interface film_arrangement{
void add_room(String film_name,int room_number,String begin_time,int p);
void delete_room(String s);
void modify_room(String film_name,int room_number,String begin_time,int p);
void list_all_room_information();
}
interface sell_ticket{
void list_all_films();
void list_all_room_information();
void list_specific_room_information(String s);
void sell_a_ticket(String s,int A,char B);
}

interface customer_password_management{
void change_myself_password(int i,String s);
}
interface buy_ticket{
void  list_all_films();
void list_specific_film(String s);
void choose_seat(String s,int A,char B);
double pay(String s,int i,int row,char col_char);
 void check_history(int i);
}




