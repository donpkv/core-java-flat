package dbprograms;

import java.sql.*;

public class DBConnectionTest {
   /* static String user ="user1";
    static String pswd ="1234";
   */
    //static String dbURL = "jdbc:derby:.\\dbsample.db;create=true;user="+user+";password="+pswd;
    static String user;
    static String password;
    static String dbURL;
    static Connection connection;
    DBConnectionTest(String dbURL,String user,String password)
    {
        this.dbURL =dbURL;
        this.user =user;
        this.password=password;
    }
    static Connection connectDB()
    {

           try {//org.apache.derby.jdbc.EmbeddedDriver"
                //Class.forName("org.apache.derby.jdbc.EmbeddedDriver").newInstance();
                Class.forName("com.mysql.jdbc.Driver").newInstance();
                System.out.println("Mysql Driver Class found and loaded!!!");
                if(connection==null) {
                    connection = DriverManager.getConnection(dbURL, user, password);      //gets a Connection object
                    System.out.println("Connected to DB!!");
                }
                else
                {
                    System.out.println("Error: Not connected to DB!!");

                }

            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
           catch (ClassNotFoundException e) {
            e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        return connection;
    }

    static void insertRecord(Connection connection)
    {
       String sql ="insert into book(title , author , price) values (?,?,?)";
        try {
           PreparedStatement pstat= connection.prepareStatement(sql);
            pstat.setString(1,"DbConnectionTest Program");
            pstat.setString(2,"Abhishek Vaishnav");
            pstat.setFloat(3,500);
            boolean flag =pstat.executeUpdate()>0;
            if(flag==true) {
                System.out.println("Inserted record!!");
            }
            else
            {
                System.out.println("Failed to insert record!!");

            }

            } catch (SQLException e) {
            e.printStackTrace();
        }

    }


    static void updateRecord(Connection connection)
    {
        String sql ="update book set price =? where book_id = ?";
        int id =13;
        try {
            PreparedStatement pstat= connection.prepareStatement(sql);
           /* pstat.setString(1,"DbConnectionTest Program");
            pstat.setString(2,"Abhishek Vaishnav");
           */
            pstat.setFloat(1,500);
            pstat.setFloat(2,id);

            boolean flag =pstat.executeUpdate()>0;
            if(flag==true) {
                System.out.println("Updated record for id "+id);
            }
            else
            {
                System.out.println("Failed to Update record!!");

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    static void deleteRecord(Connection connection)
    {
        String sql ="delete from book where book_id = ?";
        int id =16;
        try {
            PreparedStatement pstat= connection.prepareStatement(sql);
            pstat.setFloat(1,id);

            boolean flag =pstat.executeUpdate()>0;
            if(flag==true) {
                System.out.println("Deleted record for id "+id);
            }
            else
            {
                System.out.println("Failed to Delete record!!");

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    static void getResult(Connection connection)
    {
        String sql= "SELECT * FROM book;";
        try {
            Statement statement = connection.createStatement();
            ResultSet rs =statement.executeQuery(sql);
            while (rs.next())
            {
                System.out.println("ID :"+ rs.getString(1)+" Title :"+ rs.getString(2)
                        +" Author :"+ rs.getString(3)+" Price :"+ rs.getString(4));

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }


    public static void main(String[] args) throws SQLException {
        String user ="root";
        String pswd ="";
        String dbURL = "jdbc:mysql://localhost:3306/bookstore";
        DBConnectionTest dbConnectionTest = new DBConnectionTest(dbURL,user,pswd);
        Connection connection = connectDB();
        //insertRecord(connection);
        //updateRecord(connection);
        deleteRecord(connection);
        getResult(connection);

    }

}
