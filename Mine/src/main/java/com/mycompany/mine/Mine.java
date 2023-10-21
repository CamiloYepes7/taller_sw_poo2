package com.mycompany.mine;

import java.util.Scanner;
import static javax.swing.text.html.HTML.Attribute.ID;

public class Mine {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the worker's name: ");
        String name = scanner.nextLine();

        System.out.print("Enter the worker's ID: ");
        String ID = scanner.nextLine();

        Worker worker = new Worker(name, ID);

        int option;
        do {
            System.out.println("\nSelect an option:");
            System.out.println("1. Log Workday");
            System.out.println("2. Log Incident");
            System.out.println("3. Exit");
            option = scanner.nextInt();

            switch (option) {
                case 1:
                    System.out.print("Enter the start hour (0-23): ");
                    int startHour = scanner.nextInt();

                    System.out.print("Enter the end hour (0-23): ");
                    int endHour = scanner.nextInt();

                    worker.logWorkday(startHour, endHour);
                    break;
                case 2:
                    System.out.println("Select the type of incident:");
                    System.out.println("1. Licenses");
                    System.out.println("2. Incapacities");
                    System.out.println("3. Vacations");
                    System.out.println("4. Permissions");
                    int incidentType = scanner.nextInt();
                    scanner.nextLine(); 

                    switch (incidentType) {
                        case 1:
                            System.out.println("Select the type of license:");
                            System.out.println("1. Temporary");
                            System.out.println("2. Maternity");
                            System.out.println("3. Paternity");
                            int licenseType = scanner.nextInt();
                            scanner.nextLine(); 

                            System.out.print("Enter the number of days: ");
                            int licenseDays = scanner.nextInt();
                            scanner.nextLine(); 

                            switch (licenseType) {
                                case 1:
                                    worker.logIncident("Licenses Temporary", licenseDays);
                                    break;
                                case 2:
                                    worker.logIncident("Licenses Maternity", licenseDays);
                                    break;
                                case 3:
                                    worker.logIncident("Licenses Paternity", licenseDays);
                                    break;
                                default:
                                    System.out.println("Invalid license option.");
                            }
                            break;
                        case 2:
                            System.out.print("Enter the number of days of Incapacity: ");
                            int incapacityDays = scanner.nextInt();
                            scanner.nextLine(); 
                            worker.logIncident("Incapacities", incapacityDays);
                            break;
                        case 3:
                            System.out.print("Enter the number of days of Vacation: ");
                            int vacationDays = scanner.nextInt();
                            scanner.nextLine(); 
                            worker.logIncident("Vacations", vacationDays);
                            break;
                        case 4:
                            System.out.print("Enter the number of hours of Permission: ");
                            int permissionHours = scanner.nextInt();
                            scanner.nextLine(); 
                            worker.logIncident("Permissions", permissionHours);
                            break;
                        default:
                            System.out.println("Invalid option.");
                    }
                    break;
                case 3:
                    System.out.println("Exiting");
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        } while (option != 3);

        System.out.println("Total hours worked: " + worker.getHoursWorked());
        
        {

   
        
        Supervisor supervisor = new Supervisor(name, ID);
          
        System.out.print("Enter the supervisor name: ");
        String supervisorname = scanner.nextLine();

        System.out.print("Enter the supervisor ID: ");
        String supervisorID = scanner.nextLine();
        
        
        do {
            System.out.println("\nSelect an option:");
            System.out.println("1. Log Workday");
            System.out.println("2. Log Incident");
            System.out.println("3. Exit");
            option = scanner.nextInt();

            switch (option) {
                case 1:
                    System.out.print("Enter the start hour (0-23): ");
                    int startHour = scanner.nextInt();

                    System.out.print("Enter the end hour (0-23): ");
                    int endHour = scanner.nextInt();

                 supervisor.logWorkday(startHour, endHour);
                    break;
                case 2:
                    System.out.println("Select the type of incident:");
                    System.out.println("1. Licenses");
                    System.out.println("2. Incapacities");
                    System.out.println("3. Vacations");
                    System.out.println("4. Permissions");
                    int incidentType = scanner.nextInt();
                    scanner.nextLine(); 

                    switch (incidentType) {
                        case 1:
                            System.out.println("Select the type of license:");
                            System.out.println("1. Temporary");
                            System.out.println("2. Maternity");
                            System.out.println("3. Paternity");
                            int licenseType = scanner.nextInt();
                            scanner.nextLine(); 

                            System.out.print("Enter the number of days: ");
                            int licenseDays = scanner.nextInt();
                            scanner.nextLine(); 

                            switch (licenseType) {
                                case 1:
                                    supervisor.logIncident("Licenses Temporary", licenseDays);
                                    break;
                                case 2:
                                    supervisor.logIncident("Licenses Maternity", licenseDays);
                                    break;
                                case 3:
                                    supervisor.logIncident("Licenses Paternity", licenseDays);
                                    break;
                                default:
                                    System.out.println("Invalid license option.");
                            }
                            break;
                        case 2:
                            System.out.print("Enter the number of days of Incapacity: ");
                            int incapacityDays = scanner.nextInt();
                            scanner.nextLine(); 
                            supervisor.logIncident("Incapacities", incapacityDays);
                            break;
                        case 3:
                            System.out.print("Enter the number of days of Vacation: ");
                            int vacationDays = scanner.nextInt();
                            scanner.nextLine(); 
                            supervisor.logIncident("Vacations", vacationDays);
                            break;
                        case 4:
                            System.out.print("Enter the number of hours of Permission: ");
                            int permissionHours = scanner.nextInt();
                            scanner.nextLine(); 
                            supervisor.logIncident("Permissions", permissionHours);
                            break;
                        default:
                            System.out.println("Invalid option.");
                    }
                    break;
                case 3:
                    System.out.println("Exiting");
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        } while (option != 3);

        System.out.println(supervisor.getHoursWorked() + "Total hours worked: ");
    }
    }
}
