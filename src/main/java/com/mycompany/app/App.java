package com.mycompany.app;

import java.io.File;
import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;

/**
 * Hello world!
 */
public class App {

    public static final String AM = "good morning";
    public static final String PM = "good afternoon";
    public static final String EVE = "good evening";
    private static final String MESSAGE = "Hello ";

    public App() {}

    public static void main(String[] args) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
        LocalDateTime now = LocalDateTime.now();

        System.out.println("=========================");
        System.out.println("==     System info     ==");
        System.out.println("== " + dtf.format(now)+" ==");
        System.out.println("=========================");

        Calendar time = Calendar.getInstance();
        String userName = System.getProperty("user.name");
        System.out.println(MESSAGE + userName +", " + decodePeriod(time) + "! This yours system info..");
        System.out.println();
        
        System.out.println("Hostname: " + System.getenv().get("HOSTNAME"));
        System.out.println("System property: " + System.getProperty("user.dir"));
        System.out.println("Operating System: " + System.getProperty("os.name"));
        System.out.println("Java runtime version: " + System.getProperty("java.runtime.version" ));
        System.out.println();

        long memorySize = ((com.sun.management.OperatingSystemMXBean) ManagementFactory
            .getOperatingSystemMXBean()).getTotalPhysicalMemorySize();
        System.out.println(String.format("Memory Size: %.2f GB", 
            (double)memorySize/1073741824) +" GB");
        MemoryMXBean memoryMXBean = ManagementFactory.getMemoryMXBean();
        System.out.println(String.format("Initial memory: %.2f GB", 
            (double)memoryMXBean.getHeapMemoryUsage().getInit() /1073741824));
        System.out.println(String.format("Used heap memory: %.2f GB",
            (double)memoryMXBean.getHeapMemoryUsage().getUsed() /1073741824));
        System.out.println(String.format("Max heap memory: %.2f GB", 
            (double)memoryMXBean.getHeapMemoryUsage().getMax() /1073741824));
        System.out.println(String.format("Committed memory: %.2f GB", 
            (double)memoryMXBean.getHeapMemoryUsage().getCommitted() /1073741824));      
        Runtime rs = Runtime.getRuntime();
        System.out.println("Free memory in JVM before Garbage Collection = "+
            String.format("Memory Size: %.2f GB", 
            (double)(rs.freeMemory())/1073741824) +" GB");
        rs.gc();
        System.out.println("Free memory in JVM after Garbage Collection = "+
            String.format("Memory Size: %.2f GB", 
            (double)(rs.freeMemory())/1073741824) +" GB");
        System.out.println();

        // System.out.println("Total space: " + 
        //     (double)new File("/").getTotalSpace()/1024/1024/1024 + " GB");
        System.out.println(String.format("Total space: %.2f GB", 
            (double)new File("/").getTotalSpace() /1073741824));
        System.out.println(String.format("Free space: %.2f GB", 
            (double)new File("/").getFreeSpace() /1073741824));
        System.out.println(String.format("Usable space: %.2f GB", 
            (double)new File("/").getUsableSpace() /1073741824));
        System.out.println();

        System.out.println("CPU info:");
        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
        for(Long threadID : threadMXBean.getAllThreadIds()) {
            ThreadInfo info = threadMXBean.getThreadInfo(threadID);
            System.out.println("Thread name: " + info.getThreadName());
            System.out.println("Thread State: " + info.getThreadState());
            System.out.println(String.format("CPU time: %s ns", 
            threadMXBean.getThreadCpuTime(threadID)));
        }
        // System.out.println("More:");
        // System.getenv().forEach((k, v) -> {
        //     System.out.println(k + ":" + v);
        // });
        System.out.println("=========================");
    }

    public String getMessage() {
        return MESSAGE;
    }

    /**
     * Determines if we're in the morning or afternoon
     * 
     * @param time the time to decode.
     * @return String representing the period of the day.
     * 
     * source: http://www.java2s.com/example/java/java.util/determines-if-were-in-the-morning-or-afternoon.html
     */

    public static String decodePeriod(final Calendar time) {
        String decodedPeriod = null;
        int hour = time.get(Calendar.HOUR_OF_DAY);
        if (hour >= 18) {
            decodedPeriod = EVE;
        } else if (hour >= 12) {
            decodedPeriod = PM;
        } else {
            decodedPeriod = AM;
        }
        return decodedPeriod;
    }
}
