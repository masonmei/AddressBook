package org.personal.mason.axon;

import org.personal.mason.common.code.gen.template.java.*;
import org.personal.mason.common.code.gen.template.java.enums.IsAbstract;
import org.personal.mason.common.code.gen.template.java.enums.IsFinal;
import org.personal.mason.common.code.gen.template.java.enums.VisitPrivilege;

/**
 * Created by mason on 12/13/14.
 */
public class CommandGen extends JavaClassFile {

    public CommandGen(CopyrightPart copyrightPart, JavaPackagePart packagePart, JavaImportsPart importsPart,
                      JavaExtendsPart extendsPart, JavaImplementsPart implementsPart, String comment,
                      VisitPrivilege visitPrivilege, IsFinal isFinal, IsAbstract isAbstract, String className,
                      JavaFieldsPart fieldsPart, JavaConstructorsPart constructorsPart,
                      JavaAbstractMethodsPart abstractMethodsPart, JavaMethodsPart methodsPart) {
        super(copyrightPart, packagePart, importsPart, extendsPart, implementsPart, comment, visitPrivilege, isFinal, isAbstract, className, fieldsPart, constructorsPart, abstractMethodsPart, methodsPart);
    }
}
