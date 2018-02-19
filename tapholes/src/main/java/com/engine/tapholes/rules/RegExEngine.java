package com.engine.tapholes.rules;

import com.engine.tapholes.rules.Matcher.GregorianDateMatcher;
import org.jsoup.helper.StringUtil;

public class RegExEngine {
    public boolean IsEffectiveDate(String fileContents) {
        if (StringUtil.isBlank(fileContents)) {
            return false;
        }
        GregorianDateMatcher matcher = new GregorianDateMatcher();
        return matcher.matches(fileContents);
    }
}