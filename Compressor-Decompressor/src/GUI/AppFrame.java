package GUI;

import comp_decomp.compressor;
import comp_decomp.decompressor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class AppFrame extends JFrame implements ActionListener {
    JButton compressButton;
    JButton decompressButton;
    AppFrame(){

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        compressButton=new JButton("Select File to Compress");
        compressButton.setBounds(250,180,300,50);
        compressButton.addActionListener(this);
        decompressButton=new JButton("Select File to Decompress");
        decompressButton.setBounds(250,250,300,50);
        decompressButton.addActionListener((this));

        this.add(compressButton);
        this.add(decompressButton);
        this.setSize(800,500);

        this.getContentPane().setBackground(Color.blue);
        this.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
            if(e.getSource()==compressButton){
                JFileChooser fileChooser=new JFileChooser();
                int response= fileChooser.showSaveDialog((null));
                if(response== JFileChooser.APPROVE_OPTION){
                    File file=new File(fileChooser.getSelectedFile().getAbsolutePath());
                    System.out.print(file);
                    try{
                        compressor.method(file);
                    }
                    catch(Exception ee){
                        JOptionPane.showMessageDialog(null,ee.toString());
                    }
                }
            }
            if(e.getSource()==decompressButton){
                JFileChooser fileChooser=new JFileChooser();
                int response= fileChooser.showSaveDialog((null));
                if(response== JFileChooser.APPROVE_OPTION){
                    File file=new File(fileChooser.getSelectedFile().getAbsolutePath());
                    System.out.print(file);
                    try{
                        decompressor.method(file);
                    }
                    catch(Exception ee){
                        JOptionPane.showMessageDialog(null,ee.toString());
                    }
                }
            }

        }

    }

