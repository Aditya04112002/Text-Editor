/**
 * file: Editor.java
 * author: Aditya Vardhan Singh
 * version: B_v2_1
 * date: 11-Aug-2023
 * brief: Text Editor, which takes input on the console/shell,
 *        and stores the entered data in a specified file. The
 *        file can be an existing or a new file.
 */

import java.io.*;

public class Editor {
    
    public static void main(String[] args) {
        
        try {
            // BufferedReader object for input: br
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            
            // Input file name, new or existing
            System.out.println("Enter new or existing file name: ");
            String fileName = br.readLine();

            // Selecting file
            File file = new File(fileName);

            // If file doesn't exist, creating new file and print message
            if(!file.exists()) {
                boolean created = file.createNewFile();
                if (created) {
                    System.out.println("New file created: " + fileName);
                } else {
                    System.out.println("File creation failed");
                }
            }

            // Writing on file
            FileWriter writer = new FileWriter(file, true); // Append on existing content
            BufferedWriter bw = new BufferedWriter(writer); // BufferedWriter object for writing/output: bw

            System.out.println("Enter text: (enter 'exit' to quit)\n");
            String input;
            while (true) { // Forever loop
                input = br.readLine();
                if(input.equalsIgnoreCase("exit")) break; // Base case to end loop: reads 'exit' on a new line
                bw.write(input);
                bw.newLine(); // Change line
            }

            bw.close();
            System.out.println("Data successfully written on file: " + fileName);
            br.close();
        } catch (IOException e) { // IOException handling
            e.printStackTrace();
        }
        
    }
    
}
