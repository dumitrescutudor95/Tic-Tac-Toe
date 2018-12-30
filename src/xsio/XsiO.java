package xsio;

import javax.swing.JOptionPane;

public class XsiO extends javax.swing.JFrame {

    //The value of the next turn
    public String xOrO = "X";
    //Turns passed
    public int xoCount = 1;
    //Game over
    boolean gameOver = false;
    //The winner
    String winner = "";
    //Wins and ties
    public int xWins = 0;
    public int oWins = 0;
    public int ties;

    //Choice: play against another player or vs computer
    boolean vsPlayer;

    //Switch from X to O , depending on the player's turn
    public void switchXO() {
        xoCount++;
        if (xoCount % 2 == 0) {
            xOrO = "O";
        } else {
            xOrO = "X";
        }
    }

    //Checking if either X or O won
    public void check() {
        //Buttons value encapsulation
        String s1 = b1.getText();
        String s2 = b2.getText();
        String s3 = b3.getText();
        String s4 = b4.getText();
        String s5 = b5.getText();
        String s6 = b6.getText();
        String s7 = b7.getText();
        String s8 = b8.getText();
        String s9 = b9.getText();

        //if Player 1 won
        if ((s1.equals(s2) && s2.equals(s3) && s1.equals("X"))
                || (s4.equals(s5) && s5.equals(s6) && s4.equals("X"))
                || (s7.equals(s8) && s8.equals(s9) && s7.equals("X"))
                || (s1.equals(s4) && s4.equals(s7) && s1.equals("X"))
                || (s2.equals(s5) && s5.equals(s8) && s2.equals("X"))
                || (s3.equals(s6) && s6.equals(s9) && s3.equals("X"))
                || (s1.equals(s5) && s5.equals(s9) && s1.equals("X"))
                || (s3.equals(s5) && s5.equals(s7) && s7.equals("X"))) {
            gameOver = true; //end game
            winner = "Player 1"; //declare winner
        } //if Player 2/Computer won
        else if ((s1.equals(s2) && s2.equals(s3) && s1.equals("O"))
                || (s4.equals(s5) && s5.equals(s6) && s4.equals("O"))
                || (s7.equals(s8) && s8.equals(s9) && s7.equals("O"))
                || (s1.equals(s4) && s4.equals(s7) && s1.equals("O"))
                || (s2.equals(s5) && s5.equals(s8) && s2.equals("O"))
                || (s3.equals(s6) && s6.equals(s9) && s3.equals("O"))
                || (s1.equals(s5) && s5.equals(s9) && s1.equals("O"))
                || (s3.equals(s5) && s5.equals(s7) && s7.equals("O"))) {
            gameOver = true; //end game
            winner = "Player 2"; //declare winner
        } //if nobody won,declare tie
        else if (b1.isSelected() && b2.isSelected()
                && b3.isSelected() && b4.isSelected()
                && b5.isSelected() && b6.isSelected()
                && b7.isSelected() && b8.isSelected()
                && b9.isSelected()) {
            gameOver = true; //end game
            winner = "remiza"; //declare tie
        }

        //Once the game is over
        if (gameOver) {
            //Show winner
            JOptionPane.showMessageDialog(null, "Winner:" + winner, "Game Over", JOptionPane.PLAIN_MESSAGE);

            //Reset game
            gameOver = false;

            b1.setText("");
            b1.setSelected(false);
            b2.setText("");
            b2.setSelected(false);
            b3.setText("");
            b3.setSelected(false);
            b4.setText("");
            b4.setSelected(false);
            b5.setText("");
            b5.setSelected(false);
            b6.setText("");
            b6.setSelected(false);
            b7.setText("");
            b7.setSelected(false);
            b8.setText("");
            b8.setSelected(false);
            b9.setText("");
            b9.setSelected(false);
        }

        //if Player 1 won,incrase and show it's wins
        if (winner.equals("Player 1")) {
            xWins++;
            castigariPlayer1.setText(String.valueOf(xWins));
            winner = "";
        } //if Player 2/Computer won,incrase and show it's wins
        else if (winner.equals("Player 2")) {
            oWins++;
            castigariPlayer2.setText(String.valueOf(oWins));
            winner = "";
        } //If it's a tie,incrase and show the  tie number
        else if (winner.equals("remiza")) {
            ties++;
            labelRemize.setText(String.valueOf(ties));
            winner = "";

        }
    }

