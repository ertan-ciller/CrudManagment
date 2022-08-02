import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {

        CrudManagment crudManagment = new CrudManagment();
        DbHelper dbHelper = new DbHelper();

        /*try {
            crudManagment.selectDemo();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }*/
        /*try {
            crudManagment.insertData();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }*/

        /*try {
            crudManagment.update();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }*/
        crudManagment.delete();


    }
}