package org.personal.mason.common.code.gen.template.java;

/**
 * Created by mason on 2014-12-01.
 */
public abstract class AbstractJavaFilePart extends AbstractJava implements JavaFilePart {

    public AbstractJavaFilePart() {
        this(null);
    }

    public AbstractJavaFilePart(String templateFileName) {
        super(templateFileName);
    }

    @Override
    public String build() {
        if (!handleMultiplePart()) {
            processFields();
        }
        return templateBuilder.toString();
    }


}

