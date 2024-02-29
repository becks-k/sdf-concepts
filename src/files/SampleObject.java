import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SampleObject {

    private String name;
    private List<String> itemList = new ArrayList<>();
    private final int id;

    public SampleObject(String name, List<String> itemList) {
        this.name = name;
        this.itemList = itemList;
        this.id = generateRandNo();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getItemList() {
        return itemList;
    }

    public void setItemList(List<String> itemList) {
        this.itemList = itemList;
    }

    public int getId() {
        return id;
    }

    public int generateRandNo() {
        Random rand = new Random();
        int num = rand.nextInt(999) + 1000;
        return num;
    }

    // public static void main(String[] args) {
    //     Random rand = new Random();
    //     int num = rand.nextInt(999) + 1000; //generates a random 4 digit no from 0 - 1999
    //     System.out.println(num);
    // }


}
