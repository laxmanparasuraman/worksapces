package Range_10_96_106;

public class _96_introToOops {
    public static void main(String[] args) {
        System.out.println("begin");

        Student laxman=new Student();
        laxman.name="laxman";
        laxman.address="null";
        laxman.email="mailoo";

        Student og=new Student();
        Student ogCopy=new Student();
        og


        /*
        hld- design of differnt

        when we go into internal the only differnce btw the different infrastrasture layer


     procedureal programming

      1 we divide our codebase into a bunch of procedure
      2 every procedure may internally call other procedure
      3 execute of a program start from a speial procedure (main)

      Procedure : set of instruction


      oops

      Entities Performing actions
      Actions are happening  on entity

   struct is like a clss with no behaviour means   no methods and only attributes

   ----------pillars of oops
            1 inheritance
            2 polymorphism
            3 Encapsulation


            principles of opps
              1 Abstraction

         Abstraction --::--     represent something as ideas

                         2 as a client, we dont need  to care about how that ideas works internally we only care about '


  Encapsulation :



        */
    }
}

   class  Student {
    int age;
    String name;
    String address;
    String email;
    String batch;
    String state;


    void  ChangeBatch(String   NewBatch){
        this.batch=NewBatch;
    }

}
