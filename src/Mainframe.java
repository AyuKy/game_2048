import javax.swing.*;
public class Mainframe extends JFrame {

    int[][] datas={
            {0,2,2,4},
            {0,0,8,16},
            {2,0,4,8},
            {0,0,0,2},
    };
    public Mainframe(){
        initMainframe();
        paintView();
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
     }
}
