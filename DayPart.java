package asupekar_hw1;

import java.time.LocalTime;

enum PartsOfDay { MORNING, AFTERNOON, EVENING, NIGHT }

class DayPart {
    
    public DayPart(LocalTime lt) {
        int hour = lt.getHour();
        if (hour >= 5 && hour < 12) 
            dp = PartsOfDay.MORNING;
        else if (hour >= 12 && hour < 17) 
            dp = PartsOfDay.AFTERNOON;
        else if (hour >= 17 && hour < 22)  
            dp = PartsOfDay.EVENING;
        else 
            dp = PartsOfDay.NIGHT;
    }
    
    public DayPart() {
        this(LocalTime.now());
    }
    
    public PartsOfDay getDayPart() {
        return dp;
    }
    
    @Override
    public String toString() {
        switch (dp) {
            case MORNING:
                return "morning";
            case AFTERNOON:
                return "afternoon";
            case EVENING:
                return "evening";
            case NIGHT:
                return "night";
            default:
                return "unknown";
        }
    }

    private PartsOfDay dp;
    
}

