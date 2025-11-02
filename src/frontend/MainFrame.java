package frontend;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.*;
import backend.Calculation;
import enumerators.Choice;
import static enumerators.Choice.ROCK;
import static enumerators.Choice.PAPER;
import static enumerators.Choice.SCISSOR;

/* 
 * This class defines the UI elements and the actions
 */
public class MainFrame implements ActionListener {
    private Font mainFont = new Font("Arial", Font.BOLD, 20);
    private JButton btStartGame;
    private JButton btValidatePlayer1;
    private JButton btValidatePlayer2;
    private JLabel lbWinner;
    private JLabel lbPlayer1;
    private JLabel lbPlayer2;
    private JComboBox<String> cbMode;
    private JComboBox<Choice> cbPlayer1;
    private JComboBox<Choice> cbPlayer2;

    Choice[] choices = { ROCK, PAPER, SCISSOR };
    
    public void initialize() {
        
        /*** Create all UI components ***/
    	
    	//Title
    	JLabel lbTitle = new JLabel("Welcome to RPS");
    	lbTitle.setFont(new Font ("Arial", Font.BOLD, 40));
        
        // Mode combobox
        String[] mode = { "1 Player", "2 Players", "0 Players" };
        cbMode = new JComboBox<>(mode);
        cbMode.setFont(mainFont);
        cbMode.addActionListener(this);
        
        // Start button
        btStartGame = new JButton("Start");
        btStartGame.setFont(mainFont);
        btStartGame.addActionListener(this);
        
        // Player 1 combobox with label and validate button
        cbPlayer1 = new JComboBox<>(choices);
        cbPlayer1.setVisible(false);
        lbPlayer1 = new JLabel("Player 1");
        lbPlayer1.setVisible(false);
        btValidatePlayer1 = new JButton("GO");
        btValidatePlayer1.setVisible(false);
        btValidatePlayer1.addActionListener(this);
        
        // Player 1 combobox with label and validate button
        cbPlayer2 = new JComboBox<>(choices);
        cbPlayer2.setVisible(false);
        lbPlayer2 = new JLabel("Player 2");
        lbPlayer2.setVisible(false);
        btValidatePlayer2 = new JButton("GO");
        btValidatePlayer2.setVisible(false);
        btValidatePlayer2.addActionListener(this);
        
        // Winner label
        lbWinner = new JLabel();

        
        /*** Create panels ***/
        
        // Title panel
        JPanel titlePanel = new JPanel();
        titlePanel.add(lbTitle);
        titlePanel.setLayout(new GridLayout(1,1));
        
        // Mode panel
        JPanel modePanel = new JPanel();
        modePanel.add(cbMode);
        
        // Start panel
        JPanel startPanel = new JPanel();
        startPanel.add(btStartGame);
        
        // Players panel
        JPanel playersPanel= new JPanel();
        playersPanel.setLayout(new GridLayout(3, 3));
        playersPanel.add(lbPlayer1);
        playersPanel.add(cbPlayer1);
        playersPanel.add(btValidatePlayer1);
        playersPanel.add(lbPlayer2);
        playersPanel.add(cbPlayer2);
        playersPanel.add(btValidatePlayer2);
        playersPanel.add(lbWinner);
       
        
        /*** Add the panels to the mainpanel ***/
        
        JPanel mainPanel = new JPanel();
        mainPanel.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));
        mainPanel.setLayout(new GridLayout(4,1));
        mainPanel.add(titlePanel);
        mainPanel.add(modePanel);
        mainPanel.add(startPanel);
        mainPanel.add(playersPanel);
        
        /*** Add the mainpanel to the frame ***/
        
        JFrame frame = new JFrame();
        frame.add(mainPanel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setTitle("RPS");
        frame.pack();
        frame.setVisible(true);
    }

    // Define the actions on the buttons and combobox
    @Override
    public void actionPerformed(ActionEvent e) {
        Calculation calc = new Calculation();

        if(e.getSource() == btStartGame) {
            if("0 Players".equals(cbMode.getSelectedItem().toString())) {
                
            	/*** Set visibility of the UI ***/
                cbPlayer1.setVisible(true);
                lbPlayer1.setVisible(true);
                cbPlayer2.setVisible(true);
                lbPlayer2.setVisible(true);
                btStartGame.setVisible(true);
                lbWinner.setVisible(true);
                
                /*** Reset the Winner label ***/
                lbWinner.setText(null);
                
                /*** Disable buttons ***/
                cbPlayer1.setEnabled(false);
                cbPlayer2.setEnabled(false);

                /*** Create random choices for the player 1 and player 2 ***/
                Choice computerChoice = choices[new Random().nextInt(choices.length)];
                cbPlayer1.setSelectedItem(computerChoice);
                Choice computerChoice2 = choices[new Random().nextInt(choices.length)];
                cbPlayer2.setSelectedItem(computerChoice2);
                
                /*** Display the winner ***/
                lbWinner.setText(calc.calculateResult(computerChoice, computerChoice2));

            }
            if("1 Player".equals(cbMode.getSelectedItem().toString())) {
                
            	/*** Set visibility of the UI ***/
                cbPlayer1.setVisible(true);
                btValidatePlayer1.setVisible(true);
                lbPlayer1.setVisible(true);
                cbPlayer2.setVisible(false);
                lbPlayer2.setVisible(false);
                lbWinner.setVisible(true);
                
                /*** Reset the Winner label ***/
                lbWinner.setText(null);
                
                /*** Enable buttons ***/
                cbPlayer1.setEnabled(true);
                cbPlayer2.setEnabled(true);
            }
            if("2 Players".equals(cbMode.getSelectedItem().toString())) {
            	
            	/*** Set visibility of the UI ***/
                cbPlayer1.setVisible(true);
                btValidatePlayer1.setVisible(true);
                lbPlayer1.setVisible(true);
                cbPlayer2.setVisible(false);
                lbPlayer2.setVisible(true);
                btValidatePlayer2.setVisible(false);
                lbWinner.setVisible(true);
                
                /*** Reset the Winner label ***/
                lbWinner.setText(null);
                
                /*** Enable buttons ***/
                cbPlayer1.setEnabled(true);
                cbPlayer2.setEnabled(true);
                
            }
 
        }
        if(e.getSource() == cbMode) {
            
        	/*** Set visibility of the UI ***/
        	cbPlayer1.setVisible(false);
            lbPlayer1.setVisible(false);
            btValidatePlayer1.setVisible(false);
            cbPlayer2.setVisible(false);
            lbPlayer2.setVisible(false);
            btValidatePlayer2.setVisible(false);
            lbWinner.setVisible(false);

        }
        if(e.getSource() == btValidatePlayer1) {
            if("1 Player".equals(cbMode.getSelectedItem().toString())) {
            	
            	/*** Set visibility of the UI ***/
            	cbPlayer1.setVisible(true);
                lbPlayer1.setVisible(true);
                btValidatePlayer1.setVisible(false);
                cbPlayer2.setVisible(true);
                lbPlayer2.setVisible(true);
                
                /*** Disable buttons ***/
                cbPlayer1.setEnabled(false);
                cbPlayer2.setEnabled(false);
                
                /*** Create random choices for the player 2 ***/
                Choice computerChoice = choices[new Random().nextInt(choices.length)];
                cbPlayer2.setSelectedItem(computerChoice);
                
                /*** Display the winner ***/
                lbWinner.setText(calc.calculateResult((Choice) cbPlayer1.getSelectedItem(), computerChoice));
            }
            if("2 Players".equals(cbMode.getSelectedItem().toString())) {
                
            	/*** Set visibility of the UI ***/
            	cbPlayer1.setVisible(false);
                lbPlayer1.setVisible(true);
                btValidatePlayer1.setVisible(false);
                cbPlayer2.setVisible(true);
                lbPlayer2.setVisible(true);
                btValidatePlayer2.setVisible(true);
            }
        }

        if(e.getSource() == btValidatePlayer2) {
            if("2 Players".equals(cbMode.getSelectedItem().toString())) {
            	
            	/*** Set visibility of the UI ***/
            	cbPlayer1.setVisible(true);
                lbPlayer1.setVisible(true);
                cbPlayer2.setVisible(true);
                lbPlayer2.setVisible(true);
                btValidatePlayer2.setVisible(false);
                
                /*** Disable buttons ***/
                cbPlayer1.setEnabled(false);
                cbPlayer2.setEnabled(false);

                /*** Display the winner ***/
                lbWinner.setText(calc.calculateResult((Choice) cbPlayer1.getSelectedItem(), (Choice) cbPlayer2.getSelectedItem()));
            }
        }
    }
}
