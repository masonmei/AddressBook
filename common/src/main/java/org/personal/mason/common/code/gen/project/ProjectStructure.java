package org.personal.mason.common.code.gen.project;

import org.personal.mason.common.code.gen.common.Structure;

import java.io.File;

/**
 * Created by m00290368 on 2014-11-27.
 */
public interface ProjectStructure<T> extends Structure<T> {

    public String getDescription();

    public File getBasePath();

}
