import java.util.Scanner;

public class Log {
    Scanner in = new Scanner(System.in);

    public void customer_log_in(int ID) {
        //用户菜单
        while (true) {
            System.out.println("");
            System.out.println("请选择您要办理的业务，用下列序号表示");
            System.out.println("1.修改密码");
            System.out.println("2.录入信息");
            System.out.println("3.展示所有电影信息");
            System.out.println("4.展示特定场次和座位信息");
            System.out.println("5.选座");
            System.out.println("6.买票");
            System.out.println("7.查看购票历史");
            System.out.println("8.退出");
            System.out.println("");
            int i=in.nextInt();

            if (i== 1) {
                System.out.println("请输入新密码");
                String password;
                String regex="^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{9,}$";
                while(true)//密码不合规循环执行，直到密码合规
                {System.out.println("密码长度大于8个字符，必须是大小写字母、数字的组合");
                    password=in.next();
                    if(password.matches(regex))
                        break;
                }
                Save.customers.get(ID).change_myself_password(ID,password);}
            else if (i== 2) {
                System.out.println("请输入用户名");
                String customer_name;
                while(true)
                {customer_name = in.next();
                    if(customer_name.length()<=6) break;
                    else System.out.println("用户名过长，请重试");
                }
                System.out.println("请输入手机号");
                String telephone_number;
                while(true)
                {telephone_number = in.next();
                 if(telephone_number.length()==11) break;
                 else System.out.println("无效的手机号，请重试");
                }
                System.out.println("请输入邮箱地址");
                String regex="^[^@]*@[^@]*$";
                String email_address;
                while(true)
                {email_address=in.next();
                    if(email_address.matches(regex)) break;
                    else System.out.println("无效的邮箱地址，请重试");
                }
                Save.customers.get(ID).set_information(customer_name, telephone_number, email_address);

            } else if (i==3) {
                Save.customers.get(ID).list_all_films();
            } else if (i== 4) {
                System.out.println("请输入电影名");
                String film_name;
                while (true)
                {film_name = in.next();
                if(Save.films.containsKey(film_name))break;
                else System.out.println("电影名不存在，请重试");}
                Save.customers.get(ID).list_specific_film(film_name);
            } else if (i == 5) {
                Save.customers.get(ID).list_all_films();
                System.out.println("请输入电影名");
                String film_name;
                while (true)
                {film_name = in.next();
                    if(Save.films.containsKey(film_name))break;
                    else System.out.println("电影名不存在，请重试");}
                Save.customers.get(ID).list_specific_film(film_name);
                System.out.println("请输入座位行号");
                int row;
                while(true){
                row= in.nextInt();
                if(row>=1&&row<=7)break;
                else System.out.println("无效的座位行号,请重试");
                }
                System.out.println("请输入座位列号");
                char col_char;
                while(true){
                    col_char= in.next().charAt(0);
                    if(col_char>='A'&&col_char<='L')break;
                    else System.out.println("无效的座位列号,请重试");
                }
                Save.customers.get(ID).choose_seat(film_name,row,col_char);
            } else if (i == 6) {
                Save.customers.get(ID).list_all_films();
                System.out.println("请输入电影名");
                String film_name;
                while (true)
                {film_name = in.next();
                    if(Save.films.containsKey(film_name))break;
                    else System.out.println("电影名不存在，请重试");}
                Save.customers.get(ID).list_specific_film(film_name);
                System.out.println("请输入座位行号");
                int row;
                while(true){
                    row= in.nextInt();
                    if(row>=1&&row<=7)break;
                    else System.out.println("无效的座位行号,请重试");
                }
                System.out.println("请输入座位列号");
                char col_char;
                while(true){
                    col_char= in.next().charAt(0);
                    if(col_char>='A'&&col_char<='L')break;
                    else System.out.println("无效的座位列号,请重试");
                }
                double pay_left = Save.customers.get(ID).pay(film_name, ID, row, col_char);
                System.out.println("剩余金额:"+pay_left);
            } else if (i== 7) {
                Save.customers.get(ID).check_history(ID);
            } else if (i == 8) {
                break;
            }
            else
            {
             System.out.println("错误的指令，请重新输入");
            }

        }

    }

