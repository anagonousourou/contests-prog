using System;
using System.Text.RegularExpressions;
static class LogLine
{
    
    public static string Message(string logLine)
    {
        return logLine.Split(":")[1].Trim();
    }

    public static string LogLevel(string logLine)
    {
        string pattern = @"\[(.*?)\]";
        var match = Regex.Matches(logLine, pattern, RegexOptions.IgnoreCase)[0];
        return match.Groups[1].Value.ToLower();
    }

    public static string Reformat(string logLine)
    {
        return $"{Message(logLine)} ({LogLevel(logLine)})";
    }
}
