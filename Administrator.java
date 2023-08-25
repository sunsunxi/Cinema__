import java.util.Collection;
import java.lang.reflect.Type;

public class Administrator implements administrator_password_management,customer_management{
    public void reset_customer_password(int ID){
        Save.ID_password.replace(ID,"0000000");
    }//重置用户密码
    public void list_customer_information(){//列出用户信息
        Collection<Customer> value=Save.customers.values();
        for( Customer customer_listed:value)
        {
          customer_listed.show();
        }

    }

    @Override
    public void delete_customer_information(int ID) {//删除指定用户信息
        Save.customers.remove(ID);
        Save.ID_password.remove(ID);
    }

    @Override
    public void find_customer_information(int ID) {//查找用户信息
        Save.customers.get(ID).show();

    }
}
