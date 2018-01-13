package com.seeker.hdx.ui;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Welcome  extends JFrame implements ActionListener{


	 JButton button;
	 JPanel panel;
	 JLabel label;
	 
	 public Welcome(){

	  panel = new JPanel();
		 
	  button=new JButton("点击我，开始游戏");
	  
      label = new JLabel();
      
      ImageIcon img = new ImageIcon("welcome.jpg");// 创建图片对象
      int width = img.getIconWidth();
      int heigth = img.getIconHeight();
      
      label.setIcon(img);
      
      
     
      
      panel.add(label);
     
      
      
      this.add(button);
      add(panel);
      
	  button.addActionListener(this);
	  this.setLayout(new FlowLayout());
	  this.setBounds(520, 130, width, heigth);
	  this.setVisible(true);
	  this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	  
	 }
	 public  static void main(String args[]){
		 Welcome fs=new Welcome();
	  
	 }
	 @Override
	 public void actionPerformed(ActionEvent e) {
	  // TODO Auto-generated method stub
	  if(e.getSource()==button){
		  MainFrame fm=new MainFrame();
		  this.dispose();
	  }
	 }
		
}
