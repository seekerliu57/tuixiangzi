package com.seeker.hdx.ui;

import java.awt.Container;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class MainFrame extends JFrame implements KeyListener{
	
	Container c = getContentPane();
	JLabel jl_wolf;
	JLabel jl_sheep3;
	JLabel jl_sheep1;
	JLabel jl_sheep2;
	Sound sound;
	
	public MainFrame(){
 //制作多个图片，最先放的在最上面，所以背景最大要最后放，避免遮盖其他图片
		
		//做笼子
		targetInit();
		//做灰太狼（人物）
		wolfInit();
		//做懒羊羊（箱子）
		sheepInit();
		//做障碍
		treeInit();
		//制作一个背景
		backgroundInit();
		//主窗体界面
		setMainFrameUI();
		//添加键盘监听
		this.addKeyListener(this);
			
	}
	JLabel [][] sheeps = new JLabel[12][16];
	//场景数据的模拟
	//1代表障碍，0代表空地,
	private void victory() {
		// TODO 自动生成的方法存根
		if( num == total){
			int r = JOptionPane.showConfirmDialog(null, "游戏胜利，是否进行下一关？",null,JOptionPane.YES_NO_OPTION);
			if( r == JOptionPane.YES_NO_OPTION){
				
				JOptionPane.showMessageDialog(null, "你已通关", null, JOptionPane.ERROR_MESSAGE); 
				System.exit(0);
				
			}else{
				System.exit(0);
			}

			
		}
	}

	int [] [] datas = {
			{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
			{1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
			{1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
			{1,0,0,0,0,0,0,0,0,0,1,0,1,0,0,1},
			{1,0,0,0,0,0,0,0,0,0,1,0,1,0,0,1},
			{1,0,0,0,1,0,0,0,0,0,1,1,1,0,0,1},
			{1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
			{1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
			{1,0,0,1,0,0,1,0,0,0,0,0,0,0,0,1},
			{1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
			{1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
			{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
	};

	//人物位置
	int wx;
	int wy;
	//记录有多少个箱子和多少个箱子进入目标
	int total = 3;
	int num = 0;
	//障碍初始化
	private void treeInit() {
		// TODO 自动生成的方法存根
		//遍历二维数组
		Icon icon = new ImageIcon("tree.png");
		
		for(int i = 0; i<datas.length; i++){
			for(int j = 0; j<datas[i].length; j++){
				if(datas[i][j] == 1){
					JLabel jl_tree = new JLabel(icon);
					jl_tree.setBounds(j*50+6, i*50+6, 50, 50);
					c.add(jl_tree);
				}
			}
		}
	}

    //笼子初始化	
	private void targetInit() {
		// TODO 自动生成的方法存根
		Icon i = new ImageIcon("target.png");
		JLabel jl_target1 = new JLabel(i);
		jl_target1.setBounds(706, 206, 50, 50);
		c.add(jl_target1);
		datas[4][14] = 8;
		JLabel jl_target2 = new JLabel(i);
		jl_target2.setBounds(706, 256, 50, 50);
		c.add(jl_target2);
		datas[5][14] = 8;
		JLabel jl_target3 = new JLabel(i);
		jl_target3.setBounds(706, 306, 50, 50);
		c.add(jl_target3);
		datas[6][14] = 8;
		
	}
	//箱子初始化
	private void sheepInit() {
		// TODO 自动生成的方法存根
		Icon i = new ImageIcon("sheep_no.png");
		jl_sheep1 = new JLabel(i);
		jl_sheep1.setBounds(306,206, 50,50);
		c.add(jl_sheep1);
		datas[4][6] = 4;
		sheeps[4][6] = jl_sheep1;
		
		jl_sheep2 = new JLabel(i);
		jl_sheep2.setBounds(306,306, 50,50);
		c.add(jl_sheep2);
		datas[6][6] = 4;
		sheeps[6][6] = jl_sheep2;
		
		jl_sheep3 = new JLabel(i);
		jl_sheep3.setBounds(306,406, 50,50);
		c.add(jl_sheep3);
		datas[8][6] = 4;
		sheeps[8][6] = jl_sheep3;
	}
	//推箱子人物初始化
	private void wolfInit() {
		//人物最初位置
		wx = 3;
		wy = 3;
		
		Icon wolf = new ImageIcon("wolf_zm.png");
		jl_wolf = new JLabel(wolf);
		
		jl_wolf.setBounds(wx*50+6,wy*50+6, 50, 50);
		
		c.add(jl_wolf);
		
		
	}
	//背景初始化
	private void backgroundInit() {
		// TODO 自动生成的方法存根
		
		Icon icon = new ImageIcon("floor.png");
		JLabel jl_bg = new JLabel(icon);
		jl_bg.setBounds(6, 6,  800, 600);
		c.add(jl_bg);
		
		
	}
	//设置主窗体界面显示效果
	private void setMainFrameUI(){
		setLayout(null);
		setTitle("灰太狼大战懒羊羊推箱子");
		sound = new Sound();
		sound.loadSound();
		setBounds(300, 200, 826, 660);
		setVisible(true);
	}

	@Override
	//按键释放时调用
	public void keyReleased(KeyEvent arg0) {
		// TODO 自动生成的方法存根
		int key = arg0.getKeyCode();
		
		//上
		if(key == 38){
			
			if(datas[wy-1][wx] == 0 ){
				wy = wy -1;
				//使用jl_wolf.getLocation()可以得到图片点坐标
				int x = (int)jl_wolf.getLocation().getX();
				int y = (int)jl_wolf.getLocation().getY();
				jl_wolf.setLocation(x, y-50);
				Icon i = new ImageIcon("wolf_up.png");
				jl_wolf.setIcon(i);
				return;
			}
			if(datas[wy-1][wx] == 1){
				return;
			}
			if(datas[wy-1][wx] == 4 && datas[wy-2][wx] == 1){
				return;
			}
			if(datas[wy-1][wx] == 4 && datas[wy-2][wx] == 4){
				return;
			}
			if(datas[wy-1][wx] == 4 && datas[wy-2][wx] == 12){
				return;
			}
			if(datas[wy-1][wx] == 12 && datas[wy-2][wx] == 1){
				return;
			}
			if(datas[wy-1][wx] == 12 && datas[wy-2][wx] == 4){
				return;
			}
			if(datas[wy-1][wx] == 12 && datas[wy-2][wx] == 12){
				return;
			}
			
		
			if(datas[wy-1][wx] == 8 ){
				wy = wy -1;
				//使用jl_wolf.getLocation()可以得到图片点坐标
				int x = (int)jl_wolf.getLocation().getX();
				int y = (int)jl_wolf.getLocation().getY();
				jl_wolf.setLocation(x, y-50);
				Icon i = new ImageIcon("wolf_up.png");
				jl_wolf.setIcon(i);
				return;
			}
			if(datas[wy-1][wx] == 4 && datas[wy-2][wx] == 0){
				
				datas[wy-1][wx] = 0;
				datas[wy-2][wx] = 4;
				
			}
			if(datas[wy-1][wx] == 4 && datas[wy-2][wx] == 8){
				datas[wy-1][wx] = 0;
				datas[wy-2][wx] = 12;
				num++;
			}
			if(datas[wy-1][wx] == 12 && datas[wy-2][wx] == 0){
				datas[wy-1][wx] = 8;
				datas[wy-2][wx] = 4;
				num--;
			}
			if(datas[wy-1][wx] == 12 && datas[wy-2][wx] == 8){
				datas[wy-1][wx] = 8;
				datas[wy-2][wx] = 12;
			}
			
			sheeps[wy-1][wx].setLocation(6+wx*50, 6+wy*50-100);
			sheeps[wy-2][wx] = sheeps[wy-1][wx];
			sheeps[wy-1][wx] = null;

			//移动人物
			wy = wy -1;
			//使用jl_wolf.getLocation()可以得到图片点坐标
			int x = (int)jl_wolf.getLocation().getX();
			int y = (int)jl_wolf.getLocation().getY();
			jl_wolf.setLocation(x, y-50);
			Icon i = new ImageIcon("wolf_up.png");
			jl_wolf.setIcon(i);
			victory();
			return;	
		}
		
		//下
		if(key == 40){
			if(datas[wy+1][wx] == 0 ){
				wy = wy + 1;
				//使用jl_wolf.getLocation()可以得到图片点坐标
				int x = (int)jl_wolf.getLocation().getX();
				int y = (int)jl_wolf.getLocation().getY();
				jl_wolf.setLocation(x, y+50);
				Icon i = new ImageIcon("wolf_zm.png");
				jl_wolf.setIcon(i);
				return;
			}
			if(datas[wy+1][wx] == 1){
				return;
			}
			if(datas[wy+1][wx] == 4 && datas[wy+2][wx] == 1){
				return;
			}
			if(datas[wy+1][wx] == 4 && datas[wy+2][wx] == 4){
				return;
			}
			if(datas[wy+1][wx] == 4 && datas[wy+2][wx] == 12){
				return;
			}
			if(datas[wy+1][wx] == 12 && datas[wy+2][wx] == 1){
				return;
			}
			if(datas[wy+1][wx] == 12 && datas[wy+2][wx] == 4){
				return;
			}
			if(datas[wy+1][wx] == 12 && datas[wy+2][wx] == 12){
				return;
			}
			
		
			if(datas[wy+1][wx] == 8 ){
				wy = wy + 1;
				//使用jl_wolf.getLocation()可以得到图片点坐标
				int x = (int)jl_wolf.getLocation().getX();
				int y = (int)jl_wolf.getLocation().getY();
				jl_wolf.setLocation(x, y+50);
				Icon i = new ImageIcon("wolf_zm.png");
				jl_wolf.setIcon(i);
				return;
			}
			if(datas[wy+1][wx] == 4 && datas[wy+2][wx] == 0){
				
				datas[wy+1][wx] = 0;
				datas[wy+2][wx] = 4;
				
			}
			if(datas[wy+1][wx] == 4 && datas[wy+2][wx] == 8){
				datas[wy+1][wx] = 0;
				datas[wy+2][wx] = 12;
				num++;
			}
			if(datas[wy+1][wx] == 12 && datas[wy+2][wx] == 0){
				datas[wy+1][wx] = 8;
				datas[wy+2][wx] = 4;
				num--;
			}
			if(datas[wy+1][wx] == 12 && datas[wy+2][wx] == 8){
				datas[wy+1][wx] = 8;
				datas[wy+2][wx] = 12;
			}
			
			sheeps[wy+1][wx].setLocation(6+wx*50, 6+wy*50+100);
			sheeps[wy+2][wx] = sheeps[wy+1][wx];
			sheeps[wy+1][wx] = null;

			//移动人物
			wy = wy + 1;
			//使用jl_wolf.getLocation()可以得到图片点坐标
			int x = (int)jl_wolf.getLocation().getX();
			int y = (int)jl_wolf.getLocation().getY();
			jl_wolf.setLocation(x, y+50);
			Icon i = new ImageIcon("wolf_zm.png");
			jl_wolf.setIcon(i);
			victory();
			return;	
		}
		
		//左
		if(key == 37){
			if(datas[wy][wx-1] == 0 ){
				wx = wx -1;
				//使用jl_wolf.getLocation()可以得到图片点坐标
				int x = (int)jl_wolf.getLocation().getX();
				int y = (int)jl_wolf.getLocation().getY();
				jl_wolf.setLocation(x-50, y);
				Icon i = new ImageIcon("wolf_left.png");
				jl_wolf.setIcon(i);
				return;
			}
			if(datas[wy][wx-1] == 1){
				return;
			}
			if(datas[wy][wx-1] == 4 && datas[wy][wx-2] == 1){
				return;
			}
			if(datas[wy][wx-1] == 4 && datas[wy][wx-2] == 4){
				return;
			}
			if(datas[wy][wx-1] == 4 && datas[wy][wx-2] == 12){
				return;
			}
			if(datas[wy][wx-1] == 12 && datas[wy][wx-2] == 1){
				return;
			}
			if(datas[wy][wx-1] == 12 && datas[wy][wx-2] == 4){
				return;
			}
			if(datas[wy][wx-1] == 12 && datas[wy][wx-2] == 12){
				return;
			}
			
		
			if(datas[wy][wx-1] == 8 ){
				wx = wx -1;
				//使用jl_wolf.getLocation()可以得到图片点坐标
				int x = (int)jl_wolf.getLocation().getX();
				int y = (int)jl_wolf.getLocation().getY();
				jl_wolf.setLocation(x-50, y);
				Icon i = new ImageIcon("wolf_left.png");
				jl_wolf.setIcon(i);
				return;
			}
			if(datas[wy][wx-1] == 4 && datas[wy][wx-2] == 0){
				
				datas[wy][wx-1] = 0;
				datas[wy][wx-2] = 4;
				
			}
			if(datas[wy][wx-1] == 4 && datas[wy][wx-2] == 8){
				datas[wy][wx-1] = 0;
				datas[wy][wx-2] = 12;
				num++;
			}
			if(datas[wy][wx-1] == 12 && datas[wy][wx-2] == 0){
				datas[wy][wx-1] = 8;
				datas[wy][wx-2] = 4;
				num--;
			}
			if(datas[wy][wx-1] == 12 && datas[wy][wx-2] == 8){
				datas[wy][wx-1] = 8;
				datas[wy][wx-2] = 12;
			}
			
			sheeps[wy][wx-1].setLocation(6+wx*50-100, 6+wy*50);
			sheeps[wy][wx-2] = sheeps[wy][wx-1];
			sheeps[wy][wx-1] = null;

			//移动人物
			wx = wx -1;
			//使用jl_wolf.getLocation()可以得到图片点坐标
			int x = (int)jl_wolf.getLocation().getX();
			int y = (int)jl_wolf.getLocation().getY();
			jl_wolf.setLocation(x-50, y);
			Icon i = new ImageIcon("wolf_left.png");
			jl_wolf.setIcon(i);
			victory();
			return;	
				
		}
		
		//右
		if(key == 39){
			if(datas[wy][wx+1] == 0 ){
				wx = wx +1;
				//使用jl_wolf.getLocation()可以得到图片点坐标
				int x = (int)jl_wolf.getLocation().getX();
				int y = (int)jl_wolf.getLocation().getY();
				jl_wolf.setLocation(x+50, y);
				Icon i = new ImageIcon("wolf_right.png");
				jl_wolf.setIcon(i);
				return;
			}
			if(datas[wy][wx+1] == 1){
				return;
			}
			if(datas[wy][wx+1] == 4 && datas[wy][wx+2] == 1){
				return;
			}
			if(datas[wy][wx+1] == 4 && datas[wy][wx+2] == 4){
				return;
			}
			if(datas[wy][wx+1] == 4 && datas[wy][wx+2] == 12){
				return;
			}
			if(datas[wy][wx+1] == 12 && datas[wy][wx+2] == 1){
				return;
			}
			if(datas[wy][wx+1] == 12 && datas[wy][wx+2] == 4){
				return;
			}
			if(datas[wy][wx+1] == 12 && datas[wy][wx+2] == 12){
				return;
			}
			
		
			if(datas[wy][wx+1] == 8 ){
				wx = wx +1;
				//使用jl_wolf.getLocation()可以得到图片点坐标
				int x = (int)jl_wolf.getLocation().getX();
				int y = (int)jl_wolf.getLocation().getY();
				jl_wolf.setLocation(x+50, y);
				Icon i = new ImageIcon("wolf_right.png");
				jl_wolf.setIcon(i);
				return;
			}
			if(datas[wy][wx+1] == 4 && datas[wy][wx+2] == 0){
				
				datas[wy][wx+1] = 0;
				datas[wy][wx+2] = 4;
				
			}
			if(datas[wy][wx+1] == 4 && datas[wy][wx+2] == 8){
				datas[wy][wx+1] = 0;
				datas[wy][wx+2] = 12;
				num++;
			}
			if(datas[wy][wx+1] == 12 && datas[wy][wx+2] == 0){
				datas[wy][wx+1] = 8;
				datas[wy][wx+2] = 4;
				num--;
			}
			if(datas[wy][wx+1] == 12 && datas[wy][wx+2] == 8){
				datas[wy][wx+1] = 8;
				datas[wy][wx+2] = 12;
			}
			
			sheeps[wy][wx+1].setLocation(6+wx*50+100, 6+wy*50);
			sheeps[wy][wx+2] = sheeps[wy][wx+1];
			sheeps[wy][wx+1] = null;

			//移动人物
			wx = wx +1;
			//使用jl_wolf.getLocation()可以得到图片点坐标
			int x = (int)jl_wolf.getLocation().getX();
			int y = (int)jl_wolf.getLocation().getY();
			jl_wolf.setLocation(x+50, y);
			Icon i = new ImageIcon("wolf_right.png");
			jl_wolf.setIcon(i);
			victory();
			return;			
		}

	}

	@Override
	//键入时调用
	public void keyTyped(KeyEvent arg0) {
		// TODO 自动生成的方法存根
		
	}
	@Override
	//按下时调用
	public void keyPressed(KeyEvent arg0) {
		// TODO 自动生成的方法存根
		
	}

}