    //Setting the visual representation of the next move
    public void setTurn() {
        if (xoCount % 2 == 0) {
            turn.setText("O");
        } else {
            turn.setText("X");
        }
    }

    //The computer's style of playing
    public void computerO() {
        //Button encapsulation in Strings
        String s1 = b1.getText();
        String s2 = b2.getText();
        String s3 = b3.getText();
        String s4 = b4.getText();
        String s5 = b5.getText();
        String s6 = b6.getText();
        String s7 = b7.getText();
        String s8 = b8.getText();
        String s9 = b9.getText();

        //While we're still playing
        if (!gameOver) {

            //Set the computer offence moves 
            //123 offence
            if (s1.equals(s3) && s1.equals("O") && !b2.isSelected()) {
                b2.setText("O");
                b2.setSelected(true);
                check();
            } else if (s1.equals(s2) && s1.equals("O") && !b3.isSelected()) {
                b3.setText("O");
                b3.setSelected(true);
                check();
            } else if (s2.equals(s3) && s2.equals("O") && !b1.isSelected()) {
                b1.setText("O");
                b1.setSelected(true);
                check();
            } //456  offence
            else if (s4.equals(s6) && s4.equals("O") && !b5.isSelected()) {
                b5.setText("O");
                b5.setSelected(true);
                check();
            } else if (s4.equals(s5) && s4.equals("O") && !b6.isSelected()) {
                b6.setText("O");
                b6.setSelected(true);
                check();
            } else if (s5.equals(s6) && s5.equals("O") && !b4.isSelected()) {
                b4.setText("O");
                b4.setSelected(true);
                check();
            } //789 offence
            else if (s7.equals(s9) && s7.equals("O") && !b8.isSelected()) {
                b8.setText("O");
                b8.setSelected(true);
                check();
            } else if (s7.equals(s8) && s7.equals("O") && !b9.isSelected()) {
                b8.setText("O");
                b9.setSelected(true);
                check();
            } else if (s8.equals(s9) && s8.equals("O") && !b7.isSelected()) {
                b7.setText("O");
                b7.setSelected(true);
                check();
            } //147 offence
            else if (s1.equals(s7) && s1.equals("O") && !b4.isSelected()) {
                b4.setText("O");
                b4.setSelected(true);
                check();
            } else if (s1.equals(s4) && s1.equals("O") && !b7.isSelected()) {
                b7.setText("O");
                b7.setSelected(true);
                check();
            } else if (s4.equals(s7) && s4.equals("O") && !b1.isSelected()) {
                b1.setText("O");
                b1.setSelected(true);
                check();
            } //258  offence
            else if (s2.equals(s8) && s2.equals("O") && !b5.isSelected()) {
                b5.setText("O");
                b5.setSelected(true);
                check();
            } else if (s2.equals(s5) && s2.equals("O") && !b8.isSelected()) {
                b8.setText("O");
                b8.setSelected(true);
                check();
            } else if (s5.equals(s8) && s5.equals("O") && !b2.isSelected()) {
                b2.setText("O");
                b2.setSelected(true);
                check();
            } //369   offence
            else if (s3.equals(s9) && s3.equals("O") && !b6.isSelected()) {
                b6.setText("O");
                b6.setSelected(true);
                check();
            } else if (s3.equals(s6) && s3.equals("O") && !b9.isSelected()) {
                b9.setText("O");
                b9.setSelected(true);
                check();
            } else if (s6.equals(s9) && s6.equals("O") && !b3.isSelected()) {
                b3.setText("O");
                b3.setSelected(true);
                check();
            } //159 diagonala  offence
            else if (s1.equals(s9) && s1.equals("O") && !b5.isSelected()) {
                b5.setText("O");
                b5.setSelected(true);
                check();
            } else if (s1.equals(s5) && s1.equals("O") && !b9.isSelected()) {
                b9.setText("O");
                b9.setSelected(true);
                check();
            } else if (s5.equals(s9) && s5.equals("O") && !b1.isSelected()) {
                b1.setText("O");
                b1.setSelected(true);
                check();
            } //357 diagonala  offence
            else if (s3.equals(s7) && s3.equals("O") && !b5.isSelected()) {
                b5.setText("O");
                b5.setSelected(true);
                check();
            } else if (s3.equals(s5) && s3.equals("O") && !b7.isSelected()) {
                b7.setText("O");
                b7.setSelected(true);
                check();
            } else if (s5.equals(s7) && s5.equals("O") && !b3.isSelected()) {
                b3.setText("O");
                b3.setSelected(true);
                check();
            } //defence
            //Seting the cmoputer's defence moves
            //123 defence
            else if (s1.equals(s3) && s1.equals("X") && !b2.isSelected()) {
                b2.setText("O");
                b2.setSelected(true);
                check();
            } else if (s1.equals(s2) && s1.equals("X") && !b3.isSelected()) {
                b3.setText("O");
                b3.setSelected(true);
                check();
            } else if (s2.equals(s3) && s2.equals("X") && !b1.isSelected()) {
                b1.setText("O");
                b1.setSelected(true);
                check();
            } //456 defence
            else if (s4.equals(s6) && s4.equals("X") && !b5.isSelected()) {
                b5.setText("O");
                b5.setSelected(true);
                check();
            } else if (s4.equals(s5) && s4.equals("X") && !b6.isSelected()) {
                b6.setText("O");
                b6.setSelected(true);
                check();
            } else if (s5.equals(s6) && s5.equals("X") && !b4.isSelected()) {
                b4.setText("O");
                b4.setSelected(true);
                check();
            } //789 defence
            else if (s7.equals(s9) && s7.equals("X") && !b8.isSelected()) {
                b8.setText("O");
                b8.setSelected(true);
                check();
            } else if (s7.equals(s8) && s7.equals("X") && !b9.isSelected()) {
                b8.setText("O");
                b9.setSelected(true);
                check();
            } else if (s8.equals(s9) && s8.equals("X") && !b7.isSelected()) {
                b7.setText("O");
                b7.setSelected(true);
                check();
            } //147 defence
            else if (s1.equals(s7) && s1.equals("X") && !b4.isSelected()) {
                b4.setText("O");
                b4.setSelected(true);
                check();
            } else if (s1.equals(s4) && s1.equals("X") && !b7.isSelected()) {
                b7.setText("O");
                b7.setSelected(true);
                check();
            } else if (s4.equals(s7) && s4.equals("X") && !b1.isSelected()) {
                b1.setText("O");
                b1.setSelected(true);
                check();
            } //258 defence
            else if (s2.equals(s8) && s2.equals("X") && !b5.isSelected()) {
                b5.setText("O");
                b5.setSelected(true);
                check();
            } else if (s2.equals(s5) && s2.equals("X") && !b8.isSelected()) {
                b8.setText("O");
                b8.setSelected(true);
                check();
            } else if (s5.equals(s8) && s5.equals("X") && !b2.isSelected()) {
                b2.setText("O");
                b2.setSelected(true);
                check();
            } //369  defence
            else if (s3.equals(s9) && s3.equals("X") && !b6.isSelected()) {
                b6.setText("O");
                b6.setSelected(true);
                check();
            } else if (s3.equals(s6) && s3.equals("X") && !b9.isSelected()) {
                b9.setText("O");
                b9.setSelected(true);
                check();
            } else if (s6.equals(s9) && s6.equals("X") && !b3.isSelected()) {
                b3.setText("O");
                b3.setSelected(true);
                check();
            } //159 diagonala defence
            else if (s1.equals(s9) && s1.equals("X") && !b5.isSelected()) {
                b5.setText("O");
                b5.setSelected(true);
                check();
            } else if (s1.equals(s5) && s1.equals("X") && !b9.isSelected()) {
                b9.setText("O");
                b9.setSelected(true);
                check();
            } else if (s5.equals(s9) && s5.equals("X") && !b1.isSelected()) {
                b1.setText("O");
                b1.setSelected(true);
                check();
            } //357 diagonala defence
            else if (s3.equals(s7) && s3.equals("X") && !b5.isSelected()) {
                b5.setText("O");
                b5.setSelected(true);
                check();
            } else if (s3.equals(s5) && s3.equals("X") && !b7.isSelected()) {
                b7.setText("O");
                b7.setSelected(true);
                check();
            } else if (s5.equals(s7) && s5.equals("X") && !b3.isSelected()) {
                b3.setText("O");
                b3.setSelected(true);
                check();
            } //Random,if there are no offence or defence possibilities
            else {
                int index = (int) (Math.random() * 9) + 1;
                switch (index) {
                    case 1:
                        if (b1.isSelected()) {
                            computerO();
                        } else {
                            b1.setSelected(true);
                            b1.setText("O");
                            check();
                        }
                        break;
                    case 2:
                        if (b2.isSelected()) {
                            computerO();
                        } else {
                            b2.setSelected(true);
                            b2.setText("O");
                            check();
                        }
                        break;
                    case 3:
                        if (b3.isSelected()) {
                            computerO();
                        } else {
                            b3.setSelected(true);
                            b3.setText("O");
                            check();
                        }
                        break;
                    case 4:
                        if (b4.isSelected()) {
                            computerO();
                        } else {
                            b4.setSelected(true);
                            b4.setText("O");
                            check();
                        }
                        break;
                    case 5:
                        if (b5.isSelected()) {
                            computerO();
                        } else {
                            b5.setSelected(true);
                            b5.setText("O");
                            check();
                        }
                        break;
                    case 6:
                        if (b6.isSelected()) {
                            computerO();
                        } else {
                            b6.setSelected(true);
                            b6.setText("O");
                            check();
                        }
                        break;
                    case 7:
                        if (b7.isSelected()) {
                            computerO();
                        } else {
                            b7.setSelected(true);
                            b7.setText("O");
                            check();
                        }
                        break;
                    case 8:
                        if (b8.isSelected()) {
                            computerO();
                        } else {
                            b8.setSelected(true);
                            b8.setText("O");
                            check();
                        }
                        break;
                    case 9:
                        if (b9.isSelected()) {
                            computerO();
                        } else {
                            b9.setSelected(true);
                            b9.setText("O");
                            check();
                        }
                        break;
                }
            }
        }
    }

