package org.personal.mason.common.code.gen.template.java;

import org.personal.mason.common.code.gen.template.java.enums.VisitPrivilege;
import org.personal.mason.common.code.util.Assert;

/**
 * Created by m00290368 on 2014-12-02.
 */
public class JavaConstructorPart extends AbstractJavaFilePart {

    private final JavaImportsPart importsPart;
    private final String comment;
    private final VisitPrivilege visitPrivilege;
    private final String constructorName;
    private final JavaMethodParamsPart methodParamsPart;
    private final JavaThrowsPart throwsPart;
    private final JavaMethodLogicalPart logicalPart;

    public JavaConstructorPart(String comment, VisitPrivilege visitPrivilege, String constructorName) {
        this(new JavaImportsPart(), comment, visitPrivilege, constructorName, new JavaMethodParamsPart(),
                new JavaThrowsPart(), JavaMethodLogicalBuilder.createBuilder().build());
    }

    public JavaConstructorPart(JavaImportsPart importsPart, String comment, VisitPrivilege visitPrivilege,
                               String constructorName, JavaMethodParamsPart methodParamsPart, JavaThrowsPart throwsPart,
                               JavaMethodLogicalPart logicalPart) {
        Assert.notNull(importsPart, "Java Imports Part must not be null.");
        Assert.hasLength(constructorName, "Constructor Name must have length.");
        Assert.notNull(methodParamsPart, "Java Method Params Part must not be null.");
        Assert.notNull(throwsPart, "Java Throws Part must not be null.");
        Assert.notNull(logicalPart, "Java Method Logical Part must not be null.");
        this.importsPart = importsPart;
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

    public JavaImportsPart getImportsPart() {
        return importsPart;
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
    public String build() {
        return null;
    }
}
