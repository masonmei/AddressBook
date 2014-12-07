package org.personal.mason.common.code.gen.template.java;


import org.personal.mason.common.code.gen.template.java.enums.IsAbstract;
import org.personal.mason.common.code.gen.template.java.enums.IsFinal;
import org.personal.mason.common.code.gen.template.java.enums.IsStatic;
import org.personal.mason.common.code.gen.template.java.enums.VisitPrivilege;
import org.personal.mason.common.code.util.Assert;

/**
 * Created by mason on 2014-12-01.
 */
public class JavaClassFile extends AbstractJavaFile implements JavaFile {

    private final CopyrightPart copyrightPart;
    private final JavaPackagePart packagePart;
    private final JavaImportsPart importsPart;
    private final JavaExtendsPart extendsPart;
    private final JavaImplementsPart implementsPart;

    private final String comment;
    private final VisitPrivilege visitPrivilege;
    private final IsStatic isStatic;
    private final IsFinal isFinal;
    private final IsAbstract isAbstract;
    private final String className;

    private final JavaFieldsPart fieldsPart;
    private final JavaConstructorsPart constructorsPart;
    private final JavaAbstractMethodsPart abstractMethodsPart;
    private final JavaMethodsPart methodsPart;


    public JavaClassFile(CopyrightPart copyrightPart, JavaPackagePart packagePart, JavaImportsPart importsPart,
                         JavaExtendsPart extendsPart, JavaImplementsPart implementsPart, String comment,
                         VisitPrivilege visitPrivilege, IsStatic isStatic, IsFinal isFinal, IsAbstract isAbstract,
                         String className, JavaFieldsPart fieldsPart, JavaConstructorsPart constructorsPart,
                         JavaAbstractMethodsPart abstractMethodsPart, JavaMethodsPart methodsPart) {
        Assert.notNull(copyrightPart, "Copyright Part must not be null.");
        Assert.notNull(packagePart, "Java Package Part must not be null.");
        Assert.notNull(importsPart, "Java Imports Part must not be null.");
        Assert.notNull(extendsPart, "Java Extends Part must not be null.");
        Assert.notNull(implementsPart, "Java Implements Part must not be null.");
        Assert.notNull(fieldsPart, "Java Fields Part must not be null.");
        Assert.notNull(constructorsPart, "Java Constructors Part must not be null.");
        Assert.notNull(abstractMethodsPart, "Java Abstract Methods Part must not be null.");
        Assert.notNull(methodsPart, "Java Methods Part must not be null.");

        Assert.hasLength(className, "Java Class Name must have length.");
        if(comment == null) {
            comment = "";
        }

        if(visitPrivilege == null) {
            visitPrivilege = VisitPrivilege.DEFAULT;
        }

        if(isAbstract == null) {
            isAbstract = IsAbstract.DEFAULT;
        }

        if(isFinal == null) {
            isFinal = IsFinal.DEFAULT;
        }

        if(isStatic == null) {
            isStatic = IsStatic.DEFAULT;
        }

        if(isAbstract != IsAbstract.DEFAULT) {
            isFinal = IsFinal.DEFAULT;
            isStatic = IsStatic.DEFAULT;
        }


        this.copyrightPart = copyrightPart;
        this.packagePart = packagePart;
        this.importsPart = importsPart;
        this.extendsPart = extendsPart;
        this.implementsPart = implementsPart;
        this.comment = comment;
        this.visitPrivilege = visitPrivilege;
        this.isStatic = isStatic;
        this.isFinal = isFinal;
        this.isAbstract = isAbstract;
        this.className = className;
        this.fieldsPart = fieldsPart;
        this.constructorsPart = constructorsPart;
        this.abstractMethodsPart = abstractMethodsPart;
        this.methodsPart = methodsPart;
    }

    public CopyrightPart getCopyrightPart() {
        return copyrightPart;
    }

    public JavaPackagePart getPackagePart() {
        return packagePart;
    }

    public JavaImportsPart getImportsPart() {
        return importsPart;
    }

    public JavaExtendsPart getExtendsPart() {
        return extendsPart;
    }

    public JavaImplementsPart getImplementsPart() {
        return implementsPart;
    }

    public String getComment() {
        return comment;
    }

    public VisitPrivilege getVisitPrivilege() {
        return visitPrivilege;
    }

    public IsStatic getIsStatic() {
        return isStatic;
    }

    public IsFinal getIsFinal() {
        return isFinal;
    }

    public IsAbstract getIsAbstract() {
        return isAbstract;
    }

    public String getClassName() {
        return className;
    }

    public JavaFieldsPart getFieldsPart() {
        return fieldsPart;
    }

    public JavaConstructorsPart getConstructorsPart() {
        return constructorsPart;
    }

    public JavaAbstractMethodsPart getAbstractMethodsPart() {
        return abstractMethodsPart;
    }

    public JavaMethodsPart getMethodsPart() {
        return methodsPart;
    }

    @Override
    public String build() {
        return null;
    }
}

