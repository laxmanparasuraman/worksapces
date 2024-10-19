package round__2_Cpaste;
import java.util.*;

//public class Social_network_Stackoverflow {
//
//}
public class Social_network_Stackoverflow {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();   // No of friends
        sc.nextLine();
        HashSet<String> hs = new HashSet<>(); 
        List<String>ne1=new ArrayList<String>();// to store name of the John's friends 
        String invitation = "";
        for(int i =0; i < N; i++)
        {
      //  	String str1
            String str = sc.nextLine();
            String friend = "";
            int j =0;
            while(str.charAt(j)!= ' ')  
            {
                friend = friend + str.charAt(j++);
               // hs.add(friend);     // add the name before the number to HashSet
            }
            hs.add(friend);
            ne1.add(friend.toLowerCase());
            j= j+2;
            invitation=invitation+str.substring(j,str.length())+" "; // remove name of John's friend from the string and store back remaining string
        }        
        int j =0;
        StringTokenizer st = new StringTokenizer(invitation); // divide string into tokens
        while(st.hasMoreTokens())
        {
            String str = st.nextToken();
            //need   
//            if(!( hs.equalsIgoreCase(str)))   {
//                /* check if token(string) is already in hashset ie if the person already friend with John or not 
//                if he is not then print str 
//                */
//                System.out.print(str+" ");
//            }
        }///////////////
        List<String>ne=new ArrayList<String>( Arrays.asList(invitation.split(" ")) );
       // List<String>ne=new ArrayList<String>( Arrays.asList(invitation.split(" ")) )
        ne.removeAll(hs);
        ne.removeAll(ne1);
        System.out.println(hs);
        System.out.println(invitation);
        System.out.println(ne.toString().substring(1)+"chack");
         }
//   
//Mani 3 ram raj guna
//ram 2 kumar Kishore
//Mughil 3 praveen Naveen Ramesh
//   
}