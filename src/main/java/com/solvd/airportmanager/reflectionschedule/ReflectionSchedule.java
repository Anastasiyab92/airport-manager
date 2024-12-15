package com.solvd.airportmanager.reflectionschedule;


import com.solvd.airportmanager.schedule.Schedule;
import com.solvd.airportmanager.schedule.WeekDay;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.util.Arrays;

public class ReflectionSchedule {

    private static final Logger LOGGER = LogManager.getLogger(ReflectionSchedule.class);

    public static void main(String[] args) {
        try {
            LOGGER.info("Using Reflection to explore the Schedule class:");
            Class<?> scheduleClass = Class.forName("com.solvd.airportmanager.schedule.Schedule");
            LOGGER.info("Name of class: {}", scheduleClass);

            LOGGER.info("Fields:");
            Field[] fieldsOfScheduleClass = scheduleClass.getDeclaredFields();
            Arrays.stream(fieldsOfScheduleClass)
                    .forEach(field -> LOGGER.info("{}, {}, {}", Modifier.toString(field.getModifiers()),
                            field.getType(), field.getName()));

            LOGGER.info("Constructors: ");
            Constructor<?>[] constructorsScheduleClass = scheduleClass.getDeclaredConstructors();
            Arrays.stream(constructorsScheduleClass)
                    .forEach(constructor -> LOGGER.info("{}, {}", Modifier.toString(constructor.getModifiers()),
                            constructor.getName()));

            LOGGER.info("Methods: ");
            Method[] methodsScheduleClass = scheduleClass.getDeclaredMethods();
            Arrays.stream(methodsScheduleClass)
                    .forEach(method -> LOGGER.info("{}, {}, {}", Modifier.toString(method.getModifiers()),
                            method.getReturnType(), method.getName()));

            Constructor<?> constructor = scheduleClass.getDeclaredConstructor(LocalDateTime.class);
            LocalDateTime now = LocalDateTime.now();
            Schedule schedule = (Schedule) constructor.newInstance(now);
            Method mapToWeekDayMethod = scheduleClass.getMethod("mapToWeekDay", DayOfWeek.class);
            mapToWeekDayMethod.setAccessible(true);
            WeekDay result = (WeekDay) mapToWeekDayMethod.invoke(schedule, WeekDay.MONDAY);
            LOGGER.info("Result of mapToWeekDay for MONDAY: {}", result);

            Field dateTimeField = scheduleClass.getDeclaredField("dateTime");
            dateTimeField.setAccessible(true);
            LOGGER.info("Field 'dateTime': {}", dateTimeField.get(schedule));
        } catch (Exception e) {
            LOGGER.error("Reflection error: ", e);
        }
    }
}