    public void manager_log_in() {
        Manager manager = new Manager();
        while (true) {
            //经理菜单
            System.out.println("");
            System.out.println("请选择您要办理的业务，用下列序号表示");
            System.out.println("1.列出所有电影信息");
            System.out.println("2.添加电影信息");
            System.out.println("3.修改电影信息");
            System.out.println("4.删除电影信息");
            System.out.println("5.添加场次");
            System.out.println("6.修改场次信息");
            System.out.println("7.删除场次");
            System.out.println("8.展示特定场次信息");
            System.out.println("9.展示所有场次信息");
            System.out.println("10.退出");
            System.out.println("");
            int i = in.nextInt();
            if (i == 1) {
                manager.list_all_films();
            } else if (i == 2) {
                System.out.println("已有电影");
                manager.list_all_films();
                System.out.println("请输入电影名");
                String film_name = in.next();
                System.out.println("请输入导演");
                String director = in.next();
                System.out.println("请输入主演");
                String main_actor = in.next();
                System.out.println("请输入电影类型");
                String type = in.next();
                System.out.println("请输入电影介绍");
                String introduction = in.next();
                System.out.println("请输入电影时长");
                int film_time = in.nextInt();
                System.out.println("请输入电影是否上映");
                boolean be_on_or_not = in.nextBoolean();
                manager.add_film(film_name, director, main_actor, type, introduction, film_time, be_on_or_not);
            } else if (i == 3) {
                System.out.println("已有电影");
                manager.list_all_films();
                System.out.println("请输入电影名");
                String film_name;
                while (true) {
                    film_name = in.next();
                    if (Save.films.containsKey(film_name)) break;
                    else System.out.println("电影名不存在，请重试");
                }
                System.out.println("请输入导演");
                String director = in.next();
                System.out.println("请输入主演");
                String main_actor = in.next();
                System.out.println("请输入电影类型");
                String type = in.next();
                System.out.println("请输入电影介绍");
                String introduction = in.next();
                System.out.println("请输入电影时长");
                int film_time = in.nextInt();
                System.out.println("请输入电影是否上映");
                boolean be_on_or_not = in.nextBoolean();
                manager.modify_film(film_name, director, main_actor, type, introduction, film_time, be_on_or_not);
            } else if (i == 4) {
                System.out.println("已有电影");
                manager.list_all_films();
                System.out.println("请输入电影名");
                String film_name;
                while (true) {
                    film_name = in.next();
                    if (Save.films.containsKey(film_name)) break;
                    else System.out.println("电影名不存在，请重试");
                }
                manager.delete_film(film_name);
            } else if (i == 5) {
                System.out.println("已有电影场次");
                manager.list_all_room_information();
                System.out.println("请输入电影名");
                String film_name;
                while (true) {
                    film_name = in.next();
                    if (Save.films.containsKey(film_name)) break;
                    else System.out.println("电影名不存在，请重试");
                }
                System.out.println("请输入影厅号");
                int room_number;
                while (true) {
                    room_number = in.nextInt();
                    if (room_number >= 1 && room_number <= 5) break;
                    else System.out.println("无效的影厅号，请重试");
                }
                System.out.println("请输入电影开始时间");
                String begin_time = in.next();
                System.out.println("请输入电影票价格");
                int price;
                while (true) {
                    price = in.nextInt();
                    if (price >= 50 && price <= 100) break;
                    else System.out.println("无效的价格，请重试");
                }
                manager.add_room(film_name, room_number, begin_time, price);
            } else if (i == 6) {
                System.out.println("已有电影场次");
                manager.list_all_room_information();
                System.out.println("请输入电影名");
                String film_name;
                while (true) {
                    film_name = in.next();
                    if (Save.films.containsKey(film_name)) break;
                    else System.out.println("电影名不存在，请重试");
                }
                System.out.println("请输入影厅号");
                int room_number;
                while (true) {
                    room_number = in.nextInt();
                    if (room_number >= 1 && room_number <= 5) break;
                    else System.out.println("无效的影厅号，请重试");
                }
                System.out.println("请输入电影开始时间");
                String begin_time = in.next();
                System.out.println("请输入电影票价格");
                int price;
                while (true) {
                    price = in.nextInt();
                    if (price >= 50 && price <= 100) break;
                    else System.out.println("无效的价格，请重试");
                }
                manager.modify_room(film_name, room_number, begin_time, price);
            } else if (i == 7) {
                System.out.println("已有电影场次");
                manager.list_all_room_information();
                System.out.println("请输入电影名");
                String film_name;
                while (true) {
                    film_name = in.next();
                    if (Save.films.containsKey(film_name)) break;
                    else System.out.println("电影名不存在，请重试");
                }
                System.out.println("输入1确认删除，输入2取消");
                if(in.nextInt()==1)
                {manager.delete_room(film_name);
                    System.out.println("删除成功");}

            } else if (i == 8) {
                System.out.println("已有电影场次");
                manager.list_all_room_information();
                System.out.println("请输入电影名");
                String film_name;
                while (true) {
                    film_name = in.next();
                    if (Save.films.containsKey(film_name)) break;
                    else System.out.println("电影名不存在，请重试");
                }
                manager.show_specific_film_and_room(film_name);
            } else if (i == 9) {
                manager.list_all_room_information();
            } else if (i == 10) {
                break;
            } else {
                System.out.println("错误的指令，请重新输入");
            }
        }
    }

