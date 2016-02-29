<<<<<<< HEAD
package com.softdesign.school.utils;

import android.util.Log;

import com.softdesign.school.BuildConfig;

import java.util.ArrayList;

/**
 * Зарефакторить код логера в соответствии с данными на лекции рекомендациями, исспользовать подход DRY Don’t repeat yourself (не повторяй себя) -
 * т.е. избегаем повторения уже ранее написанного кода + Javadoc,
 * логер должен исспользовать различные уровни вывода логов (Verbose, debug, info, error, warn, assert ).
 */
public class Lg {

    private static final String PREFIX = "SCHOOL_";
    public static final int LOGCAT_BUFFER_SIZE = 3000;

    /**
     * Send a INFO log message.
     *
     * @param tag  Used to identify the source of a log message.  It usually identifies
     *             the class or activity where the log call occurs.
     * @param text The message you would like logged.
     */
    public static void i(String tag, String text) {
        logMessage(Log.INFO, tag, text);
    }

    /**
     * Send a ERROR log message.
     *
     * @param tag  Used to identify the source of a log message.  It usually identifies
     *             the class or activity where the log call occurs.
     * @param text The message you would like logged.
     */
    public static void e(String tag, String text) {
        logMessage(Log.ERROR, tag, text);
    }

    /**
     * Send a WARN log message.
     *
     * @param tag  Used to identify the source of a log message.  It usually identifies
     *             the class or activity where the log call occurs.
     * @param text The message you would like logged.
     */
    public static void w(String tag, String text) {
        logMessage(Log.WARN, tag, text);
    }

    /**
     * Send a DEBUG log message.
     *
     * @param tag  Used to identify the source of a log message.  It usually identifies
     *             the class or activity where the log call occurs.
     * @param text The message you would like logged.
     */
    public static void d(String tag, String text) {
        logMessage(Log.DEBUG, tag, text);
    }

    /**
     * Send a VERBOSE log message.
     *
     * @param tag  Used to identify the source of a log message.  It usually identifies
     *             the class or activity where the log call occurs.
     * @param text The message you would like logged.
     */
    public static void v(String tag, String text) {
        logMessage(Log.VERBOSE, tag, text);
    }

    /**
     * Send a ASSERT log message.
     *
     * @param tag  Used to identify the source of a log message.  It usually identifies
     *             the class or activity where the log call occurs.
     * @param text The message you would like logged.
     */
    public static void a(String tag, String text) {
        logMessage(Log.ASSERT, tag, text);
    }


    /**
     * Low-level logging call.
     * If logging enabled in Build config, logs text with priority and tag.
     * If text is too long, splits it by LOGCAT_BUFFER_SIZE
     *
     * @param priority The priority/type of this log message
     * @param tag      Used to identify the source of a log message.  It usually identifies
     *                 the class or activity where the log call occurs.
     * @param text     The message you would like logged.
     */
    private static void logMessage(int priority, String tag, String text) {
        if (BuildConfig.IS_LOGCAT_LOGGER_ENABLED) {
            int start = 0;
            String prefixWithTag = PREFIX + tag;
            for (int end : generateOffsetList(text.length())) {
                Log.println(priority, prefixWithTag, text.substring(start, end));
                start = end;
            }
        }
    }

    /**
     * Generate list of offsets in a string.
     * Added because it's easy to test.
     *
     * @param lenght text lenght
     * @return The list of offsets
     */
    private static ArrayList<Integer> generateOffsetList(int lenght) {
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 1; i < (lenght / LOGCAT_BUFFER_SIZE) + 1; i++) {
            list.add(i * LOGCAT_BUFFER_SIZE);
        }
        if (lenght % LOGCAT_BUFFER_SIZE > 0) list.add(lenght);

        return list;
    }
}
=======
<<<<<<< HEAD
package com.softdesign.school.utils;

import android.util.Log;
=======
package com.softdesign.school_softdesign.utils;

import android.util.Log;
import com.softdesign.school_softdesign.BuildConfig;
>>>>>>> 4a2a4a2a849f4771ede8027f34811bdd87c21b97

/**
 *  Класс для вывода сообщений в лог.
 */
public class Lg {

    private static final String PREFIX = "HTC ";
    public static final int LOGCAT_BUFFER_SIZE = 3000;
    public static final String FAULT = "Logger is off! Please, include the logger in a config file (BuildConfig).";

    /**
     *  Метод возвращающий значение из конфига BuildConfig.
     *  Константа может принимать значение
     *  true - доггер включен
     *  false - логгер выключен
     *
     *  @return boolean
     */
    private static boolean shouldLog() {
        //return BuildConfig.IS_LOGCAT_LOGGER_ENABLED;
<<<<<<< HEAD
        return true;
=======
        return BuildConfig.DEBUG;
>>>>>>> 4a2a4a2a849f4771ede8027f34811bdd87c21b97
    }

    /**
     *  Метод реализующий вывод в лог кастомных сообщений.
     *
     *  @param level
     *  @param tag
     *  @param text
     */
    private static void Logging(int level, String tag, String text) {
        if (shouldLog()) {
            if (text.length() > LOGCAT_BUFFER_SIZE) {
                String stringLog = text;
                while (stringLog.length() > LOGCAT_BUFFER_SIZE) {
                    String substringLog = stringLog.substring(0, LOGCAT_BUFFER_SIZE);
                    stringLog = stringLog.substring(LOGCAT_BUFFER_SIZE);
                    Log.println(level, PREFIX + tag, substringLog);
                }
                Log.println(level, PREFIX + tag, stringLog);
            } else {
                Log.println(level, PREFIX + tag, text);
            }
        } else {
            Log.i(PREFIX + tag, FAULT);
        }
    }

    /**
     *  Вывод лога на уровне verbose.
     *
     *  @param tag
     *  @param text
     */
    public static void v(String tag, String text) {

        Logging(Log.VERBOSE, tag, text);
    }

    /**
     *  Вывод лога на уровне debug.
     *
     *  @param tag
     *  @param text
     */
    public static void d(String tag, String text) {

        Logging(Log.DEBUG, tag, text);
    }

    /**
     *  Вывод лога на уровне info.
     *
     *  @param tag
     *  @param text
     */
    public static void i(String tag, String text){

        Logging(Log.INFO, tag, text);
    }

    /**
     *  Вывод лога на уровне error.
     *
     *  @param tag
     *  @param text
     */
    public static void e(String tag, String text) {

        Logging(Log.ERROR, tag, text);
    }

    /**
     *  Вывод лога на уровне warn.
     *
     *  @param tag
     *  @param text
     */
    public static void w(String tag, String text) {
        Logging(Log.WARN, tag, text);
    }

    /**
     *  Вывод лога на уровне assert.
     *
     *  @param tag
     *  @param text
     */
    public static void a(String tag, String text) {

        Logging(Log.ASSERT, tag, text);
    }
}
>>>>>>> master
