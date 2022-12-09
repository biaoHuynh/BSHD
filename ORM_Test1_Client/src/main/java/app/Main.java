package app;

import java.rmi.Naming;
import java.time.LocalDate;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import entity.Assignment;
import entity.Employee;
import entity.Project;
import services.AssignmentService;
import services.EmployeeService;
import services.ProjectService;

public class Main {
	public static void main(String[] args) {
		try {
			ProjectService projectService =  (ProjectService) Naming.lookup("rmi://localhost:8988/ProjectService");
			EmployeeService employeeService = (EmployeeService) Naming.lookup("rmi://localhost:8988/EmployeeService");
			AssignmentService assignmentService =  (AssignmentService) Naming.lookup("rmi://localhost:8988/AssignmentService");
			

			
			Project project = projectService.finProjectById("PR_02");
			Employee employee = employeeService.findEmployeeById("EM_01");
//			System.out.println(employee);
			Assignment assignment = new Assignment(employee, project, 5);
			assignmentService.addAssignMent(assignment);
//			System.out.println(isCreated);
			
//			Project project = new Project();
//			project.setId("PR_02");
//			project.setName("cc");
//			
//			projectService.addProject(project);
			
//			Employee employee = new Employee();
//			employee.setId("EM_01");
//			employee.setName("bao");
//			employee.setEmail("baocc");
//			long millis=System.currentTimeMillis();  
//			java.util.Date date=new java.util.Date(millis);  
//			employee.setHireDate(date);
//			
//			employeeService.addEmployee(employee);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
