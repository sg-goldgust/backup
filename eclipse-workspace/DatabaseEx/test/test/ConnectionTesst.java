package test;

import java.sql.Connection;

import edu.autocar.dbtest.dao.ConnectionProvider;

public class ConnectionTesst {
	public static void main(String[] args) {
		
		Connection conn = ConnectionProvider.getConnection();
		
		ConnectionProvider.close();
	}
}
