package daoImpl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.util.Dbconnection;

import dao.EmployeeDAO;
import model.Employee;

public class EmployeeDAOImpl implements EmployeeDAO {
	public void createEmployee(Employee employee){
		Connection con = Dbconnection.connectDb();
		String sql = "insert into employees(emp_name,email,salary,doj,bonous)values(?,?,?,?,?)";
		try {
		PreparedStatement pst = con.prepareStatement(sql);
		pst.setString(1, employee.getEmp_name());
		pst.setString(2, employee.getEmail());
		pst.setDouble(3, employee.getSalary());
		pst.setString(4,employee.getDoj());
		pst.setInt(5, employee.getBonous());
		int executeUpdate = pst.executeUpdate();
		if(executeUpdate == 1) {
			System.out.println("created");
		}
		
	}
		catch(SQLException e) {
			System.out.println(e);
		}
		}
	
	public Employee getEmploeeById(int employeeId){
		Employee emp = new Employee();
		String SQL = "SELECT * FROM employees WHERE emp_id=?";
		try{
			Connection connection = Dbconnection.connectDb();
		 
				PreparedStatement pst = connection.prepareStatement(SQL);   
			
			pst.setInt(1, employeeId);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				int empid = rs.getInt("emp_id");
				String ename = rs.getString("emp_name");
				String email = rs.getString("emp_name");
				Double salary = rs.getDouble("salary");
				int bonous = rs.getInt("bonous");
				String doj = rs.getString("doj");
				
				emp.setEmp_id(empid);
				emp.setEmp_name(ename);
				emp.setEmail(email);
				emp.setSalary(salary);
				emp.setBonous(bonous);
				emp.setDoj(doj);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	
		return emp;
	}
	 public void updateEmployeeEmailById(String newEmail,int employeeId){
		 Connection con = Dbconnection.connectDb();
		 String sql="update employees set email=? where emp_id=?";
		 try {
			 PreparedStatement pst = con.prepareStatement(sql);
			 pst.setString(1,newEmail);
			 pst.setInt(2, employeeId);
			 int ans = pst.executeUpdate();
			 if(ans==1)
				 System.out.println("update");
			 }
		 catch(SQLException e){
			 System.out.println(e);
		 }
		
		 
	 }
	public void deleteEmployeeById(int employeeId){
		 Connection con = Dbconnection.connectDb();
		 String sql="delete from employees where emp_id=?";
		 
		 try {
			 PreparedStatement pst = con.prepareStatement(sql);
			 pst.setInt(1, employeeId);
			 int ans = pst.executeUpdate();
			 if(ans==1)
				 System.out.println("delete");
			 }
		 catch(SQLException e){
			 System.out.println(e);
		 }
		
	}
	public List<Employee> getAllEmployeesInfo(){
		List<Employee> empList = new ArrayList<>();
		
		String SQL = "SELECT *FROM employees";
		try {
			Connection connection = Dbconnection.connectDb();
			PreparedStatement ps = connection.prepareStatement(SQL);
		 
			
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Employee employee = new Employee();
				int empId = rs.getInt("emp_id");
				String eName = rs.getString("emp_name");
				String email = rs.getString("email");
				Double salary = rs.getDouble("salary");
				int bonous = rs.getInt("bonous");
				String date = rs.getString("doj");
				
				
				employee.setEmp_name(eName);
				
				employee.setBonous(bonous);
				employee.setDoj(date);
				employee.setEmail(email);
				employee.setEmp_id(empId);
				employee.setSalary(salary);
				
				empList.add(employee);
			}
			
		} catch (Exception e) {
			System.out.println(e);
		}
		return empList;
	
		
	}

}
