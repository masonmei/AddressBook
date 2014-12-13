package org.personal.mason.common.code.gen.template.java;

import org.personal.mason.common.code.gen.template.java.enums.IsAbstract;
import org.personal.mason.common.code.util.Assert;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by m00290368 on 2014-12-02.
 */
public class JavaAbstractMethodPart extends AbstractJavaFilePart {

    private final String comment;
    private final IsAbstract isAbstract;
    private final String returnType;
    private final String methodName;
    private final JavaMethodParamsPart paramsPart;
    private final JavaThrowsPart throwsPart;

    public JavaAbstractMethodPart(String comment, IsAbstract isAbstract, String returnType, String methodName) {
        this(comment, isAbstract, returnType, methodName, new JavaMethodParamsPart(), new JavaThrowsPart());
    }

    public JavaAbstractMethodPart(String comment, IsAbstract isAbstract, String returnType, String methodName,
                                  JavaMethodParamsPart paramsPart, JavaThrowsPart throwsPart) {
        Assert.notNull(paramsPart, "Java Method Params Part must not be null.");
        Assert.notNull(throwsPart, "Java Throws Part must not be null");
        Assert.hasLength(methodName, "Method Name must have length.");
        Assert.hasLength(returnType, "Return Type must not be null.");

        if (comment == null) {
            comment = "";
        }
        if (isAbstract == null) {
            isAbstract = IsAbstract.DEFAULT;
        }
        this.comment = comment;
        this.isAbstract = isAbstract;
        this.returnType = returnType;
        this.methodName = methodName;
        this.paramsPart = paramsPart;
        this.throwsPart = throwsPart;
    }

    public String getComment() {
        return comment;
    }

    public IsAbstract getIsAbstract() {
        return isAbstract;
    }

    public String getReturnType() {
        return returnType;
    }

    public String getMethodName() {
        return methodName;
    }

    public JavaMethodParamsPart getParamsPart() {
        return paramsPart;
    }

    public JavaThrowsPart getThrowsPart() {
        return throwsPart;
    }

    @Override
    public Set<JavaImportPart> getImports() {
        Set<JavaImportPart> imports = new HashSet<JavaImportPart>();
        imports.add(new JavaImportPart(returnType));
        imports.addAll(paramsPart.getImports());
        imports.addAll(throwsPart.getImports());
        return Collections.unmodifiableSet(imports);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof JavaAbstractMethodPart)) return false;

        JavaAbstractMethodPart that = (JavaAbstractMethodPart) o;

        if (methodName != null ? !methodName.equals(that.methodName) : that.methodName != null) return false;
        if (paramsPart != null ? !paramsPart.equals(that.paramsPart) : that.paramsPart != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = methodName != null ? methodName.hashCode() : 0;
        result = 31 * result + (paramsPart != null ? paramsPart.hashCode() : 0);
        return result;
    }
}
