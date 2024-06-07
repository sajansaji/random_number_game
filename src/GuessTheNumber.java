import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class GuessTheNumber extends JFrame {
    private final int num;
    private int attempts = 5;
    private final JLabel messageLabel;
    private JLabel remainingLabel;
    private final JTextField guessInput;
    private JButton guessButton;

    public GuessTheNumber() {
        Random random = new Random();
        num = random.nextInt(100) + 1;

        //  frame
        setTitle("Guess the random number game for internship");
        setSize(700, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridBagLayout());

        // Create components
        remainingLabel = new JLabel("Remaining attempts: " + attempts);
        messageLabel = new JLabel("Enter your guess:");
        guessInput = new JTextField(10);
        guessButton = new JButton("Guess the number");

        // Add action listener to the button
        guessButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                makeGuess();
            }
        });

        // Set up the layout
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(5, 5, 5, 5);
        add(messageLabel, gbc);

        gbc.gridy = 1;
        add(remainingLabel, gbc);

        gbc.gridwidth = 1;
        gbc.gridy = 2;
        add(guessInput, gbc);

        gbc.gridx = 1;
        add(guessButton, gbc);
    }

    private void makeGuess() {
        if (attempts > 0) {
            try {
                int guess = Integer.parseInt(guessInput.getText());
                attempts--;
                if (guess == num) {
                    int score = (5 - attempts) * 100;
                    if(attempts == 4){
                        score = 500;
                    }
                    else if(attempts == 3){
                        score = 400;
                    }
                    else if(attempts == 2){
                        score = 300;
                    }
                    else if(attempts == 1){
                        score = 200;
                    }
                    else if(attempts == 0){
                        score = 0;
                        messageLabel.setText("Better luck next time! The number was: " + num);
                        guessButton.setEnabled(false);
                    }
                    messageLabel.setText("You are right. Your Score is: " + score);
                    remainingLabel.setText("");
                    guessButton.setEnabled(false);
                } else if (guess > num) {
                    messageLabel.setText("High.");
                } else {
                    messageLabel.setText("Low.");
                }
                remainingLabel.setText("Remaining attempts: " + attempts);
            } catch (NumberFormatException e) {
                messageLabel.setText("Please enter a valid number.");
            }
        } else {
            messageLabel.setText("Better luck next time! The number was: " + num);
            guessButton.setEnabled(false);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                GuessTheNumber game = new GuessTheNumber();
                game.setVisible(true);
            }
        });
    }
}