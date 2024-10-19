package round__3;
import java.util.HashMap;
import java.util.Stack;
class CustomDatabase {
    private CustomVariable[] variables;
    private int currentIndex;
    private CustomTransaction[] transactions;
    private int currentTransactionIndex;

    public CustomDatabase(int maxVariables, int maxTransactions) {
        variables = new CustomVariable[maxVariables];
        for (int i = 0; i < maxVariables; i++) {
            variables[i] = new CustomVariable();
        }
        currentIndex = 0;

        transactions = new CustomTransaction[maxTransactions];
        for (int i = 0; i < maxTransactions; i++) {
            transactions[i] = new CustomTransaction();
        }
        currentTransactionIndex = 0;
    }

    public void set(String key, String value) {
        variables[currentIndex].set(key, value);
    }

    public String get(String key) {
        return variables[currentIndex].get(key);
    }

    public void unset(String key) {
        variables[currentIndex].unset(key);
    }

    public int count(String value) {
        return variables[currentIndex].count(value);
    }

    public void begin() {
        currentTransactionIndex++;
        if (currentTransactionIndex >= transactions.length) {
            // Handle error: Transaction stack overflow
            return;
        }
        transactions[currentTransactionIndex].copyFrom(variables[currentIndex]);
        currentIndex = currentTransactionIndex;
    }

    public void rollback() {
        if (currentIndex > 0) {
            currentTransactionIndex--;
            currentIndex = currentTransactionIndex;
        }
    }

    public void commit() {
        if (currentIndex > 0) {
            transactions[currentTransactionIndex].copyTo(variables[currentIndex - 1]);
            currentIndex--;
            currentTransactionIndex--;
        }
    }
}

class CustomVariable {
   public String[] keys;
    public   String[] values;
  public   int size;

    public CustomVariable() {
        keys = new String[100];
        values = new String[100];
        size = 0;
    }

    public void set(String key, String value) {
        int index = indexOf(key);
        if (index == -1) {
            keys[size] = key;
            values[size] = value;
            size++;
        } else {
            values[index] = value;
        }
    }

    public String get(String key) {
        int index = indexOf(key);
        if (index != -1) {
            return values[index];
        }
        return "null";
    }

    public void unset(String key) {
        int index = indexOf(key);
        if (index != -1) {
            for (int i = index; i < size - 1; i++) {
                keys[i] = keys[i + 1];
                values[i] = values[i + 1];
            }
            size--;
        }
    }

    public int count(String value) {
        int count = 0;
        for (int i = 0; i < size; i++) {
            if (values[i].equals(value)) {
                count++;
            }
        }
        return count;
    }

    private int indexOf(String key) {
        for (int i = 0; i < size; i++) {
            if (keys[i].equals(key)) {
                return i;
            }
        }
        return -1;
    }
}

class CustomTransaction {
    private String[] keys;
    private String[] values;
    private int size;

    public CustomTransaction() {
        keys = new String[100];
        values = new String[100];
        size = 0;
    }

    public void copyFrom(CustomVariable variable) {
        for (int i = 0; i < variable.size; i++) {
            keys[i] = variable.keys[i];
            values[i] = variable.values[i];
        }
        size = variable.size;
    }

    public void copyTo(CustomVariable variable) {
        for (int i = 0; i < size; i++) {
            variable.set(keys[i], values[i]);
        }
    }
}

public class bankDatabse {
    public static void main(String[] args) {
        CustomDatabase customDB = new CustomDatabase(10, 10);

        // Your input commands here
        customDB.set("a", "20");
        System.out.println("GET a: " + customDB.get("a"));

        customDB.set("b", "30");
        System.out.println("GET b: " + customDB.get("b"));

        customDB.set("a", "10");
        System.out.println("GET a: " + customDB.get("a"));

        customDB.set("c", "30");
        System.out.println("COUNT 30: " + customDB.count("30"));

        customDB.unset("a");
        System.out.println("GET a: " + customDB.get("a"));

        customDB.begin();
        customDB.set("a", "30");
        System.out.println("GET a: " + customDB.get("a"));
    }
}


