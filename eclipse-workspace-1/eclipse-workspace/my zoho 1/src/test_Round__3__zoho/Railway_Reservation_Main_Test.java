package test_Round__3__zoho;
import java.util.*;
class Passenger{
	String name;
	int age;
	String gender;
	String Bearth;
	String Ticket_Status;
	public Passenger(String name,int age,String gender,String Bearth) {//public passenger(String name,int age,String gender,String Bearth) {
		this.name=name;
		this.age=age;
		this.gender=gender;
		this.Bearth=Bearth;
		this.Ticket_Status="waiting";
		
	}
	public String getname() {
		return name;
		
	}
	public String getgender() {
		return gender;
	}
	public String gerbearth() {
		return Bearth;
	}
	public int getage() {
		return age;
	}
	public void setticketstatus(String status) {
		Ticket_Status=status;
	}
	public String getticketstatus() {
		return Ticket_Status;
		
	}
	class Ticket{
		public Passenger passenger;
		Ticket(Passenger passenger){
			this.passenger=passenger;
		}
		public Passenger getpassenger() {
			return passenger;
		}
		
		
	}
	class Train{
		int total_bearth =63;
		int total_RAC=1;
		int total_waitinglist=18;
		Ticket[] bearthticket= new Ticket[total_bearth];
		Ticket[] rac_ticket=new Ticket[total_RAC];
		Ticket[]waiting_list=new Ticket[total_waitinglist];
		int filled_Ticket=0;
		public boolean Bookticket(Passenger passenger) {
			if (filled_Ticket>=total_bearth+total_RAC+total_waitinglist) {
				System.out.println("no availble tickets");
				return false;
			}
			if(passenger.getage()>60||(passenger.getgender().equalsIgnoreCase("female") && passenger.getage()>0)){
				if(filled_Ticket<total_bearth) {
					bearthticket[ filled_Ticket]=new Ticket(passenger);
					//filled_Ticket++;
					passenger.setticketstatus("confimed");
					}
					else if (filled_Ticket>=total_bearth&&filled_Ticket<total_bearth+total_RAC) {
						rac_ticket[ filled_Ticket-total_bearth]=new Ticket(passenger);
						//filled_Ticket++;
						passenger.setticketstatus("RAC");
						
					}
				}
				
			return true;		}
			
		}
		
		
	}
	
	//String Ticket_Status


public class Railway_Reservation_Main_Test {

}
