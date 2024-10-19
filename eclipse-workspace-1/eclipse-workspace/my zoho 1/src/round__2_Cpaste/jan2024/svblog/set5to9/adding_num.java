package round__2_Cpaste.jan2024.svblog.set5to9;
//.adding a digit to all the digits of a number eg digit=4, number = 2875, o/p= 612119
public class adding_num {
	int add(int num) {
		int len=num;
		int res=0;
		String ret="";
		int rem=0;
		while (len>0) {
			int last=len%10;
			last+=4;
			//last+=rem;
			ret=last+ret;
			rem=last/10;
//			if(last>=10) {
//				rem=last/10;
//				
//			}
			len=len/10;
			
			
		}
		System.out.println(ret);
		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		adding_num obj=new adding_num();
obj.add(2875);
	}

}
