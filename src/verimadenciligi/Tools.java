package verimadenciligi;

public class Tools
{
    public static int[] conditionArray(String con, DataColumn dat, DataColumn res)
    {
        int[] array = new int[valueCount(con, dat)];
        int j = 0;
        for(int i = 0; i<dat.data.length;i++)
        {
            if(con.equals(dat.conditions[dat.data[i]]))
            {
                array[j] = res.data[i];
                j++;
            }
        }
        return array;
    }
    
    public static float entropy(int[] _array)
    {
        float sum = 0;
        float[] fre = frequencyValues(_array);
        for (int i = 0; i < fre.length; i++)
        {
            sum += fre[i] * (Math.log(fre[i])/Math.log(2));
        }
        return -sum;
    }

    public static float[] frequencyValues(int[] _array)
    {
        int f = 0;
        float[] fre = new float[differentValueCount(_array)];
        for (int i = 0; i < _array.length; i++)
        {
            boolean control = true;
            for (int j = 0; j < i; j++)
            {
                if ((i != j) && (_array[i] == _array[j]))
                {
                    control = false;
                    break;
                }
            }
            if (control)
            {
                int sum = 1;
                for (int j = i + 1; j < _array.length; j++)
                {
                    if (_array[i] == _array[j])
                    {
                        sum++;
                    }
                }
                fre[f] = (float) sum / (float) _array.length;
                f++;
            }
        }
        return fre;
    }
    public static int valueCount(String con, DataColumn dat)
    {
        int sum = 0;
        for(int i=0;i<dat.data.length;i++)
        {
            if(con.equals(dat.conditions[dat.data[i]]))
            {
                sum++;
            }
        }
        return sum;
    }
    
    public static int differentValueCount(int[] _array)
    {
        int count = 1;
        for (int i = 1; i < _array.length; i++)
        {
            boolean control = true;
            for (int j = 0; j < i; j++)
            {
                if (_array[i] == _array[j])
                {
                    control = false;
                    break;
                }
            }
            if (control)
            {
                count++;
            }
        }
        return count;
    }
}
