import javax.print.DocFlavor;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    private ArrayList<String> vertexList;
    private int[][] edges;
    private int numOFEDges;//边的数目

    public Main(int n){
        //初始化
        edges= new int[n][n];
        vertexList= new ArrayList<String>(n);
        numOFEDges=0;
    }
    //返回结点的个数
    public int getNumOFver(){
        return vertexList.size();
    }
    public int getNumOFEDges(){
        return numOFEDges;
    }

    //返回结点i(下标)对应的数据
    public String getValueByindex(int i){
        return vertexList.get(i);
    }
    //返回v1和v2的权值
    public int getWeight(int v1,int v2){
        return edges[v1][v2];

    }
    //显示图对应的矩阵
    public void showGraph(){
        for(int[] link :edges){
            System.out.println(Arrays.toString(link));
        }
    }


    //插入节点
    public void insertVertix(String vaetex){
        vertexList.add(vaetex);
    }
    //添加边
    public void insertEdge(int v1,int v2,int weight){
        edges[v1][v2]=weight;
        edges[v2][v1]=weight;
        numOFEDges++;

    }










    public static void main(String[] args) {

        int n=5;//结点的个数
        String Vertexval[]={"A","B","C","D","E"};
        //创建图对象
        Main ma= new Main(n);
        for(String value : Vertexval){
            ma.insertVertix(value);
        }
        //添加边
        ma.insertEdge(0,1,1);//A-B
        ma.insertEdge(0,2,1);//A-C
        ma.insertEdge(1,2,1);//
        ma.insertEdge(1,3,1);
        ma.insertEdge(1,4,1);
        //显示矩阵
        ma.showGraph();





    }
}