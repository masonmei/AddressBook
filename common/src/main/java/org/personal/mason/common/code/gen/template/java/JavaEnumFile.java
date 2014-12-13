package org.personal.mason.common.code.gen.template.java;

import org.personal.mason.common.code.gen.template.java.enums.VisitPrivilege;
import org.personal.mason.common.code.util.Assert;

/**
 * Created by mason on 2014-12-01.
 */
public class JavaEnumFile extends AbstractJavaFile implements JavaFile {
    private final CopyrightPart copyrightPart;
    private final JavaPackagePart packagePart;
    private final JavaImportsPart importsPart;
    private final String comment;
    private final VisitPrivilege visitPrivilege;
    private final String className;
    private final JavaEnumElementsPart enumElementsPart;
    private final JavaFieldsPart fieldsPart;
    private final JavaConstructorsPart constructorsPart;
    private final JavaMethodsPart methodsPart;

    public JavaEnumFile(CopyrightPart copyrightPart, JavaPackagePart packagePart, JavaImportsPart importsPart,
                        String comment, VisitPrivilege visitPrivilege, String className,
                        JavaEnumElementsPart enumElementsPart, JavaFieldsPart fieldsPart,
                        JavaConstructorsPart constructorsPart, JavaMethodsPart methodsPart) {
        Assert.notNull(copyrightPart, "Copyright Part must not be null.");
        Assert.notNull(packagePart, "Java Package Part must not be null.");
        Assert.notNull(importsPart, "Java Imports Part must not be null.");
        Assert.notNull(enumElementsPart, "Java Enum Elements Part must not be null.");
        Assert.notNull(fieldsPart, "Java Fields Part must not be null.");
        Assert.notNull(constructorsPart, "Java Constructors Part must not be null.");
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
        this.enumElementsPart = enumElementsPart;
        this.fieldsPart = fieldsPart;
        this.constructorsPart = constructorsPart;
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

    public JavaEnumElementsPart getEnumElementsPart() {
        return enumElementsPart;
    }

    public JavaFieldsPart getFieldsPart() {
        return fieldsPart;
    }

    public JavaConstructorsPart getConstructorsPart() {
        return constructorsPart;
    }

    public JavaMethodsPart getMethodsPart() {
        return methodsPart;
    }

    @Override
    protected void collectImports() {
        collectJavaFilePartImports(copyrightPart.getImports());
        collectJavaFilePartImports(packagePart.getImports());
        collectJavaFilePartImports(importsPart.getImports());
        collectJavaFilePartImports(enumElementsPart.getImports());
        collectJavaFilePartImports(fieldsPart.getImports());
        collectJavaFilePartImports(constructorsPart.getImports());
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
        throw new UnsupportedOperationException("Not Support to add an abstract method to enum class.");
    }

    @Override
    public void removeAbstractMethod(JavaAbstractMethodPart abstractMethodPart) {
        throw new UnsupportedOperationException("Not Support to remove an abstract method from enum class.");
    }

    @Override
    public void addConstructor(JavaConstructorPart constructorPart) {
        constructorsPart.addParts(constructorPart);
    }

    @Override
    public void removeConstructor(JavaConstructorPart constructorPart) {
        constructorsPart.getConstructorParts().remove(constructorPart);
    }

    @Override
    public void addMethod(JavaMethodPart methodPart) {
        methodsPart.addParts(methodPart);
    }

    @Override
    public void removeMethod(JavaMethodPart methodPart) {
        methodsPart.getMethodParts().remove(methodPart);
    }
}

