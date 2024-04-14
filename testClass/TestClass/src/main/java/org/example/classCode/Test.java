package org.example.classCode;

import java.util.concurrent.TimeUnit;

public class Test {
    public static int patternIndex(String subject, String pattern) {
        final int NOTFOUND = -1;
        int iSub = 0, rtnIndex = NOTFOUND;
        boolean isPat = false;
        int subjectLen = subject.length();
        int patternLen = pattern.length();

        while (!isPat && iSub + patternLen - 1 < subjectLen) {
            if (subject.charAt(iSub) == pattern.charAt(0)) {
                rtnIndex = iSub;
                isPat = true;
                for (int iPat = 1; iPat < patternLen; iPat++) {
                    if (subject.charAt(iSub + iPat) != pattern.charAt(iPat)) {
                        rtnIndex = NOTFOUND;
                        isPat = false;
                        break;

                    }
                }
            }
            iSub++;
        }

        return (rtnIndex);
    }


    public static void main(String[] args) {
        System.out.println(patternIndex("aaaaaaa", "aaaa"));
    }
}

