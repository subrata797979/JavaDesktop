package birthdayGui;
import java.sql.*;
import java.util.Scanner;

public class JdbcSimple {

	public static void main(String[] args) {
		try {
			Scanner sc = new Scanner(System.in);
			// step1 load the driver class
			Class.forName("oracle.jdbc.OracleDriver");

			// step2 create the connection object
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/xe", "java", "1");
			Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			
			
			while(true) {
				System.out.println("\n-----------------------------------------\n"
						+ "Enter your choice : " + "\n1. Add User" + "\n2. View User" + "\n3. Update User"
						+ "\n4. Delete User" + "\n5. Exit");
				int ch = sc.nextInt();

				switch(ch) {
				case 1:
					//addUser
					String sql = "insert into users values(seq.NEXTVAL,?,TO_DATE(?,'DD/MM/YYYY'),CURRENT_TIMESTAMP)";
					PreparedStatement pst = conn.prepareStatement(sql );
					
					sc.nextLine();
					
					System.out.println("Enter name : ");
					String name = sc.nextLine();
					pst.setString(1, name);
					
					System.out.print("Enter date in DD/MM/YYYY format : ");
					String date = sc.nextLine();
					pst.setString(2, date);
					
					int rowC = pst.executeUpdate();
					System.out.println(rowC + " updated!");
					break;
					
				case 2:
					//viewUser
					ResultSet rs = stmt.executeQuery("select * from users order by id asc");
					while(rs.next()) {
						System.out.println("[Id : " + rs.getInt(1) + "] [Name : " + rs.getString(2) + "] [birthDay : " + rs.getString(3) + "] [createdOn : " + rs.getTimestamp(4) + "]");						
					}
									
					break;
					
				case 3:
					//updateUser
					System.out.println("Enter id : ");
					int id = sc.nextInt();
					rs = stmt.executeQuery("select * from users order by id asc");
					
					System.out.println("Select field : \n1. name \n2. birthday");
					String field = null;
					int cho = sc.nextInt();
					if(cho == 1) field = "name"; 
					else if(cho == 2) field = "birthday"; 
					else {
						System.out.println("Enter again (Wrong Choice)!");
						break;
					}
					sc.nextLine();
					System.out.println("Enter field value : ");
					String value = sc.nextLine();
					int rowU = stmt.executeUpdate("update users set "+field+"='"+value+"' where id ="+id);
					System.out.println(rowU + " updated!");
					break;
					
				case 4:
					//deleteUser
					PreparedStatement pst3 = conn.prepareStatement("delete from users where id =?");
					System.out.println("Enter id : ");
					id = sc.nextInt();
					pst3.setInt(1, id);
					int rowD = pst3.executeUpdate();
					System.out.println(rowD + " deleted!");
					break;
					
				default: 
					break;
				}
			}
		} 
		catch (Exception e) {
			System.out.println(e);
		}
	}
}