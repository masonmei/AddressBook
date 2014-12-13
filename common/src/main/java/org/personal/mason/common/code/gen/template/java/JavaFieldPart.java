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
public class JavaFieldPart extends AbstractJavaFilePart {
    private final String comment;
    private final VisitPrivilege visitPrivilege;
    private final IsStatic isStatic;
    private final IsFinal isFinal;
    private final String fieldType;
    private final String fieldName;
    private final JavaInitialPart initialPart;

    public JavaFieldPart(String comment, VisitPrivilege visitPrivilege, IsStatic isStatic, IsFinal isFinal,
                         String fieldType, String fieldName, JavaInitialPart initialPart) {
        Assert.notNull(initialPart, "Java initial Part must not be null.");
        Assert.hasLength(fieldType, "Java Field Type must have length.");
        Assert.hasLength(fieldName, "Java Field Name must have length.");

        if (comment == null) {
            comment = "";
        }

        if (visitPrivilege == null) {
            visitPrivilege = VisitPrivilege.DEFAULT;
        }

        if (isStatic == null) {
            isStatic = IsStatic.DEFAULT;
        }

        if (isFinal == null) {
            isFinal = IsFinal.DEFAULT;
        }

        this.comment = comment;
        this.visitPrivilege = visitPrivilege;
        this.isStatic = isStatic;
        this.isFinal = isFinal;
        this.fieldType = fieldType;
        this.fieldName = fieldName;
        this.initialPart = initialPart;
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

    public String getFieldType() {
        return fieldType;
    }

    public String getFieldName() {
        return fieldName;
    }

    public JavaInitialPart getInitialPart() {
        return initialPart;
    }

    @Override
    public Set<JavaImportPart> getImports() {
        Set<JavaImportPart> result = new HashSet<JavaImportPart>();
        result.add(new JavaImportPart(fieldType));
        result.addAll(initialPart.getImports());
        return Collections.unmodifiableSet(result);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof JavaFieldPart)) return false;

        JavaFieldPart that = (JavaFieldPart) o;

        if (fieldName != null ? !fieldName.equals(that.fieldName) : that.fieldName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return fieldName != null ? fieldName.hashCode() : 0;
    }
}

