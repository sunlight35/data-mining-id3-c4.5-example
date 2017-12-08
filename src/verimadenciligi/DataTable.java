package verimadenciligi;

import java.util.Scanner;

public class DataTable
{
    
    public DataColumn[] columns;
    public DataColumn result;
    private float bestGainValue = 0;
    private int bestGainValueIndex = 0;
    
    public DataTable(DataColumn[] _columns, DataColumn _result)
    {
        columns = _columns;
        result = _result;
        System.out.println("Yeni tablo hafızaya alındı. Entropi değeri: "+Tools.entropy(result.data));
        for(int i = 0; i < columns.length; i++)
        {
            float sum = 0;
            for(int j = 0; j < columns[i].conditions.length;j++)
            {
                sum += ((float)Tools.valueCount(columns[i].conditions[j], columns[i])/(float)columns[i].data.length)*Tools.entropy(Tools.conditionArray(columns[i].conditions[j],columns[i],result));
            }
            if(Tools.entropy(result.data)-sum>bestGainValue)
            {
                bestGainValue = Tools.entropy(result.data)-sum;
                bestGainValueIndex = i;
            }
            System.out.println(columns[i].name+" için kazanç değeri: "+(Tools.entropy(result.data)-sum));
        }
    }
    
    
    public void run()
    {
        if(Tools.differentValueCount(result.data)==1)
        {
            System.out.print("SONUC: "+result.conditions[result.data[0]]+"\n");
            System.exit(0);
        }
        Scanner sc = new Scanner(System.in);
        System.out.print(columns[bestGainValueIndex].name+" için değer giriniz: ");
        for(int i = 0; i<columns[bestGainValueIndex].conditions.length;i++)
        {
            if(Tools.valueCount(columns[bestGainValueIndex].conditions[i], columns[bestGainValueIndex])>0)
            System.out.print(i+")"+columns[bestGainValueIndex].conditions[i]+" ");
        }
        int c = sc.nextInt();
        if(columns.length==1)
        {
            for(int i = 0; i<result.data.length;i++)
            {
                if(columns[0].data[c]==columns[0].data[i])
                {
                    System.out.print("SONUC: "+result.conditions[result.data[i]]+"\n");
                    System.exit(0);
                }
            }
            System.out.print("BEKLENMEYEN BIR HATA OLDU.");
            System.exit(0);
        }
        else
        {
            DataTable next = nextTable(c);
            next.run();
        }
    }

    private DataTable nextTable(int c)
    {
        DataColumn[] nextTableColumns = new DataColumn[columns.length-1];
        DataColumn nextTableResult;
        int j = 0;
        for(int i = 0; i<columns.length;i++)
        {
            if(bestGainValueIndex != i)
            {
                nextTableColumns[j] = new DataColumn(columns[i].name, nextDataArray(c,columns[bestGainValueIndex].data,columns[i].data), columns[i].isNumeric, columns[i].conditions);
                j++;
            }
        }
        nextTableResult = new DataColumn(result.name, nextDataArray(c,columns[bestGainValueIndex].data,result.data), result.isNumeric, result.conditions);
        return new DataTable(nextTableColumns, nextTableResult);
    }

    private int[] nextDataArray(int c, int[]array, int[]otherArray)
    {
        int[] nextDataArray = new int[Tools.valueCount(columns[bestGainValueIndex].conditions[c],columns[bestGainValueIndex])];
        int j = 0;
        for(int i=0;i<array.length;i++)
        {
            if(c==array[i])
            {
                nextDataArray[j] = otherArray[i];
                j++;
            }
        }
        return nextDataArray;
    }
}
