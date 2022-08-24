package com.interview;

import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;

public class days30 {

    public void days30(){
        LocalDate curDate = LocalDate.of(2019, 02, 27);
        int daysBetweenPeriod = ((curDate.plusDays(1).getYear() - curDate.getYear()) * 360) + ((curDate.plusDays(1).getMonthValue() - curDate.getMonthValue()) * 30) +
                ((isEndOfMonth(curDate.plusDays(1)) ? 30 : curDate.plusDays(1).getDayOfMonth()) - (isEndOfMonth(curDate) ? 30 : curDate.getDayOfMonth()));
        System.out.println(daysBetweenPeriod);
    }

    boolean isEndOfMonth(LocalDate date) {
        return date.equals(date.with(TemporalAdjusters.lastDayOfMonth()));
    }

}
