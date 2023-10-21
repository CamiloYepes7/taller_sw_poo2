/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mine;


public class Supervisor extends Worker {

    public Supervisor(String name, String ID) {
        super(name, ID);
    }
        @Override
    public void logWorkday(int startHour, int endHour) {
       
        super.logWorkday(startHour, endHour);
        if (startHour < 0 || startHour > 23 || endHour < 0 || endHour > 23) {
            System.out.println("You must enter valid start and end hours (0-23).");
            return;
        }

        int hoursWorkedToday = endHour - startHour;

        if (hoursWorkedToday >= 5) {
            hoursWorked += hoursWorkedToday;
            this.startHour = startHour;
            this.endHour = endHour;
        } else {
            System.out.println("You must work at least 8 hours.");
            int hoursRemaining = 5 - hoursWorkedToday;
            System.out.println("You need to complete " + hoursRemaining + " more hours.");
        }
    

    }
    @Override
public void logIncident(String incidentType, int days) {
        int daysUsed = 0;
        switch (incidentType) {
            case "Leaves": {
                int leaveType = 0;
                switch (leaveType) {
                    case 1:
                        if (days >= 1 && days <= 6) {
                            System.out.println("Temporary Leave incident registered for " + days + " days.");
                            daysUsed += days;
                        } else if (days > 6) {
                            System.out.println("You should take vacation instead of a temporary leave.");
                        } else {
                            System.out.println("Invalid number of days.");
                        }
                        break;
                    case 2:
                        if (days >= 1 && days <= 200) {
                            System.out.println("Maternity Leave incident registered for " + days + " days.");
                            daysUsed += days;
                        } else {
                            System.out.println("Invalid number of days.");
                        }
                        break;
                    case 3:
                        if (days >= 1 && days <= 17) {
                            System.out.println("Paternity Leave incident registered for " + days + " days.");
                            daysUsed += days;
                        } else {
                            System.out.println("Invalid number of days.");
                        }
                        break;
                    default:
                        System.out.println("Invalid leave option.");
                }
            }
            break;
            case "Incapacities":
                if (days >= 1 && days <= 22) {
                    System.out.println("Incapacity incident registered for " + days + " days.");
                    daysUsed += days;
                } else {
                    System.out.println("Invalid number of days.");
                }
                break;
            case "Vacations":
                if (days >= 1 && days <= 17) {
                    System.out.println("Vacation incident registered for " + days + " days.");
                    daysUsed += days;
                } else {
                    System.out.println("Invalid number of days.");
                }
                break;
            case "Permissions":
                if (days >= 1 && days <= 7) {
                    System.out.println("Permission incident registered for " + days + " hours.");
                    // Here, we treat hours as days for counting.
                    daysUsed += days;
                } else if (days > 7) {
                    System.out.println("It's better to take 1 day of vacation or temporary leave.");
                } else {
                    System.out.println("Invalid number of hours.");
                }
                break;
            default:
                System.out.println("Invalid incident type.");
        }

        int availableDays = 0;

        switch (incidentType) {
            case "Leaves":
            {
                int leaveType = 0;
                switch (leaveType) {
                    case 1: 
                        availableDays = 8 - daysUsed;
                        break;
                    case 2:
                        availableDays = 200- daysUsed;
                        break;
                    case 3:
                        availableDays = 17 - daysUsed;
                        break;
                }
            }
            break;

            case "Incapacities":
                availableDays = 22 - daysUsed;
                break;
            case "Vacations":
                availableDays = 17 - daysUsed;
                break;
            case "Permissions":
                availableDays = 7 - daysUsed;
                break;
        }

        System.out.println("Available days or hours: " + availableDays);
    }
}

