package mangoworld.utils;

import java.util.Date;
import java.util.HashMap;

import static mangoworld.utils.Cooldown.CooldownState.*;


public class Cooldown {
    static HashMap<Integer, Long> cooldownMap = new HashMap<Integer, Long>();
    public Cooldown(Object o, long milliseconds)
    {
        Date d = new Date();
        cooldownMap.put(o.hashCode(), d.getTime() + milliseconds);
    }

    public enum CooldownState { Ready, Running, Finished };
    public static CooldownState getState(Object o)
    {
        if(cooldownMap.get(o.hashCode())==null) return Ready;
        long x = cooldownMap.get(o.hashCode());
        Date d = new Date();
        if(d.getTime() > x) {
            cooldownMap.remove(o.hashCode());
            return Finished;
        }
        return Running;
    }
}