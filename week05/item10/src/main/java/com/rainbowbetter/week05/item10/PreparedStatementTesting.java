package com.rainbowbetter.week05.item10;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class PreparedStatementTesting {
    static void processedThe(String dbUrl,String user,String password,String id) {
        //Class.forName("com.mysql.jdbc.Driver");


        Connection conn = DriverManager.getConnection(dbUrl, user, password);

        conn.setAutoCommit(false);//将自动提交关闭
        PreparedStatement pstmt = conn.prepareStatement("update Student set name=? where id=?");
        pstmt.setString(1);
        pstmt.setInt(2, id);
        pstmt.addBatch();
        pstmt.executeBatch();
        pstmt.close();


        conn.commit();
        conn.setAutoCommit(true);
        conn.close();
    }
}
