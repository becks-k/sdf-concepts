import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ReadFiles {
    public static void main(String[] args) {
        List<String> wordList = readTextFile3("text.txt");
        System.out.println(wordList);

        // try {
        //     String content = readFilesString("text.txt");
        //     System.out.println(content);
        // } catch (IOException ioe) {
        //     ioe.printStackTrace();
        // }

        // List<Path> pathList = getFilePaths("src");
        // System.out.println(pathList);

        // File dir = new File("src");
        // List<String> pathList2 = getFilePathsRecursive(dir);
        // System.out.println(pathList2);
        
    }


    /*Using FileReader and BufferedReader to read files*/
    public static List<String> readTextFile(String filePath) {
        List<String> wordList = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) { //filereader as lowest layer, followed by buffered reader
            String line;
            while ((line = br.readLine()) != null) {
                //leave out blank lines
                if(line.trim().length() <= 0)
                    continue;
                //System.out.print(line);
                wordList.add(line);
            }
        } catch (IOException ioe) {
            System.err.println(ioe);
        }
        return wordList;
    }


    /*Using FileInputStream, InputStreamReader and BufferedReader*/
    public static List<String> readTextFile2(String filePath) {
        List<String> wordList = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(filePath)))) {
            String line;
            while ((line = br.readLine()) != null) {
                //System.out.print(line);
                wordList.add(line);
            }
        } catch (IOException ioe) {
            System.err.println(ioe);
        }
        return wordList;
    }

    /*Using streams to read files, preferred!*/
    public static List<String> readTextFile3(String filePath) {
        List<String> wordList = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(filePath)))) {
            br.lines()
            .forEach(line -> {
                System.out.printf("stream: %s\n", line);
                wordList.add(line);
            });
        } catch (IOException ioe) {
            System.err.println(ioe);
        }
        return wordList;
        
    }



    /*Using Files.readString() from Java 11*/
    public static String readFilesString(String filePath) throws IOException {
        Path p = Path.of(filePath);
        String content = Files.readString(p);
        return content;
    }


    /*Get list of paths in subfolders of directory - method 1*/
    public static List<Path> getFilePaths(String directory) {
        List<Path> filePaths = new ArrayList<>();
        try {
            Path dirPath = Paths.get(directory);
            Files.walk(dirPath)
                .filter(Files::isRegularFile)
                .forEach(filePaths::add);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return filePaths;
    }

    /*Get list of string of paths in subfolders of directory*/
    //File dir = new File(directory); //string directory path name 
    public static List<String> getFilePathsRecursive(File dir) {
        List<String> filePaths = new ArrayList<>();
        File[] files = dir.listFiles();
        if (files != null) {
            for (File f : files) {
                if (f.isDirectory()) {
                    filePaths.addAll(getFilePathsRecursive(f));
                } else {
                    filePaths.add(f.getPath());
                    System.out.println("File path: " + f.getPath());
                }
            }
        }
        return filePaths;
    }
    
}