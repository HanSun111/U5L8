public class Temperature
{
    private double highTemp;
    private double lowTemp;
    private String tempScale;

    public static final int FREEZING_TEMP_F = 32;

    private static double highestTrackedTempF;
    private static double lowestTrackedTempF;
    private static boolean didSetFirstTemps = false;

    public double getHighTemp() {
        return highTemp;
    }

    public double getLowTemp() {
        return lowTemp;
    }

    public String getTempScale() {
        return tempScale;
    }

    public static double getHighestTrackedTempF() {
        return highestTrackedTempF;
    }

    public static double getLowestTrackedTempF() {
        return lowestTrackedTempF;
    }

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
        if(tempScale.equals("C")) {
            high = convertCtoF(high);
            low = convertCtoF(low);
            if(high > highestTrackedTempF){
                highestTrackedTempF = high;
            }
            if(low < lowestTrackedTempF) {
                lowestTrackedTempF = low;
            }
        }
        if(tempScale.equals("F")) {
        if(high > highestTrackedTempF){
            highestTrackedTempF = high;
        }
        if(low < lowestTrackedTempF) {
            lowestTrackedTempF = low;
        }

            }

        if(!didSetFirstTemps){
            highestTrackedTempF = high;
            lowestTrackedTempF = low;
            didSetFirstTemps = true;
        }

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

    public boolean belowFreezing(){
        if(tempScale.equals("C")){
            changeToF();
        }
        if(highTemp < FREEZING_TEMP_F || lowTemp < FREEZING_TEMP_F){
            return true;
        } return false;
    }

    public boolean sawFreezing(){
        if(tempScale.equals("C")){
            changeToF();
        }
        if(highestTrackedTempF < FREEZING_TEMP_F || lowestTrackedTempF < FREEZING_TEMP_F){
            return true;
        } return false;
    }

}
