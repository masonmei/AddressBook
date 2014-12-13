package org.personal.mason.common.code.gen.template.java;

import org.personal.mason.common.code.gen.template.java.enums.VisitPrivilege;
import org.personal.mason.common.code.util.Assert;

/**
 * Created by mason on 2014-12-01.
 */
public class JavaInterfaceFile extends AbstractJavaFile implements JavaFile {
    private final CopyrightPart copyrightPart;
    private final JavaPackagePart packagePart;
    private final JavaImportsPart importsPart;
    private final String comment;
    private final VisitPrivilege visitPrivilege;
    private final String className;
    private final JavaExtendsPart extendsPart;

    private final JavaFieldsPart fieldsPart;
    private final JavaAbstractMethodsPart methodsPart;

    public JavaInterfaceFile(CopyrightPart copyrightPart, JavaPackagePart packagePart, JavaImportsPart importsPart,
                             String comment, VisitPrivilege visitPrivilege, String className,
                             JavaExtendsPart extendsPart, JavaFieldsPart fieldsPart, JavaAbstractMethodsPart methodsPart) {
        Assert.notNull(copyrightPart, "Copyright Part must not be null.");
        Assert.notNull(packagePart, "Java Package Part must not be null.");
        Assert.notNull(importsPart, "Java Imports Part must not be null.");
        Assert.notNull(extendsPart, "Java Extends Part must not be null.");
        Assert.notNull(fieldsPart, "Java Fields Part must not be null.");
        Assert.notNull(methodsPart, "Java Methods Part must not be null.");

        Assert.hasLength(className, "Java Class Name must have length.");
        if (comment == null) {
            comment = "";
        }

        if (visitPrivilege == null) {
            visitPrivilege = VisitPrivilege.DEFAULT;
        }

        this.copyrightPart = copyrightPart;
        this.packagePart = packagePart;
        this.importsPart = importsPart;
        this.comment = comment;
        this.visitPrivilege = visitPrivilege;
        this.className = className;
        this.extendsPart = extendsPart;
        this.fieldsPart = fieldsPart;
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

    public String getComment() {
        return comment;
    }

    public VisitPrivilege getVisitPrivilege() {
        return visitPrivilege;
    }

    public String getClassName() {
        return className;
    }

    public JavaExtendsPart getExtendsPart() {
        return extendsPart;
    }

    public JavaFieldsPart getFieldsPart() {
        return fieldsPart;
    }

    public JavaAbstractMethodsPart getMethodsPart() {
        return methodsPart;
    }

    @Override
    protected void collectImports() {
        collectJavaFilePartImports(copyrightPart.getImports());
        collectJavaFilePartImports(packagePart.getImports());
        collectJavaFilePartImports(importsPart.getImports());
        collectJavaFilePartImports(extendsPart.getImports());
        collectJavaFilePartImports(fieldsPart.getImports());
        collectJavaFilePartImports(methodsPart.getImports());
    }

    @Override
    public void addField(JavaFieldPart fieldPart) {
        fieldsPart.addParts(fieldPart);
    }

    @Override
    public void removeField(JavaFieldPart fieldPart) {
        fieldsPart.getFieldParts().remove(fieldPart);
    }

    @Override
    public void addAbstractMethod(JavaAbstractMethodPart abstractMethodPart) {
        methodsPart.addParts(abstractMethodPart);
    }

    @Override
    public void removeAbstractMethod(JavaAbstractMethodPart abstractMethodPart) {
        methodsPart.getAbstractMethodParts().remove(abstractMethodPart);
    }

    @Override
    public void addConstructor(JavaConstructorPart constructorPart) {
        throw new UnsupportedOperationException("Cannnot add constructor to an interface.");
    }

    @Override
    public void removeConstructor(JavaConstructorPart constructorPart) {
        throw new UnsupportedOperationException("Cannnot remove constructor from an interface.");
    }

    @Override
    public void addMethod(JavaMethodPart methodPart) {
        throw new UnsupportedOperationException("Cannnot add non-abstract method to an interface.");
    }

    @Override
    public void removeMethod(JavaMethodPart methodPart) {
        throw new UnsupportedOperationException("Cannnot remove non-abstract method from an interface.");
    }
}

