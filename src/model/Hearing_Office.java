package model;



public class Hearing_Office {

    private final int ho_Code;
    private final String hearingOfficeName;
    private final int region;
    private final double processingTime;


    public Hearing_Office( int ho_Code,String hearing_Office_Name, int region, double processingTime) {

        this.hearingOfficeName = hearing_Office_Name;
        this.ho_Code = ho_Code;
        this.region = region;
        this.processingTime = processingTime;

    }
    public String getHearingOfficeName() {
        return hearingOfficeName;
    }

    public int getHo_Code() {
        return ho_Code;
    }
    public int getRegion() {
        return region;
    }
    public double getProcessingTime() {
        return processingTime;
    }

    @Override
    public String toString() {
        return "Hearing_Office{" +
                "ho_Code=" + ho_Code +
                ", hearingOfficeName='" + hearingOfficeName + '\'' +
                ", region=" + region +
                ", processingTime=" + processingTime +
                '}';
    }
}