    public void administrator_log_in(int ID){
        Administrator administrator=new Administrator();
        while(true){
            //管理员菜单
            System.out.println("");
            System.out.println("请选择您要办理的业务，用下列序号表示");
            System.out.println("1.修改自身密码");
            System.out.println("2.重置用户密码");
            System.out.println("3.列出所有用户信息");
            System.out.println("4.删除指定用户信息");
            System.out.println("5.查找特定用户信息");
            System.out.println("6.退出");
            System.out.println("");
            int i=in.nextInt();
            if(i==1){
                System.out.println("请输入新密码");
                String new_password;
                String regex="^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{9,}$";
                while(true)//密码不合规循环执行，直到密码合规
                {System.out.println("密码长度大于8个字符，必须是大小写字母、数字的组合");
                    new_password=in.next();
                    if(new_password.matches(regex))
                        break;
                }
                Save.ID_password.replace(ID,new_password);
            }
            else if(i==2){
                System.out.println("请输入要重置密码的用户ID");
                int customer_ID;
                while(true){
                    customer_ID=in.nextInt();
                    if(customer_ID>=50000&&Save.ID_password.containsKey(customer_ID)){break;}
                    else if(customer_ID<50000&&Save.ID_password.containsKey(customer_ID)) {System.out.println("你没有该权限，请切换要重置密码的ID");}
                    else if(customer_ID>=50000&&!Save.ID_password.containsKey(customer_ID)){System.out.println("不存在此ID，请重试");}
                }

                administrator.reset_customer_password(customer_ID);
            }
            else if (i==3) {
                administrator.list_customer_information();
            }
            else if (i==4) {
                System.out.println("请输入要删除的用户的用户ID");
                int customer_ID;
                while(true){
                    customer_ID=in.nextInt();
                    if(customer_ID>=50000&&Save.ID_password.containsKey(customer_ID)){break;}
                    else if(customer_ID<50000&&Save.ID_password.containsKey(customer_ID)) {System.out.println("你没有该权限，请切换要重置密码的ID");}
                    else if(customer_ID>=50000&&!Save.ID_password.containsKey(customer_ID)){System.out.println("不存在此ID，请重试");}
                }
                System.out.println("输入1确认删除，输入2取消");
                if(in.nextInt()==1)
                {administrator.delete_customer_information(customer_ID);
                System.out.println("删除成功");}
            }
            else if(i==5){
                System.out.println("请输入要查找的用户的用户ID");
                int customer_ID;
                while(true){
                    customer_ID=in.nextInt();
                    if(customer_ID>=50000&&Save.ID_password.containsKey(customer_ID)){break;}
                    else if(customer_ID<50000&&Save.ID_password.containsKey(customer_ID)) {System.out.println("你没有该权限，请切换要重置密码的ID");}
                    else if(customer_ID>=50000&&!Save.ID_password.containsKey(customer_ID)){System.out.println("不存在此ID，请重试");}
                }
                administrator.find_customer_information(customer_ID);
            }
            else if(i==6){
                break;
            }
            else{
                System.out.println("错误的指令，请重新输入");
            }
        }
    }
    public void receptionist_log_in(){
        Receptionist receptionist=new Receptionist();
        while(true) {
            //前台菜单
            System.out.println("");
            System.out.println("请选择您要办理的业务，用下列序号表示");
            System.out.println("1.展示所有影片信息");
            System.out.println("2.展示所有场次信息");
            System.out.println("3.展示特定场次信息");
            System.out.println("4.售票");
            System.out.println("5.退出");
            System.out.println("");
            int i=in.nextInt();
            if(i==1){
                receptionist.list_all_films();
            }
            else if(i==2)
            {
                receptionist.list_all_room_information();
            }
            else if (i==3) {
                System.out.println("请输入电影名");
                String film_name;
                while (true) {
                    film_name = in.next();
                    if (Save.films.containsKey(film_name)) break;
                    else System.out.println("电影名不存在，请重试");
                }
                receptionist.list_specific_room_information(film_name);
            }
            else if (i==4) {
                System.out.println("请输入电影名");
                String film_name;
                while (true) {
                    film_name = in.next();
                    if (Save.films.containsKey(film_name)) break;
                    else System.out.println("电影名不存在，请重试");
                }
                receptionist.list_specific_room_information(film_name);
                System.out.println("请输入座位行号");
                int row;
                while(true){
                    row= in.nextInt();
                    if(row>=1&&row<=7)break;
                    else System.out.println("无效的座位行号,请重试");
                }
                System.out.println("请输入座位列号");
                char col_char;
                while(true){
                    col_char= in.next().charAt(0);
                    if(col_char>='A'&&col_char<='L')break;
                    else System.out.println("无效的座位列号,请重试");
                }
                receptionist.sell_a_ticket(film_name,row,col_char);
            }
            else if(i==5){
                break;
            }
            else{
                System.out.println("错误的指令，请重新输入");
            }
        }
    }


}
