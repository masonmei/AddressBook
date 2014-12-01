package org.personal.mason.common.code.gen.template;

/**
 * Created by mason on 2014-11-27.
 */
public interface Template {

    public String getTemplate();

    public String build();

    public String resolveTemplate(String templatePath);
}

