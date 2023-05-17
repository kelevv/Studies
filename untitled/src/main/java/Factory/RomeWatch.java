package Factory;

import java.time.LocalTime;

import static Factory.RomanNumberConverter.toRoman;

public class RomeWatch implements Watch {
    @Override
    public void showTime() {
        System.out.println(toRoman(Integer.valueOf(LocalTime.now().getHour()))
                + ":"
                + toRoman(Integer.valueOf(LocalTime.now().getMinute())));
    }
}
