package org.personal.mason.axon;

import org.personal.mason.common.code.gen.template.java.*;

/**
 * Created by mason on 12/15/14.
 */
public abstract class BaseGen {

    protected JavaImportsPart importsPart = new JavaImportsPart();
    protected JavaExtendsPart extendsPart = new JavaExtendsPart();
    protected JavaFieldsPart fieldsPart = new JavaFieldsPart();
    protected JavaAbstractMethodsPart abstractMethodsPart = new JavaAbstractMethodsPart();
    protected JavaMethodsPart methodsPart = new JavaMethodsPart();
    protected JavaConstructorsPart constructorsPart = new JavaConstructorsPart();

    protected BaseGen() {
    }

    public JavaImportsPart getImportsPart() {
        return importsPart;
    }

    public JavaExtendsPart getExtendsPart() {
        return extendsPart;
    }

    public JavaFieldsPart getFieldsPart() {
        return fieldsPart;
    }

    public JavaAbstractMethodsPart getAbstractMethodsPart() {
        return abstractMethodsPart;
    }

    public JavaMethodsPart getMethodsPart() {
        return methodsPart;
    }

    public JavaConstructorsPart getConstructorsPart() {
        return constructorsPart;
    }

    public abstract void generate();
}
