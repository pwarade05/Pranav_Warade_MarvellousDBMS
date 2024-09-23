//////////////////////////////////////////////////////////////////////////////////////////////////
//                                                                                              //
//      Project Name : Customized Marvellous DBMS system                                        //
//      Concept Used : Java, Data Structure, Collection Framework                               //  
//      Author : Pranav Warade                                                                  //
//                                                                                              //
//////////////////////////////////////////////////////////////////////////////////////////////////

import java.util.*;

class Employee
{
    public int EID;
    public String Ename;
    public String EAddress;
    public String Edesignation;
    public int ESalary;

    private static int Counter;

    static      //it is a autogenerator which increament the value
    {
        Counter = 0;
    }

    public Employee(String Name, String Address, String Designation, int Salary)
    {
        this.EID = ++Counter;
        this.Ename = Name;
        this.EAddress = Address;
        this.Edesignation = Designation;
        this.ESalary = Salary;
    }

    void DisplayInfo()
    {
        System.out.println(EID+"\t"+Ename+"\t"+EAddress+"\t"+Edesignation+"\t"+ESalary);
    }
}

class MarvellousDBMS
{
    public LinkedList <Employee> lobj;

    public MarvellousDBMS()
    {
        System.out.println("Marvellous DBMS started succesfully.....");
        lobj = new LinkedList<Employee>();
    }

    protected void finalize()
    {
        System.out.println("Deallocating all resources of DBMS...");
        lobj = null;
    }

    // Insert into Employee Values("Sagar", "Pune", 10100);
    public void InsertIntoTable(String name, String address, String designation, int salary)
    {
        Employee eobj = new Employee(name, address, designation, salary);
        lobj.add(eobj);
    }

    //Select * from employee;
    public void SelectAll()
    {
        System.out.println("Data from the Employee Database :  ");

        System.out.println("\n------------------------------------------------------------------");
        System.out.println("EID\tEname\t\tEAddress\tEdesignation\tESalary");
        System.out.println("--------------------------------------------------------------------");

        for(Employee eRef : lobj)
        {
            eRef.DisplayInfo();
        }

        System.out.println("--------------------------------------------------------");
    }

    //Select * from  employee where Eid = Number;
    public void SelectSpecificId(int ID)
    {
        System.out.println("Information of Employee whose EID is : "+ID);

        System.out.println("--------------------------------------------------------------------");
        System.out.println("EID\tEname\t\tEAddress\tEdesignation\tESalary");
        System.out.println("--------------------------------------------------------------------");

        for(Employee eRef : lobj)
        {
            if(eRef.EID == ID)
            {
                eRef.DisplayInfo();
                break;
            }
        }
    }

    //Select * from  employee where Name;
    public void SelectSpecificName(String name)
    {
        System.out.println("Information of Employee whose Name is : "+name);

        System.out.println("--------------------------------------------------------------------");
        System.out.println("EID\tEname\t\tEAddress\tEdesignation\tESalary");
        System.out.println("--------------------------------------------------------------------");

        for(Employee eRef : lobj)
        {
            if(name.equals(eRef.Ename))
            {
                eRef.DisplayInfo();
                break;
            }
        }
    }

    //Select * from employee where Designation;
    public void SelectSpecificDesig(String designation)
    {
        System.out.println("Information of Employee whose designation is : "+designation);

        System.out.println("--------------------------------------------------------------------");
        System.out.println("EID\tEname\t\tEAddress\tEdesignation\tESalary");
        System.out.println("--------------------------------------------------------------------");

        for(Employee eRef : lobj)
        {
            if(designation.equals(eRef.Edesignation))
            {
                eRef.DisplayInfo();
                break;
            }
        }
    }

    //Delete from Employee where EID = number;
    public void DeleteFromEmpId(int ID)
    {
        int index = 0;
        boolean bflag = false;

        for(Employee eRef : lobj)
        {
            if(eRef.EID == ID)
            {
                bflag = true;
                break;
            }
            index++;
        }

        if(bflag == false)
        {
            System.out.println("Unable to delete the element from database as given ID is not present.");
        }
        else
        {
            lobj.remove(index);
            System.out.println("Delete successfully.....");
        }
    }

    //Delete from Employee where Ename = Name;
    public void DeleteFromEmpName(String name)
    {
        int index = 0;
        boolean bFlag = false;

        for(Employee eRef : lobj)
        {
            if(name.equals(eRef.Ename))
            {
                bFlag = true;
                break;
            }
            index++;
        }

        if(bFlag == false)
        {
            System.out.println("Unable to delete the elements from database as given name is not present.");
        }
        else
        {
            lobj.remove(index);
            System.out.println("Delete successfully.....");
        }
    }
    
    //Select Sum(Salary) from Employee;
    public void AggregateSum()
    {
        int iSum = 0;

        for(Employee eRef : lobj)
        {
            iSum = iSum + eRef.ESalary;
        }

        System.out.println("Summation of salary : "+iSum);
    }

    //Select Max(Salary) from Employee;
    public void AggregateMax()
    {
        int iMax = 0;

        for(Employee eRef : lobj)
        {
            if(eRef.ESalary > iMax )
            {
               iMax = eRef.ESalary;
            }
        }
        System.out.println("Maximum salary : "+iMax);
    }

    //Select Min(Salary) from Employee;
    public void AggregateMin()
    {
        Employee temp = lobj.get(0);
        int iMin = temp.ESalary;

        for(Employee eRef : lobj)
        {
            if(eRef.ESalary < iMin )
            {
               iMin = eRef.ESalary;
            }
        }
        System.out.println("Minimum salary : "+iMin);
    }

