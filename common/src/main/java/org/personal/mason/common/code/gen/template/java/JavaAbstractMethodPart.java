package org.personal.mason.common.code.gen.template.java;

import org.personal.mason.common.code.util.Assert;

import java.util.*;

/**
 * Created by m00290368 on 2014-12-02.
 */
public class JavaAbstractMethodPart extends AbstractJavaFilePart {

    private final JavaImportsPart importsPart;
    private final String returnType;
    private final String methodName;
    private final JavaMethodParamsPart paramsPart;
    private final JavaThrowsPart throwsPart;

    private final Set<String> imports = new HashSet<String>();

    public JavaAbstractMethodPart(String returnType, String methodName) {
        this(new JavaImportsPart(), returnType, methodName, new JavaMethodParamsPart(), new JavaThrowsPart());
    }

    public JavaAbstractMethodPart(JavaImportsPart importsPart, String returnType, String methodName,
                                  JavaMethodParamsPart paramsPart, JavaThrowsPart throwsPart) {
        Assert.notNull(importsPart, "Java Imports Part must not be null.");
        Assert.notNull(paramsPart, "Java Method Params Part must not be null.");
        Assert.notNull(throwsPart, "Java Throws Part must not be null");
        Assert.hasLength(methodName, "Method Name must have length.");
        Assert.hasLength(returnType, "Return Type must not be null.");
        this.importsPart = importsPart;
        this.returnType = returnType;
        this.methodName = methodName;
        this.paramsPart = paramsPart;
        this.throwsPart = throwsPart;
    }

    public JavaImportsPart getImportsPart() {
        return importsPart;
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
    public String build() {
        return null;
    }

    @Override
    public Set<String> getImports() {
        return Collections.unmodifiableSet(imports);
    }
}
