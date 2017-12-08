package verimadenciligi;

public class Data
{

    public static DataColumn KAN = new DataColumn("KAN", new int[]
    {
        1, 2, 3, 3, 0, 1, 2, 0, 3, 1, 1, 2, 0, 0
    }, false, new String[]
    {
        "0", "A", "B", "AB"
    });

    public static DataColumn TANSIYON = new DataColumn("TANSIYON", new int[]
    {
        75, 65, 45, 43, 87, 85, 63, 75, 45, 77, 75, 78, 77, 87
    }, true, new String[]
    {
        null
    });

    public static DataColumn YAS = new DataColumn("YAS", new int[]
    {
        0, 0, 1, 0, 1, 2, 2, 1, 2, 0, 0, 2, 2, 1
    }, false, new String[]
    {
        "GENC", "ORTA", "YASLI"
    });

    public static DataColumn SONUC = new DataColumn("SONUC", new int[]
    {
        0, 1, 1, 0, 0, 1, 0, 1, 0, 1, 1, 0, 0, 1
    }, false, new String[]
    {
        "NEGATIF", "POZITIF"
    });
}
