package ff;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TEST {

    public static void main(String[] args) {
        //����Connection����
        Connection con;
        //����������
        String driver = "com.mysql.jdbc.Driver";
        //URLָ��Ҫ���ʵ����ݿ���mydata
        String url = "jdbc:mysql://193.112.198.83:3306/lh";
        //MySQL����ʱ���û���
        String user = "lh";
        //MySQL����ʱ������
        String password = "123456";
        //������ѯ�����
        try {
            //������������
            Class.forName(driver);
            //1.getConnection()����������MySQL���ݿ⣡��
            con = DriverManager.getConnection(url,user,password);
            if(!con.isClosed())
                System.out.println("Succeeded connecting to the Database!");
            //2.����statement���������ִ��SQL��䣡��
            Statement statement = con.createStatement();
            //Ҫִ�е�SQL���
            String sql = "select * from user";
            //3.ResultSet�࣬������Ż�ȡ�Ľ��������
            ResultSet rs = statement.executeQuery(sql);
        /*    System.out.println("-----------------");
            System.out.println("ִ�н��������ʾ:");  
            System.out.println("-----------------");  
            System.out.println("����" + "\t" + "ְ��");  
            System.out.println("-----------------");  */
             
            String username = null;
            String pw = null;
            while(rs.next()){
                //��ȡstuname��������
            	username = rs.getString("uname");
                //��ȡstuid��������
                pw = rs.getString("password");

                //������
                System.out.println(username + "\t" + pw);
            }
            rs.close();
            con.close();
        } catch(ClassNotFoundException e) {   
            //���ݿ��������쳣����
            System.out.println("Sorry,can`t find the Driver!");   
            e.printStackTrace();   
            } catch(SQLException e) {
            //���ݿ�����ʧ���쳣����
            e.printStackTrace();  
            }catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }finally{
            System.out.println("���ݿ����ݳɹ���ȡ����");
        }
    }

}

