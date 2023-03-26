public class LogLevels {
    
    private static String errorStart = "[ERROR]: ";
    private static String warningStart = "[WARNING]: ";
    private static String infoStart = "[INFO]: ";
    public static String message(String logLine) {
        if(logLine.startsWith(errorStart)){
            return logLine.substring(errorStart.length()).strip();
        }
        else if(logLine.startsWith(warningStart)){
            return logLine.substring(warningStart.length()).strip();
        }
        else if(logLine.startsWith(infoStart)){
            return logLine.substring(infoStart.length()).strip();
        }
        return logLine;
    }

    public static String logLevel(String logLine) {
        if(logLine.startsWith(errorStart)){
            return "error";
        }
        else if(logLine.startsWith(warningStart)){
            return "warning";
        }
        else if(logLine.startsWith(infoStart)){
            return "info";
        }
        return null;
    }

    public static String reformat(String logLine) {
        return message(logLine)+" (%s)".formatted(logLevel(logLine));
    }
}
