    import java.sql.*;  
    class Database{  
    public static void main(String args[]){  
    try{  
    //step1 load the driver class  
    Class.forName("oracle.jdbc.driver.OracleDriver");  
      
    //step2 create  the connection object  
    Connection con=DriverManager.getConnection(  
    "jdbc:oracle:thin:@localhost:1521:xe","SYSTEM","tiger");  
      
    //step3 create the statement object  
    Statement stmt=con.createStatement();  	  
		
		ResultSet rs=stmt.executeQuery("select * from emp");  
		while(rs.next())
		{
			//String columnname = resultSet.getString("columnname");
			System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));
		}      
    //step5 close the connection object  
    con.close();  
      
    }catch(Exception e){ System.out.println(e);}  
      
    } 

	public void getMedicineAndDisease()
	{
		
	}
	
    }  