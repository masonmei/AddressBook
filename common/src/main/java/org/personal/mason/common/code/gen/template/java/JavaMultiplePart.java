package org.personal.mason.common.code.gen.template.java;

import java.util.Iterator;

/**
 * Created by m00290368 on 2014-12-05.
 */
public interface JavaMultiplePart<T extends AbstractJavaFilePart> {

    /**
     * Get all the element parts iterator.
     *
     * @return
     */
    Iterator<T> getParts();

    /**
     * Add parts to the element parts.
     *
     * @param parts
     */
    void addParts(T... parts);
}
