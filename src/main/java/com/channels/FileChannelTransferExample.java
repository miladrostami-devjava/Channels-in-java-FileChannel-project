package com.channels;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

public class FileChannelTransferExample {
    public static void main(String[] args) {
        // Define the path for input and output files
        String inputFile = "src/main/resources/input.txt";
        String outputFile = "src/main/resources/output.txt";

        // Using FileChannel for direct data transfer between two files
        try (
                // Create FileInputStream and FileOutputStream
                FileInputStream fis = new FileInputStream(inputFile);
                FileOutputStream fos = new FileOutputStream(outputFile);

                // Get channels from the file streams
                FileChannel inputChannel = fis.getChannel();
                FileChannel outputChannel = fos.getChannel()
        ) {
            // Transfer data directly between channels
            inputChannel.transferTo(0, inputChannel.size(), outputChannel);

            System.out.println("File copied successfully using transferTo!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
