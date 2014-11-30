package org.personal.mason.common.code.gen.project;

import org.personal.mason.common.code.gen.module.Module;
import org.personal.mason.common.code.gen.common.Structure;

import java.util.Iterator;

/**
 * Created by m00290368 on 2014-11-27.
 */
public interface Project {

    String getName();

    Iterator<Module> getModules();

}
