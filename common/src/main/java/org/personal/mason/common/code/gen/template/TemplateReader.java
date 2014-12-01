package org.personal.mason.common.code.gen.template;

/**
 *
 * Read from the template file And generate a memory Template
 *
 * Created by mason on 2014-12-01.
 */
public interface TemplateReader<T> {

    /**
     * Read from file.
     */
    T read();
}