    //Select Min(Salary) from Employee;
    public void AggregateAvg()
    {
       int iSum = 0;

        for(Employee eRef : lobj)
        {
            iSum = iSum + eRef.ESalary;
        }
        System.out.println("Average salary : "+(iSum / lobj.size()));
    }

    // Select Count(Salary) from Employee;
    public void AggregateCount()
    {
        System.out.println("Number of Employees: "+lobj.size()+"\n");
    }
}


public class waradePranavDbms 
{
    public static void main(String[] args) 
    {
        System.out.println("\n--------------------- Marvellous Database Management System ---------------------\n");

        Scanner sobj = new Scanner(System.in);

        MarvellousDBMS mobj = new MarvellousDBMS();

        int iOption = 0;
        int Salary;
        int EID;

        String Name;
        String Address;
        String Designation;

        Employee eobj = null;

        while(true)
        {
            System.out.println("\n----------------------------------------------------------");
            System.out.println("Please select your choice based on your requirement: ");
            System.out.println("----------------------------------------------------------");

            System.out.println("1 : Insert new record into the table");

            System.out.println("2 : Display all records");

            System.out.println("3 : Display all records having specific EID");

            System.out.println("4 : Display all records having specific Name");

            System.out.println("5 : Display all records having specific Designation");

            System.out.println("6 : Delete the record based on EID");

            System.out.println("7 : Delete the record based on Employee name");

            System.out.println("8 : Display Sum of all salary");

            System.out.println("9 : Display Average of all salary");

            System.out.println("10 : Display Minimum from all salary");

            System.out.println("11 : Display Maximum from all salary");

            System.out.println("12 : Display the Count of records");

            System.out.println("13 : Display Help");

            System.out.println("14 : Display About");

            System.out.println("15 : Terminate the DBMS");
            System.out.println("------------------------------------------------------------");

            iOption = sobj.nextInt();

            switch(iOption)
            {
                // 1 : Insert new record into the table
                case 1 : 
                    System.out.println("Please enter the information of emplyee : \n");

                    System.out.println("Please enter Employee name :");
                    sobj.nextLine();
                    Name = sobj.nextLine();
                    System.out.print("\n");

                    System.out.println("Please enter Employee Address : ");
                    Address = sobj.nextLine();
                    System.out.print("\n");

                    System.out.println("Please enter Employee Designation : ");
                    Designation = sobj.nextLine();
                    System.out.print("\n");

                    System.out.println("Please enter Employee Salary : ");
                    Salary = sobj.nextInt();
                    System.out.print("\n");

                    mobj.InsertIntoTable(Name, Address, Designation, Salary);

                    break;
                
                // 2 : Display all records
                case 2 : 
                    mobj.SelectAll();

                    break;
                
                // 3 : Display all records having specific EID
                case 3 : 
                    System.out.println("Please enter the Employee ID whose information that you want to display");

                    EID = sobj.nextInt();

                    mobj.SelectSpecificId(EID);

                    break;

                // 4 : Display all records having specific Name
                case 4 : 
                    System.out.println("Please enter Employee name whose information that you want to display");
                    sobj.nextLine();
                    Name = sobj.nextLine();

                    mobj.SelectSpecificName(Name);

                    break;

                // 5 : Display all records having specific Designation
                case 5 :
                    System.out.println("Please enter Employee designation whose information that you want to display");

                    sobj.nextLine();
                    Designation = sobj.nextLine();

                    mobj.SelectSpecificDesig(Designation);

                    break;

                // 6 : Delete the record based on EID
                case 6 : 
                    System.out.println("Please enter the Employee ID whose information that you want to delete");

                    EID = sobj.nextInt();

                    mobj.DeleteFromEmpId(EID);

                    break;

                // 7 : Delete the record based on Employee name
                case 7 : 
                    System.out.println("Please enter the Employee Name whose information that you want to delete");
                    sobj.nextLine();

                    Name = sobj.nextLine();

                    mobj.DeleteFromEmpName(Name);

                    break;

                // 8 : Display Sum of all salary
                case 8 :
                    mobj.AggregateSum();

                    break;

                // 9 : Display Average of all salary
                case 9 :
                    mobj.AggregateAvg();

                    break;

                // 10 : Display Minimum from all salary 
                case 10 :
                    mobj.AggregateMin();

                    break;

                // 11 : Display Maximum from all salary
                case 11 :
                    mobj.AggregateMax();

                    break;

                // 12 : Display Count from all salary
                case 12 : 
                    mobj.AggregateCount();

                    break;

                // 13 : Display Help
                case 13 :
                    System.out.println("This project implements the DBMS for employee records");
                    System.out.println("We implement all SQL queries");
                    System.out.println("All data gets stored in Data structres");
                    System.out.println("Complete implementation is on Primary storage\n");
                    System.out.println("For furthure queries please contact on 1801 1199 9999.\n");

                    break;

                // 14 : Display About us
                case 14 :
                    System.out.println("This project developed by Marvellous Pranav Infosystems");
                    System.out.println("All copyrights. reserved..");

                    break;

                case 15 :
                    System.out.println("Thank you for using the Marvellous DBMS");
                    System.out.println("Visit Again!\n");
                    mobj = null;

                    System.gc();

                    System.exit(0);
            }
        }
    }
}