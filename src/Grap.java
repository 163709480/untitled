import java.util.ArrayList;
import java.util.Arrays;

public class Grap {
    public static void main(String[] args) {
        int n=5;
        String[] nu={"A","B","C","D","E"};
        Grap gr= new Grap(n);
        for(String vlaue: nu){
            gr.Insertvert(vlaue);
        }
        gr.InsertNun(0,1,1);
        gr.InsertNun(0,2,1);
        gr.InsertNun(0,3,1);
        gr.InsertNun(1,2,1);
        gr.InsertNun(3,4,1);
        gr.showGrap();
        System.out.println("dfs遍历食肉");
        gr.dfs();

    }
   //顶点
    private ArrayList<String>vert;
    //边
    private int edge;
   //二维数组矩阵
   private int[][] nun;
   //定义给数组boolean[],记录某个结点是否被访问
    private boolean[] isVisted;
   public Grap(int n){

       nun=new int[n][n];
       vert= new ArrayList<String>(n);
       edge=0;
       isVisted= new boolean[5];
   }
   //得到第一个临界结点的下标w
    //如果存在就返回对应下标，否则返回-1
    public int getFirstNeighbor(int index){
       for(int j=0;j<vert.size();j++){
           if(nun[index][j]>0){
               return j;
           }
       }
       return -1;
    }
    //根据前一个邻接结点的下标来获取下一个邻接结点
    public int getNextNeighbor(int v1,int v2){
       for(int j=v2+1;j<vert.size();j++){
           if(nun[v1][j]>0){
               return j;
           }
       }
       return -1;
    }

    //深度优先便利算法
    public void dfs(boolean[] isVisted,int i){
       //首先我们访问该结点,输出
        System.out.print(getVertex(i)+"->");
        //将结点设置为已经访问
        isVisted[i]=true;
        //查找结点i的第一个邻接结点w
        int w=getFirstNeighbor(i);

        while (w!=-1){
            if(!isVisted[w]){

                dfs(isVisted,w);
            }
            //如果w已经被访问
            w=getNextNeighbor(i,w);
        }




    }
    //对dfs进行重载,
    public void dfs(){
       //遍历所有结点进行dfs[回溯;
        for(int i=0;i<getVeetexnum();i++){
            if(!isVisted[i]){
                dfs(isVisted,i);
            }


        }
    }


   //插入顶点
    public void Insertvert(String n){
       vert.add(n);

    }
    //插入边
    public void InsertNun(int v1,int v2,int weigh){
       nun[v1][v2]=weigh;
       nun[v2][v1]=weigh;
       edge++;


    }
    //返回边的数量
    public int getEdge(){
       return edge;
    }
    public int getVeetexnum(){
       return vert.size();
    }
    //返回给定下标的订单
    public String getVertex(int n){
      return vert.get(n);
    }
    //显示矩阵
    public void showGrap(){
       for( int[] value:nun){
           System.out.println(Arrays.toString(value));
       }



    }


}
