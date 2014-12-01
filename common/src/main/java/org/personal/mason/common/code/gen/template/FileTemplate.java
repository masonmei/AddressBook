package org.personal.mason.common.code.gen.template;

import java.util.List;

/**
 * Created by mason on 2014-12-01.
 */
public interface FileTemplate<T extends FilePartTemplate> extends Template {

    public List<T> getFileParts();

    public void addFilePart(T... filePartTemplate);

    public String resolveTemplate(String templatePath);
}

