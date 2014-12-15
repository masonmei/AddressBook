package org.personal.mason.common.code.gen.project.java.element;

import org.personal.mason.common.code.util.StringUtils;

/**
 * Created by m00290368 on 2014-11-27.
 */
public class JavaPackageElement extends JavaSourceDirectoryElement implements JavaElement {

    public JavaPackageElement(String name, JavaSourceDirectoryElement parent) {
        super(StringUtils.packageToPath(name), parent);
    }
}
