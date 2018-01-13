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
 //�������ͼƬ�����ȷŵ��������棬���Ա������Ҫ���ţ������ڸ�����ͼƬ
		
		//������
		targetInit();
		//����̫�ǣ����
		wolfInit();
		//�����������ӣ�
		sheepInit();
		//���ϰ�
		treeInit();
		//����һ������
		backgroundInit();
		//���������
		setMainFrameUI();
		//��Ӽ��̼���
		this.addKeyListener(this);
			
	}
	JLabel [][] sheeps = new JLabel[12][16];
	//�������ݵ�ģ��
	//1�����ϰ���0����յ�,
	private void victory() {
		// TODO �Զ����ɵķ������
		if( num == total){
			int r = JOptionPane.showConfirmDialog(null, "��Ϸʤ�����Ƿ������һ�أ�",null,JOptionPane.YES_NO_OPTION);
			if( r == JOptionPane.YES_NO_OPTION){
				
				JOptionPane.showMessageDialog(null, "����ͨ��", null, JOptionPane.ERROR_MESSAGE); 
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

	//����λ��
	int wx;
	int wy;
	//��¼�ж��ٸ����ӺͶ��ٸ����ӽ���Ŀ��
	int total = 3;
	int num = 0;
	//�ϰ���ʼ��
	private void treeInit() {
		// TODO �Զ����ɵķ������
		//������ά����
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

    //���ӳ�ʼ��	
	private void targetInit() {
		// TODO �Զ����ɵķ������
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
	//���ӳ�ʼ��
	private void sheepInit() {
		// TODO �Զ����ɵķ������
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
	//�����������ʼ��
	private void wolfInit() {
		//�������λ��
		wx = 3;
		wy = 3;
		
		Icon wolf = new ImageIcon("wolf_zm.png");
		jl_wolf = new JLabel(wolf);
		
		jl_wolf.setBounds(wx*50+6,wy*50+6, 50, 50);
		
		c.add(jl_wolf);
		
		
	}
	//������ʼ��
	private void backgroundInit() {
		// TODO �Զ����ɵķ������
		
		Icon icon = new ImageIcon("floor.png");
		JLabel jl_bg = new JLabel(icon);
		jl_bg.setBounds(6, 6,  800, 600);
		c.add(jl_bg);
		
		
	}
	//���������������ʾЧ��
	private void setMainFrameUI(){
		setLayout(null);
		setTitle("��̫�Ǵ�ս������������");
		sound = new Sound();
		sound.loadSound();
		setBounds(300, 200, 826, 660);
		setVisible(true);
	}

	@Override
	//�����ͷ�ʱ����
	public void keyReleased(KeyEvent arg0) {
		// TODO �Զ����ɵķ������
		int key = arg0.getKeyCode();
		
		//��
		if(key == 38){
			
			if(datas[wy-1][wx] == 0 ){
				wy = wy -1;
				//ʹ��jl_wolf.getLocation()���Եõ�ͼƬ������
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
				//ʹ��jl_wolf.getLocation()���Եõ�ͼƬ������
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

			//�ƶ�����
			wy = wy -1;
			//ʹ��jl_wolf.getLocation()���Եõ�ͼƬ������
			int x = (int)jl_wolf.getLocation().getX();
			int y = (int)jl_wolf.getLocation().getY();
			jl_wolf.setLocation(x, y-50);
			Icon i = new ImageIcon("wolf_up.png");
			jl_wolf.setIcon(i);
			victory();
			return;	
		}
		
		//��
		if(key == 40){
			if(datas[wy+1][wx] == 0 ){
				wy = wy + 1;
				//ʹ��jl_wolf.getLocation()���Եõ�ͼƬ������
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
				//ʹ��jl_wolf.getLocation()���Եõ�ͼƬ������
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

			//�ƶ�����
			wy = wy + 1;
			//ʹ��jl_wolf.getLocation()���Եõ�ͼƬ������
			int x = (int)jl_wolf.getLocation().getX();
			int y = (int)jl_wolf.getLocation().getY();
			jl_wolf.setLocation(x, y+50);
			Icon i = new ImageIcon("wolf_zm.png");
			jl_wolf.setIcon(i);
			victory();
			return;	
		}
		
		//��
		if(key == 37){
			if(datas[wy][wx-1] == 0 ){
				wx = wx -1;
				//ʹ��jl_wolf.getLocation()���Եõ�ͼƬ������
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
				//ʹ��jl_wolf.getLocation()���Եõ�ͼƬ������
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

			//�ƶ�����
			wx = wx -1;
			//ʹ��jl_wolf.getLocation()���Եõ�ͼƬ������
			int x = (int)jl_wolf.getLocation().getX();
			int y = (int)jl_wolf.getLocation().getY();
			jl_wolf.setLocation(x-50, y);
			Icon i = new ImageIcon("wolf_left.png");
			jl_wolf.setIcon(i);
			victory();
			return;	
				
		}
		
		//��
		if(key == 39){
			if(datas[wy][wx+1] == 0 ){
				wx = wx +1;
				//ʹ��jl_wolf.getLocation()���Եõ�ͼƬ������
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
				//ʹ��jl_wolf.getLocation()���Եõ�ͼƬ������
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

			//�ƶ�����
			wx = wx +1;
			//ʹ��jl_wolf.getLocation()���Եõ�ͼƬ������
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
	//����ʱ����
	public void keyTyped(KeyEvent arg0) {
		// TODO �Զ����ɵķ������
		
	}
	@Override
	//����ʱ����
	public void keyPressed(KeyEvent arg0) {
		// TODO �Զ����ɵķ������
		
	}

}
