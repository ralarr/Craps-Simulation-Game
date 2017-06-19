package Craps;

import java.awt.Color;
import java.awt.Container;
import java.awt.Toolkit;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

/**
 ******************************************************************************
 * Comments by student.
 * 
 ******************************************************************************
 * File name:       CrapsGUI.java
 * @author          Rafael Larrea
 * Created on:      November 27, 2014 6:04 PM
 * @version         1.0
 * Platform:        Unix, LinuxDebian, NetBeans 8.0.1, JDK 1.8.0_20
 * @see             java.awt.Color
 * @see             java.awt.Container
 * @see             java.awt.Toolkit
 * @see             import java.io.File;
 * @see             import java.io.FileInputStream;
 * @see             import java.io.FileWriter;
 * @see             javax.swing.JOptionPane
 * @see             java.io.IOException
 * @see             import java.io.InputStream;
 * @see             import java.io.PrintWriter;
 * @see             import java.text.DecimalFormat;
 * @see             import javax.swing.ImageIcon;
 * @see             import javax.swing.JLabel;
 * @see             import sun.audio.AudioPlayer;
 * @see             import sun.audio.AudioStream;
 * @see             javax.swing.JOptionPane
 * ****************************************************************************
 * <b>
 * This application simulates a game of Craps; by throwing two dies, it 
 * calculates their sum and display it as the point.
 * The game is won if 7 or 11 are the sum of the dies during the first roll
 * and also by making the point again after the first roll before 7.
 * The player is also allowed to bet.
 * </b>
 * ****************************************************************************
 * Input:           If the player chooses to bet, the input is the amount
 *                  he decides to bet.
 * Output:          The frequency and percentage of the dies and the statistics
 *                  of how many games were won or lost.
 *                  If the player chose to bet, the change in his bankroll.
 * ****************************************************************************
 */


public class CrapsGUI extends javax.swing.JFrame {
    
    boolean firstRoll = true;   // A boolean to check if the dies are thrown for the first time
    int point = 0;
    int NumWins = 0;
    int NumLosses = 0;
    int amountBet = 0;
    int minimumBet = 10;    // Minimum amount allowed to bet
    int amountBankroll = 1000;  // Starting bankroll amount
    
    StringBuffer display = new StringBuffer("");
    
    // Class instance variables
    int FreqArray[] = new int[6];
    double PercArray[] = new double[6];
    int total = 0;
    
    // Create and instantiate two die objects
    Die die1 = new Die(Die.roll());
    Die die2 = new Die(Die.roll());

    /**
     * Creates new form CrapsGUI
     */
    public CrapsGUI() {
        initComponents();
        
        //centers the form
        setLocationRelativeTo(null);
        
        //displays icon image
        this.setIconImage(Toolkit.getDefaultToolkit().getImage("src/Craps/crapsIcon.jpeg"));
        
        //set rollJButton as default
        this.getRootPane().setDefaultButton(rollJButton);
        
        //set background color
        Container container = this.getContentPane();
        container.setBackground(Color.getHSBColor(0.290f, 0.779f, 0.793f));
        
        
    }
    
    /**
     * A method that starts a chatter if betting has been selected.
     */
    private void chatter()
    {
        int chatterAmount = Integer.parseInt(bankRollAmountJLabel.getText());
        if (betJCheckBox.isSelected())
        {
            if (chatterAmount >=1200)
            {
                titleChatterJLabel.setText("CHATTER:");
                chatterJLabel.setText("your doing good!!");
            }
            if(chatterAmount >=1600)
            {
                titleChatterJLabel.setText("CHATTER:");
                chatterJLabel.setText("time to cash in??");
            }
            if(chatterAmount >=2000)
            {
                titleChatterJLabel.setText("CHATTER:");
                chatterJLabel.setText("You are up BIG!!!");
            }
            if(chatterAmount <=600)
            {
                titleChatterJLabel.setText("CHATTER:");
                chatterJLabel.setText("going for a broke, huh?");
            }
            if(chatterAmount == 0)
            {
                titleChatterJLabel.setText("CHATTER:");
                chatterJLabel.setText("sorry, you are busted");
            }    
        }
    }
    
