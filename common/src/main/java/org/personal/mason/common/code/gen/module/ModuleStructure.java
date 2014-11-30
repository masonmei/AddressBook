package org.personal.mason.common.code.gen.module;

import org.personal.mason.common.code.gen.common.Structure;

/**
 * Created by m00290368 on 2014-11-27.
 */
public interface ModuleStructure<T> extends Structure<T> {

    public Structure getParent();
}