/*
class CustomDatabase {
    private HashMap<String, String> database;
    private Stack<CustomTransaction> transactionStack;

    public CustomDatabase() {
        database = new HashMap<>();
        transactionStack = new Stack<>();
    }

    public void set(String key, String value) {
        database.put(key, value);
    }

    public String get(String key) {
        return database.getOrDefault(key, "null");
    }

    public void unset(String key) {
        database.remove(key);
    }

    public int count(String value) {
        int count = 0;
        for (String key : database.keySet()) {
            if (database.get(key).equals(value)) {
                count++;
            }
        }
        return count;
    }

    public void begin() {
        transactionStack.push(new CustomTransaction(database));
    }

    public void rollback() {
        if (!transactionStack.isEmpty()) {
            database = transactionStack.pop().getSnapshot();
        }
    }

    public void commit() {
        while (!transactionStack.isEmpty()) {
            transactionStack.pop(); // Remove all transactions
        }
    }
}

class CustomTransaction {
    private HashMap<String, String> snapshot;

    public CustomTransaction(HashMap<String, String> database) {
        snapshot = new HashMap<>(database);
    }

    public HashMap<String, String> getSnapshot() {
        return snapshot;
    }
}

public class Main {
    public static void main(String[] args) {
        CustomDatabase customDB = new CustomDatabase();

        // Your input commands here
        customDB.set("a", "20");
        System.out.println("GET a: " + customDB.get("a"));

        customDB.set("b", "30");
        System.out.println("GET b: " + customDB.get("b"));

        customDB.set("a", "10");
        System.out.println("GET a: " + customDB.get("a"));

        customDB.set("c", "30");
        System.out.println("COUNT 30: " + customDB.count("30"));

        customDB.unset("a");
        System.out.println("GET a: " + customDB.get("a"));

        customDB.begin();
        customDB.set("a", "30");
        System.out.println("GET a: " + customDB.get("a"));

        customDB.rollback();
        System.out.println("GET a: " + customDB.get("a"));
    }
}
*/
//Round 3: Advanced Programming round [ 3 HRS ]
//
//This round is mainly based on data structure and oops concepts.
//No inbuilt collections are allowed. You need to implement on your own.
//
//Needs to discuss your approach before start solving the problem.
//
//Design a system with following functionalities,
//
//SET a variable
//GET a variable
//UNSET a variable
//COUNT NUMBERS OF VARIABLE with given value
//BEGIN — Begins a new transaction
//ROLLBACK — Roll back all the commands in the open transaction
//COMMIT — Commit the transaction
//EXAMPLE 1:
//
//SET a 20
//GET a 20
//SET b 30
//GET b 30
//SET a 10
//GET a 10
//UPDATE c 40 No variable named “c”
//SET c 30
//COUNT 30 2
//COUNT 40 null
//UNSET a
//GET a null
//
//EXAMPLE 2:
//
//GET a null
//SET a 30
//GET a 30
//
//EXAMPLE 3:
//
//SET a 30
//BEGIN
//GET a 30
//SET a 40
//GET a 40
//SET b 40
//GET b 40
//ROLLBACK
//GET b null
//GET a 30
//
//EXAMPLE 4:
//
//BEGIN
//SET a 40
//SET b 40
//SET c 50
//COUNT 40 2
//BEGIN
//COUNT 40 null
//COMMIT
//COUNT 40 2
//BEGIN
//SET c 10
//GET c 10
//ROLLBACK
//GET c 50
//
//
//#My solution in Python .
//dic = {}
//dic1 = {}
//while(1):
//    try:
//        query = [str(i) for i in raw_input().split(" ")]
//        # print query
//        # try:
//        if query[0] == "set":
//            dic[query[1]] = query[2]
//        elif query[0] == "unset":
//            dic[query[1]] = "null"
//        elif query[0] == "update":
//            dic[query[1]] = query[2]
//        elif query[0] == "get":
//            print dic[query[1]]
//        elif query[0] == "count":
//            count = 0
//            for i in dic:
//                if dic[i] == query[1]:
//                    count = count + 1
//            print count
//        elif query[0] == "begin":
//            while(query[0]!= "rollback"):
//                query = [str(i) for i in raw_input().split(" ")]
//                if query[0] == "set":
//                    dic1[query[1]] = query[2]
//                elif query[0] == "unset":
//                    dic1[query[1]] = "null"
//                elif query[0] == "update":
//                    dic1[query[1]] = query[2]
//                elif query[0] == "get":
//                    print dic1[query[1]]
//                elif query[0] == "count":
//                    count = 0
//                    for i in dic:
//                        if dic[i] == query[1]:
//                            count = count + 1
//                    print count
//    except KeyError:
//        print query[1]," is not present"
//        pass
//I used stack to solve the above modules.
//
//4 of us completed all the modules and called for technical round on next day.
