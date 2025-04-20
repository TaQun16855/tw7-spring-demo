package com.example.demo.util;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Stream;

/**
 * 
 */
public class Printer {
    
    private final String PREFIX = "tw7: ";
    private final ZoneId zone = ZoneId.of("Asia/Tokyo");
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss SS");
    

    public final void print(Color color, Object... objs) {
        if(objs == null || objs.length == 0) { return ; } 

        Arrays.asList(objs).stream()
            .flatMap(o -> {
                if(o == null) {
                    return Stream.of("null");
                }
                if(o instanceof Collection<?>) {
                    return ((Collection<?>)o).stream();
                }
                if(o.getClass().isArray()) {
                    return Arrays.asList((Object[])o).stream().map(x -> x == null ? "null" : x);
                }
                return Stream.of(o);
            })
            .map(o -> decorate(color, o))
            .forEach(o -> output(o));
    }

    public final void print(Object... objs) {
        print(Color.WHITE, objs);
    }

    // =========================================
    //   前景色
    // =========================================
    public final void gray(Object... objs) {
        print(Color.GRAY, objs);
    }

    public final void red(Object... objs) {
        print(Color.RED, objs);
    }

    public final void green(Object... objs) {
        print(Color.GREEN, objs);
    }

    public final void yellow(Object... objs) {
        print(Color.YELLOW, objs);
    }

    public final void blue(Object... objs) {
        print(Color.BLUE, objs);
    }

    public final void pink(Object... objs) {
        print(Color.PINK, objs);
    }

    public final void cyan(Object... objs) {
        print(Color.CYAN, objs);
    }

    public final void white(Object... objs) {
        print(Color.WHITE, objs);
    }

    // =========================================
    //   背景色
    // =========================================
    public final void _gray(Object... objs) {
        print(Color.$GRAY, objs);
    }

    public final void _red(Object... objs) {
        print(Color.$RED, objs);
    }

    public final void _green(Object... objs) {
        print(Color.$GREEN, objs);
    }

    public final void _yellow(Object... objs) {
        print(Color.$YELLOW, objs);
    }

    public final void _blue(Object... objs) {
        print(Color.$BLUE, objs);
    }

    public final void _pink(Object... objs) {
        print(Color.$PINK, objs);
    }

    public final void _cyan(Object... objs) {
        print(Color.$CYAN, objs);
    }

    public final void _white(Object... objs) {
        print(Color.$WHITE, objs);
    }
    

    public final String now() {
        return LocalDateTime.now(zone).format(formatter);
    }

    private final Object decorate(Color color, Object s) {
        return color + (s == null ? "null" : s.toString()) + Color.END;
    }

    private final void output(Object s) {
        System.out.println(PREFIX.concat(s.toString()));
    }

    public Printer() {}
}
