import java.util.ArrayList;

public class Person {
    String name;
    String phone_number;
    int[] usr_personality;
    ArrayList<String> usr_interests;

    Person(String name, String phone_number){
        this.name = name;
        this.phone_number = phone_number;
        this.usr_personality = new int[4];
        this.usr_interests = new ArrayList<String>();
    }
}
