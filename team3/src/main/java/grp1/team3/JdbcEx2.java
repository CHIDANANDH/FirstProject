package grp1.team3;

import java.sql.*;
import java.util.Scanner;
//import java.util.Scanner;
public class JdbcEx2 {

	public static void main(String[] args) throws ClassNotFoundException,SQLException {
		Scanner sc=new Scanner(System.in);
		int no=sc.nextInt();
		String dna=sc.next();
		String loc=sc.next();
       Connection conn=null;
		Class.forName("oracle.jdbc.driver.OracleDriver");
		conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","scott","tiger");
		System.out.println("connected");

	
//         Statement st=conn.createStatement();
		
		PreparedStatement st=conn.prepareStatement("insert into dept values(?,?,?)");
	     st.setInt(1, no);
		st.setString(2, dna);
	    st.setString(3, loc);
	    st.executeUpdate();
	    
	    ResultSet rs=st.executeQuery("select * from dept");
	    while(rs.next())
			{
			System.out.print(rs.getInt(1)+"\t");
			System.out.print(rs.getString(2)+"\t");
			System.out.println(rs.getString(3)+"\t");
			}
	}

}

