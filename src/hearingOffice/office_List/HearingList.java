package hearingOffice.office_List;



import hearingOffice.HearingOffices.Hearing_Office;

import java.util.HashMap;
import java.util.Map;

public class HearingList {


    private static Map<Integer, Hearing_Office> hearingOfficeList = new HashMap<>();




    public HashMap<Integer, Hearing_Office> getHearingList(){

                return new HashMap<>(hearingOfficeList);
    }


}