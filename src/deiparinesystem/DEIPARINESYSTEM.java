
package deiparinesystem;
import java.util.Scanner;

public class DEIPARINESYSTEM {
    
    public void addCusto(){
        Scanner sc = new Scanner(System.in);
        config conf = new config();
        System.out.print("First Name: ");
        String fname = sc.next();
        System.out.print("Last Name: ");
        String lname = sc.next();
        System.out.print("Address: ");
        String email = sc.next();
        System.out.print("Phone No: ");
        String phone = sc.next();
        System.out.print("Plate No: ");
        String plate = sc.next();
        System.out.print("Hours to park: ");
        String hours = sc.next();
        System.out.print("Status: ");
        String status = sc.next();
        
        String sql = "INSERT INTO tbl_park (c_fname, c_lname, email, phone, plate, hours, status) VALUES (?,?, ?, ?, ?, ?,?)";
        conf.addRecord(sql, fname, lname, email, phone, plate, hours, status);


    }

        
    private void viewCusto() {
        String cqry = "SELECT * FROM tbl_park";
        String[] votersHeaders = {"ID", "FIRST NAME", "LAST NAME", "EMAIL", "PHONE NO" ,"PLATE" , "HOURS TO PARK", "STATUS"};
        String[] votersColumns = {"c_id", "c_fname", "c_lname", "email", "phone", "plate", "hours", "status"};
        config conf = new config();
        conf.viewRecords(cqry, votersHeaders, votersColumns);
    }

    private void updateCusto(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter ID ");
        int id = sc.nextInt();

        System.out.println("Enter the new hours");
        String hours = sc.next();

        System.out.println("Enter the new status");
        String status = sc.next();

        String qry = "UPDATE tbl_park SET hours = ?, status = ? WHERE c_id = ?";

        config conf = new config();
        conf.updateRecord(qry, hours, status, id);
    }

    private void deleteCusto(){

        Scanner sc= new Scanner(System.in);
        System.out.print("Enter the ID to Delete: ");
        int id = sc.nextInt();

        String qry = "DELETE FROM tbl_park WHERE c_id = ?";

        config conf = new config();
        conf.deleteRecord(qry, id);

    }
    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String response;
    do {
        System.out.println("1. Add");
        System.out.println("2. View");
        System.out.println("3. Update");
        System.out.println("4. Delete");
        System.out.println("5. Exit");

        System.out.println("Enter Action: ");
        int action = sc.nextInt();
        DEIPARINESYSTEM demo = new DEIPARINESYSTEM();

        switch (action) {
            case 1:                
                demo.addCusto();
                break;
            case 2:              
                demo.viewCusto();
                break;
            case 3:
                demo.updateCusto();
                break;
            case 4:
                demo.deleteCusto();
                break;
        }

        System.out.println("Continue (yes/no): ");
        response = sc.next();
    } while (response.equals("yes"));
    System.out.println("Thank you, See you soon!");
}

}    
    

