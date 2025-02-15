import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Mainframe extends JFrame implements KeyListener {

    int[][] datas={
            {0,2,2,4},
            {0,0,8,16},
            {2,0,4,8},
            {0,0,0,2},
    };
    public Mainframe(){
        initMainframe();
        paintView();
        this.addKeyListener(this);

        setVisible(true);
    }
    //窗体初始化
     public void initMainframe() {
         setSize(500, 520);
         setTitle("2048小游戏");//窗体标题
         setLayout(null);//取消默认布局
         setLocationRelativeTo(null);//窗体居中
         setAlwaysOnTop(true);//窗体层次置顶
         setDefaultCloseOperation(3);//窗体关闭模式
     }

     //绘制游戏画面
    public void paintView(){

        getContentPane().removeAll();//先将窗口内容全部移除

        for(int i=0;i<4;i++){
            for(int j = 0;j<4;j++){
                JLabel image= new JLabel(new ImageIcon("F:\\Code\\ideaProject_java\\game_2048\\pictures\\"+datas[i][j]+".png"));
                image.setBounds(35+j*105,35+i*105,100,100);
                getContentPane().add(image);
            }
        }
        JLabel backround = new JLabel(new ImageIcon("F:\\Code\\ideaProject_java\\game_2048\\pictures\\backround.png"));
        backround.setBounds(18,25,450,450);
        getContentPane().add(backround);

        getContentPane().repaint();//重新绘制
     }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int flag = e.getKeyCode();
        switch (flag){
            case 37:moveLeft();break;//左移逻辑
            case 38:moveUp();break;//上移逻辑
            case 39:moveRight();break;//右移逻辑
            case 40:moveDown();break;//下移逻
        }
        paintView();
    }



    //二维数组逆时针旋转90°
    private void anticlockwise(){
        int[][] newdatas=new int[4][4];
        for (int i = 0; i < datas.length; i++) {
            for (int j = 0; j < datas.length; j++) {
                newdatas[3-j][i]=datas[i][j];
            }
        }
        datas=newdatas;
    }
    //顺时针旋转90°
    private void clockwise(){
        int[][] newdatas=new int[4][4];
        for (int i = 0; i < datas.length; i++) {
            for (int j = 0; j < datas.length; j++) {
                newdatas[j][3-i]=datas[i][j];
            }
        }
        datas=newdatas;
    }


    //二维数组水平翻转
    public void swapDatas(){
        for (int i = 0; i < datas.length; i++) {
            for(int start=0,end= datas[i].length-1;start<end;start++,end--){
                int temp=datas[i][start];
                datas[i][start]=datas[i][end];
                datas[i][end]=temp;
            }
        }
    }

    //数据左移动
    public void moveLeft() {
        for (int i = 0; i < datas.length; i++) {
            //后置0元素
            int[] newArr =new int[4];
            int index=0;
            for (int j = 0; j < datas[i].length; j++) {
                if(datas[i][j]!=0){
                    newArr[index]=datas[i][j];
                    index++;
                }
            }
            datas[i]=newArr;

            //合并
            for (int k = 0; k < 3; k++) {
                if(datas[i][k]==datas[i][k+1]){
                    datas[i][k]*=2;
                    for(int n=k+1;n<3;n++){
                        datas[i][n]=datas[i][n+1];
                    }
                    datas[i][3]=0;
                }
            }
        }
    }

    //数据上移动
    public void moveUp() {
        anticlockwise();
        moveLeft();
        clockwise();
    }
    //数据右移动
    public void moveRight() {
        swapDatas();
        moveLeft();
        swapDatas();
    }

    //数据下移动
    public void moveDown() {
        clockwise();
        moveLeft();
        anticlockwise();
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
