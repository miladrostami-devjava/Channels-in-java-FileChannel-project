package com.channels;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class FileChannelExampleForCopy {
    public static void main(String[] args) {
        // Define the path for input and output files
        String inputFile = "src/main/resources/input.txt";
        String outputFile = "src/main/resources/output.txt";

        // Using FileChannel to read from and write to files
        try (
                // Create FileInputStream and FileOutputStream
                FileInputStream fis = new FileInputStream(inputFile);
                FileOutputStream fos = new FileOutputStream(outputFile);

                // Get channels from the file streams
                FileChannel inputChannel = fis.getChannel();
                FileChannel outputChannel = fos.getChannel()
        ) {
            // Create a ByteBuffer for storing data
            ByteBuffer buffer = ByteBuffer.allocate(1024);

            // Read data from the input channel and write to the output channel
            while (inputChannel.read(buffer) != -1) {
                buffer.flip(); // Change buffer mode from writing to reading
                outputChannel.write(buffer); // Write data from buffer to output channel
                buffer.clear(); // Clear buffer for next read operation
            }

            System.out.println("File copied successfully!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

