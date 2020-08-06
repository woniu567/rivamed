package mylistener.listenerChange;

import java.applet.Applet;
import java.awt.event.*;
import java.awt.*;

/*第一种：将事件的处理委托给其他对象，下面的例子是委托给了MyListener（implements ActionListener）*/
public class ChangeColor extends Applet {//Applet的默认布局为FlowLayout方式

    Color myColor;
    String str;
    Button btn;
    Label myLabel;
    Panel panBtn;

    public void init() {
        myColor = Color.black;
        str = "Change Font Color";
        myLabel = new Label("显示状态!");
        btn = new Button("单击变色");
        panBtn = new Panel();

        panBtn.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));//设置面板的对齐方式
        panBtn.setPreferredSize(new Dimension(100, 90));
        panBtn.setBackground(Color.yellow);
        btn.addActionListener(new myListener(this));//为Button添加监听器，通过传递一个ChangeColor的引用来构造自己的监听器
        panBtn.add(btn);
        panBtn.add(myLabel);
        setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));//设置Applet的对齐方式
        add(panBtn);

        addItem("初始化...");
    }

    public void start() {
       /*panBtn.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));//设置面板的对齐方式
       panBtn.setPreferredSize(new Dimension(100,90));
       panBtn.setBackground(Color.yellow);
       btn.addActionListener(new myListener(this));
       panBtn.add(btn);
       panBtn.add(myLabel);
       setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));//设置Applet的对齐方式
       add(panBtn);*/

        //一般常在start()中启动动画或播放声音等的线程， 所以上面的/**/内容最好还是放在init()方法中
        addItem("启动...");
    }

    public void stop() {
        addItem("停止...");
    }

    public void destroy() {
        addItem("准备卸载...");
    }

    public void addItem(String text) {
        myLabel.setText(text);
        System.out.println(text);
    }

    public void paint(Graphics g) {
        g.setColor(myColor);
        //g.setFont(new Font("华文彩云", Font.BOLD, 20));
        g.setFont(new Font("Segoe Script", Font.BOLD, 20));
        g.drawString(str, 100, 200);
    }
}

/*定义自己的监听器类*/
class myListener implements ActionListener {
    ChangeColor xy;

    public myListener(ChangeColor x) {//在这里我们想要调用其他类中的变量
        xy = x;
    }

    public void actionPerformed(ActionEvent e) {
        if (xy.myColor == Color.black)
            xy.myColor = Color.red;
        else
            xy.myColor = Color.black;
        xy.repaint();
    }
}
