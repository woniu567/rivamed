package mylistener.listenerChange;

import java.awt.*;
import java.awt.event.*;
import java.applet.Applet;

/*第二种：将事件的处理委托给自身对象（自身对象实现了相应的监听器接口）*/
public class ChangeColor2 extends Applet implements ActionListener {

    Button btn;
    Panel pan;
    Color myColor;
    Label myLabel;
    String str;

    public void init() {
        myColor = Color.black;//初始化文本字体颜色
        btn = new Button("单击变色");
        btn.addActionListener(this);//将事件的处理委托给自身
        pan = new Panel();
        pan.setPreferredSize(new Dimension(100, 90));
        pan.setBackground(Color.blue);
        pan.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
        pan.add(btn);
        myLabel = new Label("显示状态");
        pan.add(myLabel);
        str = "Change Color!";
        add(pan);

        addItem("初始化程序...");
    }

    public void start() {
        addItem("启动程序...");
    }

    public void stop() {
        addItem("停止程序...");
    }

    public void destory() {
        addItem("卸载程序...");
    }

    public void paint(Graphics g) {
        g.setFont(new Font("华文行楷", Font.BOLD, 30));
        g.setColor(myColor);
        g.drawString(str, 100, 200);
    }

    public void actionPerformed(ActionEvent e) {
        if (myColor == Color.black) {
            myColor = Color.yellow;
        } else {
            myColor = Color.black;
        }
        repaint();
    }

    public void addItem(String tmp) {
        myLabel.setText(tmp);
        System.out.println(tmp);
    }
}
