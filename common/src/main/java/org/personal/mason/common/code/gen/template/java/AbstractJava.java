package org.personal.mason.common.code.gen.template.java;

import org.apache.commons.io.IOUtils;
import org.personal.mason.common.code.gen.template.Template;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by mason on 2014-12-01.
 */
public abstract class AbstractJava implements Template {

    private final String template;

    public AbstractJava() {
        this(null);
    }

    public AbstractJava(String templateFileName) {
        if (templateFileName == null) {
            this.template = resolveTemplate(getPathString());
        } else {
            this.template = resolveTemplate(templateFileName);
        }
    }

    @Override
    public String getTemplate() {
        return template;
    }

    @Override
    public String resolveTemplate(String templatePath) {
        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream(templatePath)) {
            return IOUtils.toString(inputStream, "UTF-8");
        } catch (IOException e) {
            throw new IllegalStateException("Cannot find template with in current package.");
        }
    }

    protected String getPathString() {
        return getClass().getName().replaceAll("\\.", "/") + ".tm";
    }

}

