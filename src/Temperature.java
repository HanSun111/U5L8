public class Temperature
{
    private double highTemp;
    private double lowTemp;
    private String tempScale;
    private static double highestTrackedTempF;
    private static double lowestTrackedTempF;
    public Temperature(double high, double low, String scale)
    {
        highTemp = high;
        lowTemp = low;

        if (scale.equals("F") || scale.equals("C"))
        {
            tempScale = scale;
        }
        else
        {
            tempScale = "F";
        }

        highestTrackedTempF = high;
        lowestTrackedTempF = low;
    }

    public static double convertCtoF(double temp){
        return (temp * 1.8) + 32;
    }
    public static double convertFtoC(double temp){
        return (temp - 32) * 5 / 9;
    }

    public void changeToC(){
        if(tempScale.equals("F")){
            highTemp = convertFtoC(highTemp);
            lowTemp = convertFtoC(lowTemp);
            tempScale = "C";
        }
    }
    public void changeToF(){
        if(tempScale.equals("C")){
            highTemp = convertCtoF(highTemp);
            lowTemp = convertCtoF(lowTemp);
            tempScale = "F";
        }
    }
    private static double roundToNearestTenth(double num){
        return Math.round(num * 10.0) / 10.0;
    }
    public String toString()
    {
        return "highTemp: " + roundToNearestTenth(highTemp) + " " + tempScale +  "\nlowTemp: " + roundToNearestTenth(lowTemp) + " " + tempScale;
    }
    public static final int freezing(){
        return 32;
    }
}
