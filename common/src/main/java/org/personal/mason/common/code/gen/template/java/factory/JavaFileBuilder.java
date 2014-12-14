package org.personal.mason.common.code.gen.template.java.factory;

import org.personal.mason.common.code.gen.template.java.*;
import org.personal.mason.common.code.gen.template.java.enums.IsAbstract;
import org.personal.mason.common.code.gen.template.java.enums.IsFinal;
import org.personal.mason.common.code.gen.template.java.enums.VisitPrivilege;

/**
 * Created by mason on 12/13/14.
 */
public interface JavaFileBuilder {

    JavaFileBuilder copyrightPart(CopyrightPart copyrightPart);
    JavaFileBuilder packagePart(JavaPackagePart packagePart);
    JavaFileBuilder importsPart(JavaImportsPart importsPart);
    JavaFileBuilder extendsPart(JavaExtendsPart extendsPart);
    JavaFileBuilder implementsPart(JavaImplementsPart implementsPart);
    JavaFileBuilder comment(String comment);
    JavaFileBuilder visitPrivilege(VisitPrivilege visitPrivilege);
    JavaFileBuilder isFinal(IsFinal isFinal);
    JavaFileBuilder isAbstract(IsAbstract isAbstract);
    JavaFileBuilder className(String className);
    JavaFileBuilder fieldsPart(JavaFieldsPart fieldsPart);
    JavaFileBuilder constructorsPart(JavaConstructorsPart constructorsPart);
    JavaFileBuilder abstractMethodsPart(JavaAbstractMethodsPart abstractMethodsPart);
    JavaFileBuilder methodsPart(JavaMethodsPart methodsPart);
    AbstractJavaFile build();
}
