package verimadenciligi;

import java.util.Arrays;

public class DataColumn
{

    public String name;
    public int[] data;
    public boolean isNumeric;
    public String[] conditions;

    public DataColumn(String _name, int[] _data, boolean _isNumeric, String[] _conditions)
    {
        name = _name;
        data = _data;
        isNumeric = _isNumeric;
        if (isNumeric)
        {
            int p = getPivot();
            for (int i = 0; i < data.length; i++)
            {
                if (data[i] > p)
                {
                    data[i] = 1;
                } else
                {
                    data[i] = 0;
                }
            }
            conditions = new String[]
            {
                p + "'DEN KUCUK ESIT", p + "'DEN BUYUK"
            };
            isNumeric = false;
        } else
        {
            conditions = _conditions;
        }
    }

    private int getPivot()
    {
        int[] array = new int[Tools.differentValueCount(data)];
        int j = 0;
        for (int i = 0; i < data.length; i++)
        {
            boolean control = true;
            if (i > 0)
            {
                for (int t = 0; t < i; t++)
                {
                    if(data[i]==data[t])
                    {
                        control = false;
                        break;
                    }
                }
            }
            if (control)
            {
                array[j] = data[i];
                j++;
            }
        }
        //int[] array = data.clone();
        Arrays.sort(array);
        int p = 0;
        if (array.length % 2 == 0)
        {
            p = (array[(array.length / 2)-1] + array[array.length / 2]) / 2;
        } else
        {
            p = array[array.length / 2];
        }
        return p;
    }
}
