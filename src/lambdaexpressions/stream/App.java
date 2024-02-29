package stream;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Optional;

public class App {

    //read file with stream
    public static void functional(String args) throws IOException{
        try (FileReader fr = new FileReader(args)) {
            BufferedReader br = new BufferedReader(fr);
            
            Optional<Integer> opt = br.lines()
                .map(line -> line.replaceAll("\\p{Punct}", "")) //string -> string
                .map(line -> line.split(" ")) //string -> string[]
                .filter(words -> words.length >= 7) //string[] -> boolean with predicate
                //.count();
                .map(words -> words.length)
                .reduce((acc, count) -> acc + count); //reduces uses binary operators which takes in 2 values and returns a 3rd value, returns an optional integer
                //(acc, count) refers to accumulator, value where
                // e.g. to sum arr[n], initialise sum = 0 --> acc
                // count =  arr[i]
                // loop for i in arr.length, sum + arr[i]
                
                System.out.printf("Total no. of lines is %d\n", opt.get());
        }
                
    }
    
    // read file without stream
    public static void imperative(String args) {

        try (FileReader fr = new FileReader(args)) {
            BufferedReader br = new BufferedReader(fr);
            String line;
            int total = 0;
            while (null != (line = br.readLine())) {

                // map string -> string
                line = line.replaceAll("\\p{Punct}", "");

                // map string -> string[]
                String[] words = line.split("");

                // filtering
                if (words.length < 7)
                    continue;

                // reduce count total lines
                total++;
            }

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    public static void main(String[] args) {

    }
}
