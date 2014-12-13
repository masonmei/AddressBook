package org.personal.mason.common.code.gen.template.java;

import org.personal.mason.common.code.gen.template.FileTemplate;

/**
 * Created by mason on 2014-12-01.
 */
public interface JavaFile extends FileTemplate {

    void addField(JavaFieldPart fieldPart);

    void removeField(JavaFieldPart fieldPart);

    void addAbstractMethod(JavaAbstractMethodPart abstractMethodPart);

    void removeAbstractMethod(JavaAbstractMethodPart abstractMethodPart);

    void addConstructor(JavaConstructorPart constructorPart);

    void removeConstructor(JavaConstructorPart constructorPart);

    void addMethod(JavaMethodPart methodPart);

    void removeMethod(JavaMethodPart methodPart);
}

