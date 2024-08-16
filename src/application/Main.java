package application;

import java.sql.Connection;

import bd.BD;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection connection = BD.getConnection();
		BD.closeConnection();
	}

}
