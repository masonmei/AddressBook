package org.personal.mason.common.code.gen.template.java;

import org.personal.mason.common.code.gen.template.java.enums.VisitPrivilege;
import org.personal.mason.common.code.util.Assert;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by m00290368 on 2014-12-02.
 */
public class JavaConstructorPart extends AbstractJavaFilePart {

    private final String comment;
    private final VisitPrivilege visitPrivilege;
    private final String constructorName;
    private final JavaMethodParamsPart methodParamsPart;
    private final JavaThrowsPart throwsPart;
    private final JavaMethodLogicalPart logicalPart;

    public JavaConstructorPart(String comment, VisitPrivilege visitPrivilege, String constructorName) {
        this(comment, visitPrivilege, constructorName, new JavaMethodParamsPart(), new JavaThrowsPart(),
                JavaMethodLogicalBuilder.createBuilder().build());
    }

    public JavaConstructorPart(String comment, VisitPrivilege visitPrivilege, String constructorName,
                               JavaMethodParamsPart methodParamsPart, JavaThrowsPart throwsPart,
                               JavaMethodLogicalPart logicalPart) {
        Assert.hasLength(constructorName, "Constructor Name must have length.");
        Assert.notNull(methodParamsPart, "Java Method Params Part must not be null.");
        Assert.notNull(throwsPart, "Java Throws Part must not be null.");
        Assert.notNull(logicalPart, "Java Method Logical Part must not be null.");

        if (comment == null) {
            comment = "";
        }
        this.comment = comment;

        if (visitPrivilege == null) {
            visitPrivilege = VisitPrivilege.DEFAULT;
        }
        this.visitPrivilege = visitPrivilege;
        this.constructorName = constructorName;
        this.methodParamsPart = methodParamsPart;
        this.throwsPart = throwsPart;
        this.logicalPart = logicalPart;
    }

    public String getComment() {
        return comment;
    }

    public VisitPrivilege getVisitPrivilege() {
        return visitPrivilege;
    }

    public String getConstructorName() {
        return constructorName;
    }

    public JavaMethodParamsPart getMethodParamsPart() {
        return methodParamsPart;
    }

    public JavaThrowsPart getThrowsPart() {
        return throwsPart;
    }

    public JavaMethodLogicalPart getLogicalPart() {
        return logicalPart;
    }

    @Override
    public Set<JavaImportPart> getImports() {
        Set<JavaImportPart> imports = new HashSet<JavaImportPart>();
        imports.addAll(methodParamsPart.getImports());
        imports.addAll(throwsPart.getImports());
        imports.addAll(logicalPart.getImports());
        return Collections.unmodifiableSet(imports);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof JavaConstructorPart)) return false;

        JavaConstructorPart that = (JavaConstructorPart) o;

        if (constructorName != null ? !constructorName.equals(that.constructorName) : that.constructorName != null)
            return false;
        if (methodParamsPart != null ? !methodParamsPart.equals(that.methodParamsPart) : that.methodParamsPart != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = constructorName != null ? constructorName.hashCode() : 0;
        result = 31 * result + (methodParamsPart != null ? methodParamsPart.hashCode() : 0);
        return result;
    }
}
