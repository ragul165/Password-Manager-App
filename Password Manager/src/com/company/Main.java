package com.company;
import java.util.*;
import java.lang.*;
import java.sql.*;
public class Main {
    private void menu(){
        Scanner in= new Scanner(System.in);
        System.out.println("-----------------------------------------");
        System.out.print("Enter 1 for Login or Enter 2 for SinUp for new Account: ");
        int n=in.nextInt();
        switch(n){
            case 1:
                sinUp();
                break;
            case 2:
                login();
                break;
            default:
                menu();
        }
    }
    private void login(){
        Scanner cin= new Scanner(System.in);
        System.out.println("-----------------------------------------");
        System.out.print("Enter username: ");
        String username=cin.nextLine();
        System.out.print("Enter Password: ");
        String password=cin.nextLine();
        String url="jdbc:mysql://127.0.0.1:3306/users";
        String uname="root";
        String pass="Ragul@16";
        String query="select * from sinUp";
        try {
            //Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection(url,uname,pass);
            Statement st=con.createStatement();
            ResultSet rs=st.executeQuery(query);
            while(rs.next()) {
                //       System.out.println("DataBAse connected");
                String name=rs.getString("username");
                String pass_w=rs.getString("passw");
                //System.out.println(name);
                if(name.equals(username) && pass_w.equals(password) ){
                    System.out.println("Success");
                }
                else{
                    System.out.println("Username or password is wrong");
                }
            }
            st.close();
            con.close();
        }
        catch(Exception ae) {
            System.out.println("Database not connected");
        }
    }
    private void sinUp(){
        Scanner cin= new Scanner(System.in);
        System.out.println("-----------------------------------------");
        System.out.print("Enter username: ");
        String username=cin.nextLine();
        while(username.length()<4){
            System.out.println("username must contain 5 characters");
            System.out.print("Enter username: ");
            username=cin.nextLine();
        }
        System.out.print("Enter Password: ");
        String password=cin.nextLine();
        while(password.length()<8){
            System.out.println("password must contain 8 characters");
            System.out.print("Enter password: ");
            password=cin.nextLine();
        }
        System.out.println("-----------------------------------------");
        System.out.println(username+" "+password);
        String url="jdbc:mysql://127.0.0.1:3306/users";
        String uname="root";
        String pass="Ragul@16";
        String query="insert into sinUp values('"+ username+"','"+password+"');";
        try {
            //Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection(url,uname,pass);
            Statement st=con.createStatement();
            int r=st.executeUpdate(query);
            /*while(rs.next()) {
                //       System.out.println("DataBAse connected");
                String name=rs.getString("username");
                System.out.println(name);
            }*/
            System.out.println(r);
            st.close();
            con.close();
            login();
        }
        catch(Exception ae) {
            System.out.println("Database not connected");
        }
    }
    public static void main(String[] args) {

        Main m = new Main();
        m.menu();
         /*String url="jdbc:mysql://127.0.0.1:3306/users";
        String uname="root";
        String pass="Ragul@16";
        String query="select sname from sinUp_reg";
        try {
            //Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection(url,uname,pass);
            Statement st=con.createStatement();
            ResultSet rs=st.executeQuery(query);
            while(rs.next()) {
                //       System.out.println("DataBAse connected");
                String name=rs.getString("sname");
                System.out.println(name);
            }
            st.close();
            con.close();
        }
        catch(Exception ae) {
            System.out.println("Database not connected");
    }
    */
    }
    }

