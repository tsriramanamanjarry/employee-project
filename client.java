package Client;


import java.sql.Connection;
import java.util.List;
import java.util.Scanner;

import com.util.Dbconnection;

import dao.EmployeeDAO;
import daoImpl.EmployeeDAOImpl;
import model.Employee;
public class Clienttest {

	public static void main(String[] args) {
		
		 System.out.println("Welcome.....................");
		 Scanner s = new Scanner(System.in);
		 EmployeeDAOImpl employeeDAO = new EmployeeDAOImpl();
		 System.out.println("1.insert  2.update  3.delete  4.get one employee 5 getemployee list"); 
		 
		 int c1=1;
		 while(c1!=0) {
			 System.out.println("enter the choice");
			 int c= s.nextInt();
			 switch(c) {
			 case 1:
			 System.out.println("insertion");
			System.out.println("enter name");
				 String emp_name=s.nextLine();
				 s.nextLine();
				 System.out.println("enter id");
				String email =s.nextLine();
				 System.out.println("enter salary");
				 Double salary=s.nextDouble();
				s.nextLine();
				System.out.println("enter doj");
				String doj=s.nextLine();
				System.out.println("enter bonous");
				 int bonus=s.nextInt();
				 Employee e = new Employee( emp_name, email, salary, doj, bonus);
				 employeeDAO.createEmployee(e);
				 
				 break;
				
			 case 2:
				 System.out.println("update");
				 System.out.println("enter id to change");
				 int employeeId = s.nextInt();
				 System.out.println("enter the new email id");
				String newEmail = s.nextLine();
				employeeDAO.updateEmployeeEmailById(newEmail,employeeId);
				break;
			 case 3:
				 System.out.println("delete");
				System.out.println("enter the condition to delete");
				  int employeeId1 = s.nextInt();
				employeeDAO.deleteEmployeeById( employeeId1);
			 
			 case 4:
				 System.out.println("get on employee detail");
				System.out.println("enter the id to display");
					 int emp_id = s.nextInt();
			      System.out.println( employeeDAO.getEmploeeById(emp_id));	
			      break;
			      
			 case 5:
				 System.out.println("get on employees detail");
				 List<Employee> empList = employeeDAO.getAllEmployeesInfo();
			        for(Employee emp1 : empList)
			        {
			        	System.out.println(emp1);
			        }
			        	
			 break;
						
			 }
		 	System.out.println("enter the 1 when you want to edit it or diplay it (or) enter 0 to exit");
		 	 c1= s.nextInt();
			 
		 }
		 }
			 }

