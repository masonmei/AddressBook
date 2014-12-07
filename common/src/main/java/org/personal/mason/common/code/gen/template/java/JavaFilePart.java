package org.personal.mason.common.code.gen.template.java;

import org.personal.mason.common.code.gen.template.FilePartTemplate;

import java.util.Set;

/**
 * Created by mason on 2014-12-01.
 */
public interface JavaFilePart extends FilePartTemplate {

    /**
     * Get all the class name that imported.
     *
     * @return
     */
    public Set<String> getImports();

}

