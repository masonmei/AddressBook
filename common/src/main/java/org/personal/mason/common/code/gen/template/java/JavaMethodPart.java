package org.personal.mason.common.code.gen.template.java;

import org.personal.mason.common.code.gen.template.java.enums.IsFinal;
import org.personal.mason.common.code.gen.template.java.enums.IsStatic;
import org.personal.mason.common.code.gen.template.java.enums.VisitPrivilege;
import org.personal.mason.common.code.util.Assert;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by mason on 2014-12-01.
 */
public class JavaMethodPart extends AbstractJavaFilePart {

    private final String comment;
    private final VisitPrivilege visitPrivilege;
    private final IsStatic isStatic;
    private final IsFinal isFinal;
    private final String returnType;
    private final String methodName;
    private final JavaMethodParamsPart methodParamsPart;
    private final JavaThrowsPart throwsPart;
    private final JavaMethodLogicalPart methodLogicalPart;

    public JavaMethodPart(String comment, VisitPrivilege visitPrivilege, IsStatic isStatic, IsFinal isFinal,
                          String returnType, String methodName, JavaMethodParamsPart methodParamsPart,
                          JavaThrowsPart throwsPart, JavaMethodLogicalPart methodLogicalPart) {

        Assert.notNull(methodParamsPart, "Java Method Params Part must not be null.");
        Assert.notNull(throwsPart, "Java Method Params Part must not be null.");
        Assert.notNull(methodLogicalPart, "Java Method Params Part must not be null.");

        Assert.hasLength(returnType, "Java Throws Part must have length.");
        Assert.hasLength(methodName, "Java Field Name must have length.");

        this.comment = comment;
        this.visitPrivilege = visitPrivilege;
        this.isStatic = isStatic;
        this.isFinal = isFinal;
        this.returnType = returnType;
        this.methodName = methodName;
        this.methodParamsPart = methodParamsPart;
        this.throwsPart = throwsPart;
        this.methodLogicalPart = methodLogicalPart;
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

    public String getReturnType() {
        return returnType;
    }

    public String getMethodName() {
        return methodName;
    }

    public JavaMethodParamsPart getMethodParamsPart() {
        return methodParamsPart;
    }

    public JavaThrowsPart getThrowsPart() {
        return throwsPart;
    }

    public JavaMethodLogicalPart getMethodLogicalPart() {
        return methodLogicalPart;
    }

    @Override
    public String build() {
        processFields();
        return templateBuilder.toString();
    }

    @Override
    public Set<JavaImportPart> getImports() {
        Set<JavaImportPart> result = new HashSet<JavaImportPart>();

        if (!"void".equals(returnType)) {
            result.add(new JavaImportPart(returnType));
        }

        result.addAll(methodParamsPart.getImports());
        result.addAll(throwsPart.getImports());
        result.addAll(methodLogicalPart.getImports());
        return Collections.unmodifiableSet(result);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof JavaMethodPart)) return false;

        JavaMethodPart that = (JavaMethodPart) o;

        if (methodName != null ? !methodName.equals(that.methodName) : that.methodName != null) return false;
        if (methodParamsPart != null ? !methodParamsPart.equals(that.methodParamsPart) : that.methodParamsPart != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = methodName != null ? methodName.hashCode() : 0;
        result = 31 * result + (methodParamsPart != null ? methodParamsPart.hashCode() : 0);
        return result;
    }
}

