package verimadenciligi;

import java.util.Scanner;

public class Program
{
    public static void main(String[] args)
    {
        DataTable table = new DataTable(new DataColumn[]{Data.KAN,Data.TANSIYON,Data.YAS},Data.SONUC);
        table.run();
    }
}
