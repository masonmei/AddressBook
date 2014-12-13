package org.personal.mason.common.code.gen.template;

/**
 * Write the template to file.
 * <p/>
 * Created by mason on 2014-12-01.
 */
public interface TemplateWriter<T> {

    /**
     * Write to file
     */
    void write(T template);
}

