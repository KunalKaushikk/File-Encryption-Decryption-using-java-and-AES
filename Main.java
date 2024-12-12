import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("AES File Encryption/Decryption");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel label = new JLabel("Select a file:");
        label.setBounds(20, 20, 200, 30);
        frame.add(label);

        JTextField filePathField = new JTextField();
        filePathField.setBounds(20, 60, 250, 30);
        frame.add(filePathField);

        JButton browseButton = new JButton("Browse");
        browseButton.setBounds(280, 60, 90, 30);
        frame.add(browseButton);

        JLabel keyLabel = new JLabel("Enter 16-byte Key:");
        keyLabel.setBounds(20, 100, 200, 30);
        frame.add(keyLabel);

        JTextField keyField = new JTextField();
        keyField.setBounds(20, 140, 250, 30);
        frame.add(keyField);

        JButton encryptButton = new JButton("Encrypt");
        encryptButton.setBounds(20, 200, 100, 30);
        frame.add(encryptButton);

        JButton decryptButton = new JButton("Decrypt");
        decryptButton.setBounds(140, 200, 100, 30);
        frame.add(decryptButton);

        browseButton.addActionListener(e -> {
            JFileChooser fileChooser = new JFileChooser();
            int option = fileChooser.showOpenDialog(frame);
            if (option == JFileChooser.APPROVE_OPTION) {
                File selectedFile = fileChooser.getSelectedFile();
                filePathField.setText(selectedFile.getAbsolutePath());
            }
        });

        encryptButton.addActionListener(e -> {
            String filePath = filePathField.getText();
            String key = keyField.getText();
            if (filePath.isEmpty() || key.length() != 16) {
                JOptionPane.showMessageDialog(frame, "Please provide a valid file and 16-byte key.");
                return;
            }
            try {
                File inputFile = new File(filePath);
                File outputFile = new File(filePath + ".enc");
                CryptoUtils.encrypt(key, inputFile, outputFile);
                DatabaseUtils.saveHistory(inputFile.getName(), "Encrypt");
                JOptionPane.showMessageDialog(frame, "File encrypted successfully!");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(frame, "Error: " + ex.getMessage());
            }
        });

        decryptButton.addActionListener(e -> {
            String filePath = filePathField.getText();
            String key = keyField.getText();
            if (filePath.isEmpty() || key.length() != 16) {
                JOptionPane.showMessageDialog(frame, "Please provide a valid file and 16-byte key.");
                return;
            }
            try {
                File inputFile = new File(filePath);
                File outputFile = new File(filePath.replace(".enc", ".dec"));
                CryptoUtils.decrypt(key, inputFile, outputFile);
                DatabaseUtils.saveHistory(inputFile.getName(), "Decrypt");
                JOptionPane.showMessageDialog(frame, "File decrypted successfully!");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(frame, "Error: " + ex.getMessage());
            }
        });

        frame.setLayout(null);
        frame.setVisible(true);
    }
}