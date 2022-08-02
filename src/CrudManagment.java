import java.sql.*;
import java.util.ArrayList;

public class CrudManagment {

    Connection connection =null; //bir tane boş connection oluşturuyoruz.
    DbHelper helper = new DbHelper(); //db Helper nesnemizi oluşturuyoruz bağlantımızı sağlayabilmek için.
    Statement statement = null; //SelectDemo methodunda istediğimi sorguyu yapabilmek için oluşturduğumuz Statment
    PreparedStatement preparedStatement =null; //? ? yardımıyla ekleyeceğimiz dataları preparedStatmenet olarak tanımlıyoruz.
    ResultSet resultSet = null;
    DbHelper dbHelper = new DbHelper();


    public void selectDemo()throws SQLException{


        connection = helper.getConnection();
        statement = connection.createStatement();
        String sql = "select ID,Name,CountryCode,District,Population from city";
        resultSet=statement.executeQuery(sql);
        ArrayList<City> citys=new ArrayList<City>();
        while (resultSet.next()){
            citys.add(new City(resultSet.getString("ID")
                    ,resultSet.getString("Name")
                    ,resultSet.getString("CountryCode"),
                    resultSet.getString("District"),
                    resultSet.getString("Population")));
        }
        System.out.println(citys);

    }

    public void insertData()throws SQLException{
        try {
            connection= helper.getConnection();
            String sql = "insert into city (Name, CountryCode, District, Population) values(?,?,?,?)";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,"düzce");
            preparedStatement.setString(2,"TUR");
            preparedStatement.setString(3,"Turkey");
            preparedStatement.setInt(4,124124);

            int result=preparedStatement.executeUpdate(); // insert ile eklediğmiz datadan kaç tane kayıt eklendiyse onu göstermeye yarıyor.
            System.out.println(result);
            System.out.println("Kayit Eklendi.!");

        }catch (SQLException exception){

            dbHelper.showErrorMessage(exception);

        }finally {
            connection.close();
        }

    }

    public void update()throws SQLException{

        try {
            connection= helper.getConnection();
            String sql = "update city set population = 1000000 , district='düzce' where id = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,4084);
            int result = preparedStatement.executeUpdate();
            System.out.println("Kayit guncellendi.");
        }catch (SQLException exception){
            dbHelper.showErrorMessage(exception);

        }finally {
            connection.close();
        }

    }
    public void delete(){

        try {
            connection= helper.getConnection();
            String sql = "delete from city where id = 4084";
            preparedStatement = connection.prepareStatement(sql);
            int result = preparedStatement.executeUpdate();
            System.out.println("Kayit silindi");
        }catch (SQLException exception){
            dbHelper.showErrorMessage(exception);

        }

    }
}
