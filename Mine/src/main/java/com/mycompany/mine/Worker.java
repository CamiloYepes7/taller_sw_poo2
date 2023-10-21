
package com.mycompany.mine;

public class Worker {
    private String name;
    private String ID;
    int hoursWorked;
    int startHour;
    int endHour;

    public Worker(String name, String ID) {
        this.name = name;
        this.ID = ID;
        this.hoursWorked = 0;
        this.startHour = 0;
        this.endHour = 0;
    }
        

    public int getHoursWorked() {
        return hoursWorked;
    }

    public int getStartHour() {
        return startHour;
    }

    public int getEndHour() {
        return endHour;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public void setHoursWorked(int hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    public void setStartHour(int startHour) {
        this.startHour = startHour;
    }

    public void setEndHour(int endHour) {
        this.endHour = endHour;
    }


    public void logWorkday(int startHour, int endHour) {
        if (startHour < 0 || startHour > 23 || endHour < 0 || endHour > 23) {
            System.out.println("You must enter valid start and end hours (0-23).");
            return;
        }

        int hoursWorkedToday = endHour - startHour;

        if (hoursWorkedToday >= 8) {
            hoursWorked += hoursWorkedToday;
            this.startHour = startHour;
            this.endHour = endHour;
        } else {
            System.out.println("You must work at least 8 hours.");
            int hoursRemaining = 8 - hoursWorkedToday;
            System.out.println("You need to complete " + hoursRemaining + " more hours.");
        }
    }
    public void logIncident(String incidentType, int days) {
        int daysUsed = 0;
        switch (incidentType) {
            case "Leaves": {
                int leaveType = 0;
                switch (leaveType) {
                    case 1:
                        if (days >= 1 && days <= 4) {
                            System.out.println("Temporary Leave incident registered for " + days + " days.");
                            daysUsed += days;
                        } else if (days > 4) {
                            System.out.println("You should take vacation instead of a temporary leave.");
                        } else {
                            System.out.println("Invalid number of days.");
                        }
                        break;
                    case 2:
                        if (days >= 1 && days <= 180) {
                            System.out.println("Maternity Leave incident registered for " + days + " days.");
                            daysUsed += days;
                        } else {
                            System.out.println("Invalid number of days.");
                        }
                        break;
                    case 3:
                        if (days >= 1 && days <= 15) {
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
                if (days >= 1 && days <= 20) {
                    System.out.println("Incapacity incident registered for " + days + " days.");
                    daysUsed += days;
                } else {
                    System.out.println("Invalid number of days.");
                }
                break;
            case "Vacations":
                if (days >= 1 && days <= 15) {
                    System.out.println("Vacation incident registered for " + days + " days.");
                    daysUsed += days;
                } else {
                    System.out.println("Invalid number of days.");
                }
                break;
            case "Permissions":
                if (days >= 1 && days <= 5) {
                    System.out.println("Permission incident registered for " + days + " hours.");
                    // Here, we treat hours as days for counting.
                    daysUsed += days;
                } else if (days > 5) {
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
                        availableDays = 4 - daysUsed;
                        break;
                    case 2:
                        availableDays = 180 - daysUsed;
                        break;
                    case 3:
                        availableDays = 15 - daysUsed;
                        break;
                }
            }
            break;

            case "Incapacities":
                availableDays = 20 - daysUsed;
                break;
            case "Vacations":
                availableDays = 15 - daysUsed;
                break;
            case "Permissions":
                availableDays = 5 - daysUsed;
                break;
        }

        System.out.println("Available days or hours: " + availableDays);
    }
}