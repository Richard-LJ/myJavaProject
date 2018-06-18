package wuziqi_1;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Main extends JFrame {
	private JPanel p;
	private int Pointx, Pointy;// ������ӵ����λ��
	private int count = 0;// ��õ������������ʵ������ת��
	private ArrayList<Integer> listblack = new ArrayList<>();//��ź������λ��
	private ArrayList<Integer> listblue = new ArrayList<>();//����������λ��

	public Main() {
		super("������");
		p = new JPanel();
		p.addMouseListener(new Monitor());
		this.add(p);

		setSize(750, 750);
		setVisible(true);
	}

	class Monitor extends MouseAdapter {
		@Override
		public void mouseReleased(MouseEvent e) {
			count++;
			Pointx = Location(e.getX() + 8);// ���ʵ�ʵ��λ������������ƫ��
			Pointy = Location(e.getY() + 31);
			repaint();
		}
	}

	public void paint(Graphics g) {
		background.draw(g); // ��������
		// ����õ�֮ǰû����������blacklist��bluelist�������˵�
		if (!listblue.contains(point(Pointx, Pointy)) && !listblack.contains(point(Pointx, Pointy))) {
			if (count % 2 == 0) {
				g.setColor(Color.black);
				g.fillOval(Pointx - 20, Pointy - 20, 40, 40);
				listblack.add(point(Pointx, Pointy));
			} else {
				g.setColor(Color.blue);
				g.fillOval(Pointx - 20, Pointy - 20, 40, 40);
				listblue.add(point(Pointx, Pointy));
			}
		}
		gameOver();
	}

	// ��λ������� �����������λ��
	public int Location(int x) {
		int lx;
		lx = (x * 2 + 50) / 100;
		return lx * 50;
	}

	// ��������ÿ����һ����ţ������ж�ʤ��
	public int point(int x, int y) {
		return x / 50 + (y / 50 - 1) * constant.h;
	}

	public void gameOver() {
		if (ruler.blackWin(listblack)) {
			JOptionPane.showMessageDialog(this, "����ʤ��", "��Ϸ����", JOptionPane.INFORMATION_MESSAGE);
			System.exit(0);
		}
		if (ruler.blueWin(listblue)) {
			JOptionPane.showMessageDialog(this, "����ʤ��", "��Ϸ����", JOptionPane.INFORMATION_MESSAGE);
			System.exit(0);
		}
	}

	public static void main(String[] args) {
		Main m = new Main();
		m.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
