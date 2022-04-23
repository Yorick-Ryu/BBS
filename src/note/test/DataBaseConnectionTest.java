package note.test;

import org.junit.jupiter.api.Test;
import note.util.DataBaseConnection;

class DataBaseConnectionTest {

    @Test
    void getConnection() {
        DataBaseConnection dataBaseConnection = new DataBaseConnection();
        if (dataBaseConnection.getConnection()!=null)
            System.out.println("数据库连接成功");
    }
}