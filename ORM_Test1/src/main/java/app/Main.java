package app;


import java.rmi.registry.LocateRegistry;
import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.InitialContext;

import dao.AssignmentDao;
import dao.EmployeeDao;
import dao.ProjectDao;
import services.AssignmentService;
import services.EmployeeService;
import services.ProjectService;

public class Main {
	public static void main(String[] args) {
		try {
			Hashtable<String, String> hashtable = new Hashtable<String, String>();
			hashtable.put("java.security.policy", "policy.policy");
			Context context = new InitialContext(hashtable);
			LocateRegistry.createRegistry(8988);
			
			ProjectService projectService = new ProjectDao();
			EmployeeService employeeService = new EmployeeDao();
			AssignmentService assignmentService = new AssignmentDao();
			
			context.bind("rmi://localhost:8988/ProjectService", projectService);
			context.bind("rmi://localhost:8988/EmployeeService", employeeService);
			context.bind("rmi://localhost:8988/AssignmentService", assignmentService);
			System.out.println("Server start port 8988 ...");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
