package Last_HW;

import java.io.*;
import java.net.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Client extends JFrame implements ActionListener {
    // Text fields for receiving inputs
    private JTextField jtfFirstInput = new JTextField();
    private JTextField jtfSecondInput = new JTextField();

    // Text area to display contents
    private JTextArea jta = new JTextArea();

    // IO streams
    private DataOutputStream outputToServer;
    private DataInputStream inputFromServer;

    public static void main(String[] args) {
        new Client();
    }

    public Client() {
        // Panel p to hold the label and text fields
        JPanel p = new JPanel(new GridLayout(2, 2));
        p.add(new JLabel("Enter Height"));
        p.add(jtfFirstInput);
        p.add(new JLabel("Enter Weight"));
        p.add(jtfSecondInput);

        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(p, BorderLayout.NORTH);
        getContentPane().add(new JScrollPane(jta), BorderLayout.CENTER);

        jtfFirstInput.addActionListener(this);
        jtfSecondInput.addActionListener(this);

        setTitle("Client");
        setSize(500, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        try {
            // Create a socket to connect to the server
            Socket socket = new Socket("localhost", 8000);

            // Create an input stream to receive data from the server
            inputFromServer = new DataInputStream(socket.getInputStream());

            // Create an output stream to send data to the server
            outputToServer = new DataOutputStream(socket.getOutputStream());
        } catch (IOException ex) {
            jta.append(ex.toString() + '\n');
        }
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() instanceof JTextField) {
            try {
                // Get the values from the text fields
                double height = Double.parseDouble(jtfFirstInput.getText().trim());
                double weight = Double.parseDouble(jtfSecondInput.getText().trim());

                // Send the inputs to the server
                outputToServer.writeDouble(height);
                outputToServer.flush();
                outputToServer.writeDouble(weight);
                outputToServer.flush();

                // Get result from the server
                double bmi = inputFromServer.readDouble();

                // Display the inputs and result
                jta.append("Height is " + height + "\n");
                jta.append("Weight is " + weight + "\n");
                jta.append("BMI received from the server is " + bmi + '\n');
            } catch (IOException ex) {
                System.err.println(ex);
            }
        }
    }
}