    //Constructor
    public XsiO() {
        initComponents();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        b2 = new javax.swing.JToggleButton();
        b1 = new javax.swing.JToggleButton();
        b3 = new javax.swing.JToggleButton();
        b5 = new javax.swing.JToggleButton();
        b4 = new javax.swing.JToggleButton();
        b6 = new javax.swing.JToggleButton();
        b8 = new javax.swing.JToggleButton();
        b7 = new javax.swing.JToggleButton();
        b9 = new javax.swing.JToggleButton();
        jLabel2 = new javax.swing.JLabel();
        castigariPlayer1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        castigariPlayer2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        turn = new javax.swing.JLabel();
        labelRemizeText = new javax.swing.JLabel();
        labelRemize = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        b2.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        b2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b2ActionPerformed(evt);
            }
        });

        b1.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        b1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b1ActionPerformed(evt);
            }
        });

        b3.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        b3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b3ActionPerformed(evt);
            }
        });

        b5.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        b5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b5ActionPerformed(evt);
            }
        });

        b4.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        b4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b4ActionPerformed(evt);
            }
        });

        b6.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        b6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b6ActionPerformed(evt);
            }
        });

        b8.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        b8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b8ActionPerformed(evt);
            }
        });

        b7.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        b7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b7ActionPerformed(evt);
            }
        });

        b9.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        b9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b9ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel2.setText("Player1(X):");

        castigariPlayer1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        castigariPlayer1.setText("0");

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel4.setText("Player2(O):");

        castigariPlayer2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        castigariPlayer2.setText("0");

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setText("TURN :");

        turn.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        turn.setText("X");

        labelRemizeText.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        labelRemizeText.setText("Remize:");

        labelRemize.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(b7, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(b8, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(b9, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(47, 47, 47)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(turn)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(b1, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(b2, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(b3, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(b4, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(b5, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(b6, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                                .addComponent(jLabel2)
                                .addGap(29, 29, 29)
                                .addComponent(castigariPlayer1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel4)
                                        .addGap(29, 29, 29))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(52, 52, 52)
                                        .addComponent(labelRemizeText, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(labelRemize, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(castigariPlayer2, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(24, 24, 24))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(b7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(b8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(b9, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(87, 87, 87)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(turn))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(b4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(b5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(b6, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(b1, javax.swing.GroupLayout.DEFAULT_SIZE, 78, Short.MAX_VALUE)
                            .addComponent(b2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(b3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(castigariPlayer1, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(castigariPlayer2, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelRemizeText)
                            .addComponent(labelRemize, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(9, 9, 9)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

//BUTTONS
//  (7) (8) (9)
//  (4) (5) (6)
//  (1) (2) (3)
//Button 1

    private void b1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b1ActionPerformed
        if (vsPlayer) {
            //case PvP
            b1.setText(xOrO);
            switchXO();
            check();
        } else {
            //case PvC
            b1.setText("X");
            check();
            computerO();

        }
    }//GEN-LAST:event_b1ActionPerformed

    //Button 2

    private void b2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b2ActionPerformed
        if (vsPlayer) {
            //case PvP
            b2.setText(xOrO);
            switchXO();
            check();
            setTurn();
        } else {
            //case PvC
            b2.setText("X");
            check();
            computerO();

        }

    }//GEN-LAST:event_b2ActionPerformed

    //Button 3

    private void b3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b3ActionPerformed
        if (vsPlayer) {
            //case PvP
            b3.setText(xOrO);
            switchXO();
            check();
            setTurn();
        } else {
            //case PvC
            b3.setText("X");
            check();
            computerO();

        }
    }//GEN-LAST:event_b3ActionPerformed

    //Button 4

    private void b4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b4ActionPerformed
        if (vsPlayer) {
            //case PvP
            b4.setText(xOrO);
            switchXO();
            check();
            setTurn();
        } else {
            //case PvC
            b4.setText("X");
            check();
            computerO();

        }
    }//GEN-LAST:event_b4ActionPerformed

    //Button 5

    private void b5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b5ActionPerformed
        if (vsPlayer) {
            //case PvP
            b5.setText(xOrO);
            switchXO();
            check();
            setTurn();
        } else {
            //case PvC
            b5.setText("X");
            check();
            computerO();

        }
    }//GEN-LAST:event_b5ActionPerformed

    //Button 6

    private void b6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b6ActionPerformed
        if (vsPlayer) {
            //case PvP
            b6.setText(xOrO);
            switchXO();
            check();
            setTurn();
        } else {
            //case PvC
            b6.setText("X");
            check();
            computerO();

        }
    }//GEN-LAST:event_b6ActionPerformed

    //Button 7

    private void b7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b7ActionPerformed
        if (vsPlayer) {
            //case PvP
            b7.setText(xOrO);
            switchXO();
            check();
            setTurn();
        } else {
            //case PvC
            b7.setText("X");
            check();
            computerO();

        }
    }//GEN-LAST:event_b7ActionPerformed

    //Button 8

    private void b8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b8ActionPerformed
        if (vsPlayer) {
            //case PvP
            b8.setText(xOrO);
            switchXO();
            check();
            setTurn();
        } else {
            //case PvC
            b8.setText("X");
            check();
            computerO();

        }
    }//GEN-LAST:event_b8ActionPerformed

    //Button 9

    private void b9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b9ActionPerformed
        if (vsPlayer) {
            //case PvP
            b9.setText(xOrO);
            switchXO();
            check();
            setTurn();
        } else {
            //case PvC
            b9.setText("X");
            check();
            computerO();

        }
    }//GEN-LAST:event_b9ActionPerformed

    //Main method
    
    public static void main(String args[]) {
        XsiO xo = new XsiO();
        xo.setVisible(true);
        xo.setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        HOW how = new HOW(xo);
        how.setVisible(true);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton b1;
    private javax.swing.JToggleButton b2;
    private javax.swing.JToggleButton b3;
    private javax.swing.JToggleButton b4;
    private javax.swing.JToggleButton b5;
    private javax.swing.JToggleButton b6;
    private javax.swing.JToggleButton b7;
    private javax.swing.JToggleButton b8;
    private javax.swing.JToggleButton b9;
    private javax.swing.JLabel castigariPlayer1;
    private javax.swing.JLabel castigariPlayer2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel labelRemize;
    private javax.swing.JLabel labelRemizeText;
    private javax.swing.JLabel turn;
    // End of variables declaration//GEN-END:variables
}
