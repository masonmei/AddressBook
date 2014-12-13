package org.personal.mason.common.code.gen.template.java;

import org.personal.mason.common.code.gen.MetaData;
import org.personal.mason.common.code.gen.template.java.enums.IsFinal;
import org.personal.mason.common.code.gen.template.java.enums.IsStatic;
import org.personal.mason.common.code.gen.template.java.enums.VisitPrivilege;

/**
 * Created by mason on 2014-12-01.
 */
public class JavaMetaData extends MetaData {

    private static final String EMPTY_STRING = "";
    private static final String VOID = "void";

    private static final String VISIT_PRIVILEGE = "visitPrivilege";
    private static final String IS_STATIC = "isStatic";
    private static final String IS_FINAL = "isFinal";
    private static final String COMMENT = "comment";

    private static final String FIELD_TYPE = "fieldType";
    private static final String FIELD_NAME = "fieldName";

    private static final String PACKAGE_NAME = "packageName";

    private static final String RETURN_TYPE = "returnType";
    private static final String METHOD_NAME = "methodName";
    private static final String METHOD_PARAM = "methodParam";
    private static final String METHOD_RETURN = "methodReturn";

    private static final String CLASS_NAME = "className";


    public String visitPrivilege() {
        VisitPrivilege privilege = (VisitPrivilege) get(VISIT_PRIVILEGE);
        if (privilege == VisitPrivilege.DEFAULT) {
            return EMPTY_STRING;
        }
        return privilege.name().toLowerCase();
    }

    public String isStatic() {
        IsStatic isStatic = (IsStatic) get(IS_STATIC);
        if (isStatic == IsStatic.DEFAULT) {
            return EMPTY_STRING;
        }
        return isStatic.name().toLowerCase();
    }

    public String isFinal() {
        IsFinal isFinal = (IsFinal) get(IS_FINAL);
        if (isFinal == IsFinal.DEFAULT) {
            return EMPTY_STRING;
        }
        return isFinal.name().toLowerCase();
    }

    public String comment() {
        Object comment = get(COMMENT);
        if (comment == null) {
            return EMPTY_STRING;
        }
        return (String) comment;
    }

    public String fieldType() {
        Object fieldType = get(FIELD_TYPE);
        if (fieldType == null) {
            return VOID;
        }
        return (String) fieldType;
    }

    public String fieldName() {
        Object fieldName = get(FIELD_NAME);
        if (fieldName == null) {
            throw new IllegalStateException("Field name must not be null");
        }
        return (String) fieldName;
    }

    public String packageName() {
        return null;
    }

}

