package Bordfodboldturnering;

import java.sql.*;
import java.util.ArrayList;

class DBConnector {

    // database URL
    static final String DB_URL = "jdbc:mysql://localhost/Bordfodbold";
    //  Database credentials
    static final String USER = "root";
    static final String PASS = "A1n2d3e4r5s6";
    public ArrayList<String> readFieldData() {
        ArrayList<String> hold_data = new ArrayList<>() ;
        Connection conn = null;
        Statement stmt = null;
        try{
            //STEP 2: Register JDBC driver
            // Class.forName("com.mysql.jdbc.Driver");

            //STEP 3: Open a connection
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL,USER,PASS);

            //STEP 4: Execute a query
            System.out.println("Creating statement...");
            stmt = conn.createStatement();


            String sql = "SELECT * FROM Hold";
            ResultSet rs = stmt.executeQuery(sql);
            System.out.println(rs);
            System.out.println("Speed bumb");
            //STEP 5: Extract data from result set
            int speedbumb = 0;
            while(rs.next()){

                //Retrieve by column name
                int id  = rs.getInt("holdid");
                String holdNavn = rs.getString("holdNavn");
                int holdMedlemmer = rs.getInt("holdMedlemmer");
                String placeholder= id+","+holdNavn+","+holdMedlemmer;
                hold_data.add(placeholder);
                System.out.println(hold_data.get(speedbumb));
                speedbumb++;
            }
            //STEP 6: Clean-up environment
            rs.close();
            stmt.close();
            conn.close();
        }catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
        }catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
        }finally{
            //finally block used to close resources
            try{
                if(stmt!=null)
                    stmt.close();
            }catch(SQLException se2){
            }// nothing we can do
            try{
                if(conn!=null)
                    conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }//end finally try
        }//end try


        return hold_data;
    }

}

