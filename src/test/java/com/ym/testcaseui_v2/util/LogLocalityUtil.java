package com.ym.testcaseui_v2.util;

// log.info(LogLocalityUtil.getLogLocality()+"try日志信息打印");
public class LogLocalityUtil {
    private static StringBuilder sb = new StringBuilder();
    public static String getLogLocality(){
        if(sb != null){
            sb.setLength(0);
        }
        StackTraceElement[] trace = Thread.currentThread().getStackTrace();
        StackTraceElement tmp = trace[2];
        return sb.append(tmp.getMethodName())
                .append("(")
                .append(tmp.getFileName())
                .append(":")
                .append(tmp.getLineNumber())
                .append(")").toString();
    }
}
