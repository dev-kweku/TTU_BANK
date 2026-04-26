package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountDAO {
    public Account getAccount(int id){
        String sql="SELECT * FROM accounts WHERE id = ?";
        try(Connection conn =DatabaseConfig.getConnection();
            PreparedStatement stmt=conn.prepareStatement(sql)){
            stmt.setInt(1,id);
            ResultSet rs=stmt.executeQuery();

            if(rs.next()){
                return new Account(
                        rs.getInt("id"),
                        rs.getString("owner_name"),
                        rs.getDouble("balance")
                );
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    public boolean updateBalance(int id,double newBalance){
        String sql="UPDATE accounts SET balance = ? WHERE id = ?";
        try(Connection conn=DatabaseConfig.getConnection();
        PreparedStatement stmt=conn.prepareStatement(sql)
        ){
            stmt.setDouble(1,newBalance);
            stmt.setInt(2,id);
            int rowAffected=stmt.executeUpdate();
            return rowAffected > 0;


        }catch(SQLException e){
            System.out.println("update failed: "+e.getMessage());
            return false;
        }
    }
}
