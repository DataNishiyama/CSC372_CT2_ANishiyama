//Import Utilities
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MarineNavyBank extends JFrame {

    //Initial Balance
    private double balance = 0.0;

    //Panel with buttons
    private JPanel panel;
    private JButton depositButton;
    private JButton withdrawButton;
    private JButton showBalanceButton;

    public MarineNavyBank() {
        // Set up the JFrame
        setTitle("Marine Navy Bank");
        setSize(300, 200);

        //Avoid Default Close to Show Balance
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        //App Components
        panel = new JPanel();
        depositButton = new JButton("Deposit");
        withdrawButton = new JButton("Withdraw");
        showBalanceButton = new JButton("Show Balance");

        //Add Components to panel
        panel.add(depositButton);
        panel.add(withdrawButton);
        panel.add(showBalanceButton);

        // Add the panel to the JFrame
        add(panel);

        // Action Listeners
        depositButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.invokeLater(() -> depositFunds());
            }
        });

        withdrawButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.invokeLater(() -> withdrawFunds());
            }
        });

        showBalanceButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showBalance();
            }
        });

        //Window Listener
        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                showBalance();
                // Close the application
                dispose();
            }
        });
    }

    //Deposit Funds
    private void depositFunds() {
        String input = JOptionPane.showInputDialog("Enter deposit amount:");
        try {
            double amount = Double.parseDouble(input);
            balance += amount;
            JOptionPane.showMessageDialog(this, "Deposit successful!");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Invalid input. Please enter a valid number.");
        }
    }

    //Withdraw Funds
    private void withdrawFunds() {
        String input = JOptionPane.showInputDialog("Enter withdrawal amount:");
        try {
            double amount = Double.parseDouble(input);
            if (amount > balance) {
                JOptionPane.showMessageDialog(this, "Insufficient funds!");
            } else {
                balance -= amount;
                JOptionPane.showMessageDialog(this, "Withdrawal successful!");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Invalid input. Please enter a valid number.");
        }
    }

    //Show Balance
    private void showBalance() {
        JOptionPane.showMessageDialog(this, "Your account balance is: $" + balance);
    }

    //Main
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MarineNavyBank().setVisible(true));
    
    //End Main
    }


    //End Class
}