    /**
     * A method that provides a sound effect when the rollJButton is used.
     */
    private void soundEffect()
    {
        InputStream audioIn;
        try
        {
            audioIn = new FileInputStream(new File ("src/Craps/dicesthrow.wav"));
            AudioStream sound = new AudioStream(audioIn);
            AudioPlayer.player.start(sound);
        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        titleJLabel = new javax.swing.JLabel();
        die1JLabel = new javax.swing.JLabel();
        die2JLabel = new javax.swing.JLabel();
        die1IconJLabel = new javax.swing.JLabel();
        die2IconJLabel = new javax.swing.JLabel();
        buttonJPanel = new javax.swing.JPanel();
        rollJButton = new javax.swing.JButton();
        statisticsJButton = new javax.swing.JButton();
        printJButton = new javax.swing.JButton();
        clearJButton = new javax.swing.JButton();
        exitJButton = new javax.swing.JButton();
        statusJPanel = new javax.swing.JPanel();
        sumJLabel = new javax.swing.JLabel();
        sumPointJLabel = new javax.swing.JLabel();
        statusJLabel = new javax.swing.JLabel();
        statJLabel = new javax.swing.JLabel();
        pointJLabel = new javax.swing.JLabel();
        pointsJLabel = new javax.swing.JLabel();
        bettingJPanel = new javax.swing.JPanel();
        bankRollJLabel = new javax.swing.JLabel();
        bankRollAmountJLabel = new javax.swing.JLabel();
        betAmountJLabel = new javax.swing.JLabel();
        betJCheckBox = new javax.swing.JCheckBox();
        betAmountJTextField = new javax.swing.JTextField();
        displayJScrollPane = new javax.swing.JScrollPane();
        displayJTextArea = new javax.swing.JTextArea();
        chatterJLabel = new javax.swing.JLabel();
        titleChatterJLabel = new javax.swing.JLabel();
        CrapsJMenuBar = new javax.swing.JMenuBar();
        fileJMenu = new javax.swing.JMenu();
        clearJMenuItem = new javax.swing.JMenuItem();
        printJMenuItem = new javax.swing.JMenuItem();
        saveJMenuItem = new javax.swing.JMenuItem();
        exitJMenuItem = new javax.swing.JMenuItem();
        actionJMenu = new javax.swing.JMenu();
        rollJMenuItem = new javax.swing.JMenuItem();
        statisticsJMenuItem = new javax.swing.JMenuItem();
        helpJMenu = new javax.swing.JMenu();
        aboutJMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Craps Simulation Game");
        setResizable(false);

        titleJLabel.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        titleJLabel.setForeground(new java.awt.Color(228, 51, 51));
        titleJLabel.setText("Welcome to Craps Game Simulator");

        die1JLabel.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        die1JLabel.setText("Die 1");

        die2JLabel.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        die2JLabel.setText("Die 2");

        die1IconJLabel.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        die1IconJLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/DieImages/die1.png"))); // NOI18N

        die2IconJLabel.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        die2IconJLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/DieImages/die1.png"))); // NOI18N

        buttonJPanel.setLayout(new java.awt.GridLayout(1, 5));

        rollJButton.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        rollJButton.setMnemonic('R');
        rollJButton.setText("Roll");
        rollJButton.setToolTipText("Rolls the dices");
        rollJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rollJButtonActionPerformed(evt);
            }
        });
        buttonJPanel.add(rollJButton);

        statisticsJButton.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        statisticsJButton.setMnemonic('S');
        statisticsJButton.setText("Statistics");
        statisticsJButton.setToolTipText("Show the Statistics");
        statisticsJButton.setEnabled(false);
        statisticsJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                statisticsJButtonActionPerformed(evt);
            }
        });
        buttonJPanel.add(statisticsJButton);

        printJButton.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        printJButton.setMnemonic('P');
        printJButton.setText("Print");
        printJButton.setToolTipText("Print the text area");
        printJButton.setEnabled(false);
        printJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printJButtonActionPerformed(evt);
            }
        });
        buttonJPanel.add(printJButton);

        clearJButton.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        clearJButton.setMnemonic('C');
        clearJButton.setText("New Game");
        clearJButton.setToolTipText("Start a new game");
        clearJButton.setEnabled(false);
        clearJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearJButtonActionPerformed(evt);
            }
        });
        buttonJPanel.add(clearJButton);

        exitJButton.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        exitJButton.setMnemonic('x');
        exitJButton.setText("Exit");
        exitJButton.setToolTipText("Exit the application");
        exitJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitJButtonActionPerformed(evt);
            }
        });
        buttonJPanel.add(exitJButton);

        statusJPanel.setBackground(new java.awt.Color(31, 196, 31));
        statusJPanel.setLayout(new java.awt.GridLayout(3, 2));

        sumJLabel.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        sumJLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        sumJLabel.setText("Sum =");
        statusJPanel.add(sumJLabel);

        sumPointJLabel.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        sumPointJLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        statusJPanel.add(sumPointJLabel);

        statusJLabel.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        statusJLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        statusJLabel.setText("Status:");
        statusJPanel.add(statusJLabel);

        statJLabel.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        statJLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        statusJPanel.add(statJLabel);

        pointJLabel.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        pointJLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        pointJLabel.setText("Point =");
        statusJPanel.add(pointJLabel);

        pointsJLabel.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        pointsJLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        statusJPanel.add(pointsJLabel);

        bettingJPanel.setBackground(new java.awt.Color(31, 196, 31));
        bettingJPanel.setForeground(new java.awt.Color(228, 51, 51));

        bankRollJLabel.setFont(new java.awt.Font("SansSerif", 1, 11)); // NOI18N
        bankRollJLabel.setForeground(new java.awt.Color(228, 51, 51));
        bankRollJLabel.setText("BankRoll:   $");
        bankRollJLabel.setEnabled(false);

        bankRollAmountJLabel.setFont(new java.awt.Font("SansSerif", 1, 11)); // NOI18N
        bankRollAmountJLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        bankRollAmountJLabel.setText("1000");
        bankRollAmountJLabel.setEnabled(false);

        betAmountJLabel.setFont(new java.awt.Font("SansSerif", 1, 11)); // NOI18N
        betAmountJLabel.setForeground(new java.awt.Color(228, 51, 51));
        betAmountJLabel.setText("Amount to bet: ");
        betAmountJLabel.setEnabled(false);

        betJCheckBox.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        betJCheckBox.setText("betting");
        betJCheckBox.setToolTipText("allow betting?");
        betJCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                betJCheckBoxActionPerformed(evt);
            }
        });

        betAmountJTextField.setEditable(false);
        betAmountJTextField.setBackground(new java.awt.Color(228, 51, 51));
        betAmountJTextField.setFont(new java.awt.Font("Courier 10 Pitch", 0, 14)); // NOI18N
        betAmountJTextField.setToolTipText("Enter an amount to bet");

        javax.swing.GroupLayout bettingJPanelLayout = new javax.swing.GroupLayout(bettingJPanel);
        bettingJPanel.setLayout(bettingJPanelLayout);
        bettingJPanelLayout.setHorizontalGroup(
            bettingJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bettingJPanelLayout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addGroup(bettingJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(bettingJPanelLayout.createSequentialGroup()
                        .addComponent(betAmountJLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(betAmountJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(bettingJPanelLayout.createSequentialGroup()
                        .addComponent(bankRollJLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bankRollAmountJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(betJCheckBox))
                .addGap(19, 19, 19))
        );
        bettingJPanelLayout.setVerticalGroup(
            bettingJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bettingJPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(betJCheckBox)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(bettingJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bankRollJLabel)
                    .addComponent(bankRollAmountJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(bettingJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(betAmountJLabel)
                    .addComponent(betAmountJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18))
        );

        displayJTextArea.setEditable(false);
        displayJTextArea.setBackground(new java.awt.Color(228, 51, 51));
        displayJTextArea.setColumns(20);
        displayJTextArea.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        displayJTextArea.setRows(5);
        displayJScrollPane.setViewportView(displayJTextArea);

        chatterJLabel.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        chatterJLabel.setForeground(new java.awt.Color(239, 243, 13));

        titleChatterJLabel.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        titleChatterJLabel.setForeground(new java.awt.Color(239, 243, 13));

        fileJMenu.setMnemonic('F');
        fileJMenu.setText("File");
        fileJMenu.setToolTipText("Start a new game");

        clearJMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.ALT_MASK));
        clearJMenuItem.setMnemonic('C');
        clearJMenuItem.setText("New Game");
        clearJMenuItem.setToolTipText("");
        clearJMenuItem.setEnabled(false);
        clearJMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearJMenuItemActionPerformed(evt);
            }
        });
        fileJMenu.add(clearJMenuItem);

        printJMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.CTRL_MASK));
        printJMenuItem.setMnemonic('P');
        printJMenuItem.setText("Print");
        printJMenuItem.setToolTipText("Print the whole GUI");
        printJMenuItem.setEnabled(false);
        printJMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printJMenuItemActionPerformed(evt);
            }
        });
        fileJMenu.add(printJMenuItem);

        saveJMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        saveJMenuItem.setMnemonic('S');
        saveJMenuItem.setText("Save");
        saveJMenuItem.setToolTipText("Save the results");
        saveJMenuItem.setEnabled(false);
        saveJMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveJMenuItemActionPerformed(evt);
            }
        });
        fileJMenu.add(saveJMenuItem);

        exitJMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_X, java.awt.event.InputEvent.ALT_MASK));
        exitJMenuItem.setMnemonic('x');
        exitJMenuItem.setText("Exit");
        exitJMenuItem.setToolTipText("Exit the application");
        exitJMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitJMenuItemActionPerformed(evt);
            }
        });
        fileJMenu.add(exitJMenuItem);

        CrapsJMenuBar.add(fileJMenu);

        actionJMenu.setMnemonic('t');
        actionJMenu.setText("Action");

        rollJMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.ALT_MASK));
        rollJMenuItem.setMnemonic('R');
        rollJMenuItem.setText("Roll");
        rollJMenuItem.setToolTipText("Roll the dices");
        rollJMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rollJMenuItemActionPerformed(evt);
            }
        });
        actionJMenu.add(rollJMenuItem);

        statisticsJMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.ALT_MASK));
        statisticsJMenuItem.setMnemonic('S');
        statisticsJMenuItem.setText("Statistics");
        statisticsJMenuItem.setToolTipText("Show the statistics");
        statisticsJMenuItem.setEnabled(false);
        statisticsJMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                statisticsJMenuItemActionPerformed(evt);
            }
        });
        actionJMenu.add(statisticsJMenuItem);

        CrapsJMenuBar.add(actionJMenu);

        helpJMenu.setMnemonic('H');
        helpJMenu.setText("Help");

        aboutJMenuItem.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        aboutJMenuItem.setMnemonic('A');
        aboutJMenuItem.setText("About");
        aboutJMenuItem.setToolTipText("Show about form");
        aboutJMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aboutJMenuItemActionPerformed(evt);
            }
        });
        helpJMenu.add(aboutJMenuItem);

        CrapsJMenuBar.add(helpJMenu);

        setJMenuBar(CrapsJMenuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(buttonJPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(die1IconJLabel)
                            .addComponent(die1JLabel))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(die2IconJLabel)
                            .addComponent(die2JLabel))
                        .addGap(38, 38, 38))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(bettingJPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(titleJLabel)
                        .addGap(0, 224, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(displayJScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 336, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(chatterJLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(statusJPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(titleChatterJLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(bettingJPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(die1JLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(die2JLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(die1IconJLabel)
                            .addComponent(die2IconJLabel)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(titleJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(titleChatterJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(9, 9, 9)
                                .addComponent(chatterJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(statusJPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(displayJScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(buttonJPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void exitJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitJButtonActionPerformed
        // Exits the game.
        System.exit(0);
    }//GEN-LAST:event_exitJButtonActionPerformed

    private void printJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printJButtonActionPerformed
        // Prints the JTextArea only.
        try
        {
            displayJTextArea.print();
        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }//GEN-LAST:event_printJButtonActionPerformed

    private void rollJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rollJButtonActionPerformed
        // Rolls the dies and display the results
        total += 2;     //2 dice are thrown
        die1.setSide(Die.roll());        //call static roll method of the Die class
        die2.setSide(Die.roll());
                
        // Call the setPercent method to calculate the percentage.
        setPercent(die1.getSide());
        setPercent(die2.getSide());
       
        // Sets the correct labels for the dies.
        setLabel(die1IconJLabel, "src/DieImages/", die1.getSide());
        setLabel(die2IconJLabel, "src/DieImages/", die2.getSide());
            
        // Display the results in the JTextArea
        StringBuffer result = displayResults();
        displayJTextArea.setText(result.toString());
        
        // Calls the getSide method and add the results of the 2 dies
        int sumOfDice = die1.getSide()+die2.getSide();
       
    
        if (betJCheckBox.isSelected())
        {
            try
            {
                amountBet = Integer.parseInt(betAmountJTextField.getText());
                if (amountBet < minimumBet || amountBet > amountBankroll )
                    throw new NumberFormatException();
                else
                    if (firstRoll)
                    {
                        betAmountJTextField.setEditable(false);
                        switch (sumOfDice)
                        {
                            case 7:
                            case 11:
                                point = sumOfDice;
                                statJLabel.setText("You Won");
                                pointsJLabel.setText(Integer.toString(point));
                                NumWins +=1;
                                amountBankroll += amountBet;
                                betJCheckBox.setEnabled(true);
                                betAmountJTextField.setEditable(true);
                                clearJButton.setEnabled(true);
                                clearJMenuItem.setEnabled(true);
                                statisticsJButton.setEnabled(true);
                                statisticsJMenuItem.setEnabled(true);
                                saveJMenuItem.setEnabled(true);
                                break;
                            case 2:
                            case 3:
                            case 12:
                                point = sumOfDice;
                                statJLabel.setText("Game Lost");
                                pointsJLabel.setText(Integer.toString(point));
                                NumLosses +=1;
                                amountBankroll -= amountBet;
                                betJCheckBox.setEnabled(true);
                                betAmountJTextField.setEditable(true);
                                clearJButton.setEnabled(true);
                                clearJMenuItem.setEnabled(true);
                                statisticsJButton.setEnabled(true);
                                statisticsJMenuItem.setEnabled(true);
                                saveJMenuItem.setEnabled(true);
                                break;
                            default:
                                point = sumOfDice;
                                statJLabel.setText("Roll Again");
                                pointsJLabel.setText(Integer.toString(point));
                                betJCheckBox.setEnabled(false);
                                clearJButton.setEnabled(false);
                                clearJMenuItem.setEnabled(false);
                                statisticsJButton.setEnabled(false);
                                statisticsJMenuItem.setEnabled(false);
                                saveJMenuItem.setEnabled(false);
                     
                                firstRoll = false;
                        }
                    }
                    else
                    { // determine game status
                        if ( sumOfDice == point ) // win by making point
                        {
                            statJLabel.setText("You Won");
                            firstRoll = true;
                            betAmountJTextField.setEditable(true);
                            NumWins +=1;
                            amountBankroll += amountBet;
                            betJCheckBox.setEnabled(true);
                            clearJButton.setEnabled(true);
                            clearJMenuItem.setEnabled(true);
                            statisticsJButton.setEnabled(true);
                            statisticsJMenuItem.setEnabled(true);
                            saveJMenuItem.setEnabled(true);
                        }
                        else
                            if ( sumOfDice == 7 ) // lose by rolling 7
                            {
                                statJLabel.setText("Game Lost");
                                firstRoll = true;
                                pointsJLabel.setText(Integer.toString(point));
                                betAmountJTextField.setEditable(true);
                                NumLosses +=1;
                                amountBankroll -= amountBet;
                                betJCheckBox.setEnabled(true);
                                clearJButton.setEnabled(true);
                                clearJMenuItem.setEnabled(true);
                                statisticsJButton.setEnabled(true);
                                statisticsJMenuItem.setEnabled(true);
                                saveJMenuItem.setEnabled(true);
                            }
                    }
            }catch(NumberFormatException nume)
            {
            //display error mesasge
                JOptionPane.showMessageDialog(null, "Enter a positive amount in range [10, " + 
                        amountBankroll + "]", "Illegal Input", JOptionPane.ERROR_MESSAGE);
                betAmountJTextField.requestFocus();
                betAmountJTextField.selectAll();
            }
            sumPointJLabel.setText( Integer.toString( sumOfDice ) ); 
            bankRollAmountJLabel.setText(Integer.toString(amountBankroll));
            printJButton.setEnabled(true);
            printJMenuItem.setEnabled(true);
        
            chatter();
            soundEffect();
        
            if (Integer.parseInt(bankRollAmountJLabel.getText()) == 0)
            {
                JOptionPane.showMessageDialog(null, "You don't have sufficient funds", 
                        "Cashier", JOptionPane.INFORMATION_MESSAGE);
                betAmountJTextField.setText("");
                betAmountJTextField.setEnabled(false);
                betJCheckBox.setSelected(false);
                betJCheckBox.setEnabled(false);
            }
        }
        else
            if (firstRoll)
            {
                switch (sumOfDice)
                {
                    case 7:
                    case 11:
                        point = sumOfDice;
                        statJLabel.setText("You Won");
                        pointsJLabel.setText(Integer.toString(point));
                        NumWins +=1;
                        clearJButton.setEnabled(true);
                        clearJMenuItem.setEnabled(true);
                        statisticsJButton.setEnabled(true);
                        statisticsJMenuItem.setEnabled(true);
                        saveJMenuItem.setEnabled(true);
                        break;
                    case 2:
                    case 3:
                    case 12:
                        point = sumOfDice;
                        statJLabel.setText("Game Lost");
                        pointsJLabel.setText(Integer.toString(point));
                        NumLosses +=1;
                        clearJButton.setEnabled(true);
                        clearJMenuItem.setEnabled(true);
                        statisticsJButton.setEnabled(true);
                        statisticsJMenuItem.setEnabled(true);
                        saveJMenuItem.setEnabled(true);
                        break;
                    default:
                        point = sumOfDice;
                        pointsJLabel.setText(Integer.toString(point));
                        statJLabel.setText("Roll Again");
                        clearJButton.setEnabled(false);
                        clearJMenuItem.setEnabled(false);
                        statisticsJButton.setEnabled(false);
                        statisticsJMenuItem.setEnabled(false);
                        saveJMenuItem.setEnabled(false);
                        betJCheckBox.setEnabled(false);
                     
                        firstRoll =false;
                }
            }
            else
            { // determine game status
                if ( sumOfDice == point ) // win by making point
                {
                    statJLabel.setText("You Won");
                    firstRoll = true;
                    NumWins +=1;
                    clearJButton.setEnabled(true);
                    clearJMenuItem.setEnabled(true);
                    statisticsJButton.setEnabled(true);
                    statisticsJMenuItem.setEnabled(true);
                    saveJMenuItem.setEnabled(true);
                    if (Integer.parseInt(bankRollAmountJLabel.getText()) != 0)
                        betJCheckBox.setEnabled(true);
                    
                }
                else
                    if ( sumOfDice == 7 ) // lose by rolling 7
                    {
                        statJLabel.setText("Game Lost");
                        firstRoll = true;
                        pointsJLabel.setText(Integer.toString(point));
                        NumLosses +=1;
                        clearJButton.setEnabled(true);
                        clearJMenuItem.setEnabled(true);
                        statisticsJButton.setEnabled(true);
                        statisticsJMenuItem.setEnabled(true);
                        saveJMenuItem.setEnabled(true);
                        if (Integer.parseInt(bankRollAmountJLabel.getText()) != 0)
                        betJCheckBox.setEnabled(true);
                    }
            }
        sumPointJLabel.setText( Integer.toString( sumOfDice ) ); 
        printJButton.setEnabled(true);
        printJMenuItem.setEnabled(true);
        
        soundEffect();
        
    }//GEN-LAST:event_rollJButtonActionPerformed

    /**
     * A method that display the results of frequency and percents on the main screen
     * @return output--a StringBuffer object containing the formatted results.
     */
    public StringBuffer displayResults()
    {
        String spaces8 = "        ", tab = "\t     ";
        DecimalFormat percentFormat = new DecimalFormat("#,##0.00%");
        StringBuffer output = new StringBuffer("Face     " + "Frequency   " + "Percent\n");
        output.append("1" +  spaces8 + FreqArray[0] + tab + percentFormat.format(PercArray[0]) + "\n");
        output.append("2        " + FreqArray[1] + tab + percentFormat.format(PercArray[1]) + "\n");
        output.append("3        " + FreqArray[2] + tab + percentFormat.format(PercArray[2]) + "\n");
        output.append("4        " + FreqArray[3] + tab + percentFormat.format(PercArray[3]) + "\n");
        output.append("5        " + FreqArray[4] + tab + percentFormat.format(PercArray[4]) + "\n");
        output.append("6        " + FreqArray[5] + tab + percentFormat.format(PercArray[5]));
       
        return output;
    }
    
    /**
     * A method that display the results of won and lost games when the statisticsJButton is used
     * @return statOutput--a StringBuffer object containing the formatted game results.
     */
    public StringBuffer displayStats()
    {
        StringBuffer statOutput = new StringBuffer();
        DecimalFormat statsFormat = new DecimalFormat("#00.00%");
        statOutput.append("Number of games played = " + (NumWins + NumLosses) + "\n");
        statOutput.append("Number of games won = " + (NumWins) + "\n");
        statOutput.append("Number of games lost = " + (NumLosses) + "\n");
        statOutput.append("percentage of games won = " + statsFormat.format((double)NumWins / (NumWins + NumLosses) ));
       
        return statOutput;
    }
   
    /**
     * A method that display the balance left in the bankroll
     * @return balanceOutput--a StringBuffer object containing the formatted bankroll available.
     */
    public StringBuffer displayBalance()
    {
        StringBuffer balanceOutput = new StringBuffer();
        balanceOutput.append("Your bank balance is: " + bankRollAmountJLabel.getText() + "\n");
       
        return balanceOutput;
    }
    
    /**
     * A method that sets the correct image on the given label
     * @param label
     * @param folder
     * @param num 
     */
    public void setLabel(JLabel label, String folder, int num)
    {
        String imageName = folder + "die" + num + ".png";
        label.setIcon(new ImageIcon(imageName));
    }
    
    /**
     * Set the frequency and percentage of the die rolled
     * @param: int num--face showing up on the die
     * @return: void
     */
    private void setPercent(int num)
    {
	int number = 0;
        number = num - 1;
        FreqArray[number]++;
        
        for (int i = 0; i < FreqArray.length; i++)
        {
            PercArray[i] = (double)FreqArray[i] / total;
        
        }
    }
    
    private void aboutJMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aboutJMenuItemActionPerformed
        // Open an about form
        new About().setVisible(true);
    }//GEN-LAST:event_aboutJMenuItemActionPerformed

    private void exitJMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitJMenuItemActionPerformed
        // Exits the program from the menu
        exitJButtonActionPerformed(evt);
    }//GEN-LAST:event_exitJMenuItemActionPerformed

    private void printJMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printJMenuItemActionPerformed
        // Print the whole GUI.
        try
        {
            //http://www.apl.jhu.edu/~hall/java/Swing-Tutorial/Swing-Tutorial-Printing.html
            PrintUtilities.printComponent(this);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    
    }//GEN-LAST:event_printJMenuItemActionPerformed

    private void clearJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearJButtonActionPerformed
        // Clear the game
        total = 0;
        FreqArray[0]=0;
        FreqArray[1]=0;
        FreqArray[2]=0;
        FreqArray[3]=0;
        FreqArray[4]=0;
        FreqArray[5]=0;
        NumWins = 0;
        NumLosses = 0;
        sumPointJLabel.setText("");
        statJLabel.setText("");
        pointsJLabel.setText("");
        displayJTextArea.setText("");
        titleChatterJLabel.setText("");
        chatterJLabel.setText("");
        betAmountJTextField.setText("");
        amountBankroll = 1000;
        bankRollAmountJLabel.setText(Integer.toString(amountBankroll));
        betJCheckBox.setEnabled(true);
        betJCheckBox.setSelected(false);
        bankRollJLabel.setEnabled(false);
        bankRollAmountJLabel.setEnabled(false);
        betAmountJLabel.setEnabled(false);
        betAmountJTextField.setEnabled(true);
        betAmountJTextField.setEditable(false);
    }//GEN-LAST:event_clearJButtonActionPerformed

    private void statisticsJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_statisticsJButtonActionPerformed
        // Display the statiscs of the game.
        display = displayStats();
        displayJTextArea.setText(display.toString());
    }//GEN-LAST:event_statisticsJButtonActionPerformed

    private void betJCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_betJCheckBoxActionPerformed
        // Enables the required field if allow bettin is selected.
        if (betJCheckBox.isSelected())
        {
            bankRollJLabel.setEnabled(true);
            bankRollAmountJLabel.setEnabled(true);
            betAmountJLabel.setEnabled(true);
            betAmountJTextField.setEditable(true);
            betAmountJTextField.requestFocus(true);
        }
        else
        {
            bankRollJLabel.setEnabled(false);
            bankRollAmountJLabel.setEnabled(false);
            betAmountJLabel.setEnabled(false);
            betAmountJTextField.setEditable(false);
            betAmountJTextField.setText("");
            chatterJLabel.setText("");
        }
    }//GEN-LAST:event_betJCheckBoxActionPerformed

    private void saveJMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveJMenuItemActionPerformed
        // Save the content of the Jext area to an external file
        try
        {
            // Create a file to append 
            display = displayStats();
            FileWriter fwriter = new FileWriter("src/Craps/DiceSimulation.txt", true);
            PrintWriter outputFile = new PrintWriter(fwriter);                     

            // Write the name & bill to the file.
            outputFile.println(display);
            outputFile.close();
            
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
        try
        {
            // Create a file to append 
            display = displayBalance();
            FileWriter fwriter = new FileWriter("src/Craps/DiceSimulation.txt", true);
            PrintWriter outputFile = new PrintWriter(fwriter);                     

            // Write the name & bill to the file.
            outputFile.println(display);
            outputFile.close();
            
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }//GEN-LAST:event_saveJMenuItemActionPerformed

    private void clearJMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearJMenuItemActionPerformed
        // Clear the game from the menu.
        clearJButtonActionPerformed(evt);
    }//GEN-LAST:event_clearJMenuItemActionPerformed

    private void rollJMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rollJMenuItemActionPerformed
        // Roll the dies from the menu.
        rollJButtonActionPerformed(evt);
    }//GEN-LAST:event_rollJMenuItemActionPerformed

    private void statisticsJMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_statisticsJMenuItemActionPerformed
        // Display the statistics from the menu.
        statisticsJButtonActionPerformed(evt);
    }//GEN-LAST:event_statisticsJMenuItemActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CrapsGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CrapsGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CrapsGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CrapsGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try
                {
                    Thread.sleep(1800);    
                }
                catch(Exception e)
                {
                }
                new CrapsGUI().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar CrapsJMenuBar;
    private javax.swing.JMenuItem aboutJMenuItem;
    private javax.swing.JMenu actionJMenu;
    private javax.swing.JLabel bankRollAmountJLabel;
    private javax.swing.JLabel bankRollJLabel;
    private javax.swing.JLabel betAmountJLabel;
    private javax.swing.JTextField betAmountJTextField;
    private javax.swing.JCheckBox betJCheckBox;
    private javax.swing.JPanel bettingJPanel;
    private javax.swing.JPanel buttonJPanel;
    private javax.swing.JLabel chatterJLabel;
    private javax.swing.JButton clearJButton;
    private javax.swing.JMenuItem clearJMenuItem;
    private javax.swing.JLabel die1IconJLabel;
    private javax.swing.JLabel die1JLabel;
    private javax.swing.JLabel die2IconJLabel;
    private javax.swing.JLabel die2JLabel;
    private javax.swing.JScrollPane displayJScrollPane;
    private javax.swing.JTextArea displayJTextArea;
    private javax.swing.JButton exitJButton;
    private javax.swing.JMenuItem exitJMenuItem;
    private javax.swing.JMenu fileJMenu;
    private javax.swing.JMenu helpJMenu;
    private javax.swing.JLabel pointJLabel;
    private javax.swing.JLabel pointsJLabel;
    private javax.swing.JButton printJButton;
    private javax.swing.JMenuItem printJMenuItem;
    private javax.swing.JButton rollJButton;
    private javax.swing.JMenuItem rollJMenuItem;
    private javax.swing.JMenuItem saveJMenuItem;
    private javax.swing.JLabel statJLabel;
    private javax.swing.JButton statisticsJButton;
    private javax.swing.JMenuItem statisticsJMenuItem;
    private javax.swing.JLabel statusJLabel;
    private javax.swing.JPanel statusJPanel;
    private javax.swing.JLabel sumJLabel;
    private javax.swing.JLabel sumPointJLabel;
    private javax.swing.JLabel titleChatterJLabel;
    private javax.swing.JLabel titleJLabel;
    // End of variables declaration//GEN-END:variables
}
