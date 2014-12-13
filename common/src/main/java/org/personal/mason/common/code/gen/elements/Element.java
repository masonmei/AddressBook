package org.personal.mason.common.code.gen.elements;

/**
 * Created by m00290368 on 2014-11-27.
 */
public interface Element {

    /**
     * The name of this elements. Must be unique in parent folder.
     *
     * @return
     */
    String getName();

    /**
     * The Parent Container which contain this element.
     *
     * @return
     */
    Containable getParent();

    /**
     * Construct this element in the parent folder.
     * <p/>
     * If this is an folder element, recursive create the sub elements.
     */
    void construct();
}
